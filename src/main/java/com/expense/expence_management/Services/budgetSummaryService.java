package com.expense.expence_management.Services;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.Budget;
import com.expense.expence_management.Entity.BudgetSummary;
import com.expense.expence_management.Entity.Transaction;
import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Repo.BudgetRepo;
import com.expense.expence_management.Repo.TransactionRepo;
import com.expense.expence_management.Repo.UserRepo;

@Service
public class budgetSummaryService {

    private final BudgetRepo budgetRepo;
    private final TransactionRepo transactionRepo;
    private final UserRepo userRepo;

    public budgetSummaryService(
            BudgetRepo budgetRepo,
            TransactionRepo transactionRepo,
            UserRepo userRepo) {

        this.budgetRepo = budgetRepo;
        this.transactionRepo = transactionRepo;
        this.userRepo = userRepo;
    }

    public BudgetSummary getBudgetSummary(
            Authentication authentication,
            String month,
            int year) {

        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Find budget for the selected month and year
        List<Budget> budgets = budgetRepo.findBudgetsByUser(user);

        double budgetAmount = 0;

        for (Budget budget : budgets) {

            if (budget.getMonth().equalsIgnoreCase(month)
                    && budget.getYear() == year) {

                budgetAmount = budget.getAmount();
                break;
            }
        }

        // Get all transactions of the logged-in user
        List<Transaction> transactions =
                transactionRepo.findTransactionsByUser(user);

        double totalExpense = 0;

        Month selectedMonth;

        try {
            selectedMonth = Month.valueOf(month.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid month");
        }

        // Calculate expenses for selected month
        for (Transaction transaction : transactions) {

            LocalDate date = transaction.getDate();

            if (date.getYear() == year
                    && date.getMonth() == selectedMonth
                    && transaction.getType().equalsIgnoreCase("Expense")) {

                totalExpense += transaction.getAmount();
            }
        }

        double remainingBudget =
                budgetAmount - totalExpense;

        boolean budgetExceeded =
                totalExpense > budgetAmount;

        return new BudgetSummary(
                budgetAmount,
                totalExpense,
                remainingBudget,
                budgetExceeded);
    }
}