package com.expense.expence_management.Services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.Summary;
import com.expense.expence_management.Entity.Transaction;
import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Repo.TransactionRepo;
import com.expense.expence_management.Repo.UserRepo;

@Service
public class summaryService {

    private final TransactionRepo transactionRepo;
    private final UserRepo userRepo;

    public summaryService(
            TransactionRepo transactionRepo,
            UserRepo userRepo) {

        this.transactionRepo = transactionRepo;
        this.userRepo = userRepo;
    }

    public Summary getSummary(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        List<Transaction> transactions =
                transactionRepo.findTransactionsByUser(user);

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction transaction : transactions) {

            if (transaction.getType().equalsIgnoreCase("Income")) {
                totalIncome += transaction.getAmount();
            }

            else if (transaction.getType().equalsIgnoreCase("Expense")) {
                totalExpense += transaction.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        return new Summary(
                totalIncome,
                totalExpense,
                balance);
    }
}