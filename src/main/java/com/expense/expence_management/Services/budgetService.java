package com.expense.expence_management.Services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.Budget;
import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Repo.BudgetRepo;
import com.expense.expence_management.Repo.UserRepo;

@Service
public class budgetService {

    private final BudgetRepo budgetRepo;
    private final UserRepo userRepo;

    public budgetService(BudgetRepo budgetRepo, UserRepo userRepo) {
        this.budgetRepo = budgetRepo;
        this.userRepo = userRepo;
    }

    // ADD BUDGET
    public Budget addAll(
            Budget budget,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        budget.setUser_id(user);

        return budgetRepo.save(budget);
    }

    // GET ALL BUDGETS OF LOGGED-IN USER
    public List<Budget> getAll(
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        return budgetRepo.findBudgetsByUser(user);
    }

    // GET BUDGET BY ID
    public Budget getId(
            int id,
            Authentication authentication) {

        return getUserBudget(id, authentication);
    }

    // UPDATE AMOUNT
    public Budget updateAmount(
            int id,
            double amount,
            Authentication authentication) {

        Budget budget = getUserBudget(id, authentication);

        if (budget != null) {
            budget.setAmount(amount);
            return budgetRepo.save(budget);
        }

        return null;
    }

    // UPDATE MONTH
    public Budget updateMonth(
            int id,
            String month,
            Authentication authentication) {

        Budget budget = getUserBudget(id, authentication);

        if (budget != null) {
            budget.setMonth(month);
            return budgetRepo.save(budget);
        }

        return null;
    }

    // UPDATE YEAR
    public Budget updateYear(
            int id,
            int year,
            Authentication authentication) {

        Budget budget = getUserBudget(id, authentication);

        if (budget != null) {
            budget.setYear(year);
            return budgetRepo.save(budget);
        }

        return null;
    }

    // DELETE BUDGET
    public void delete(
            int id,
            Authentication authentication) {

        Budget budget = getUserBudget(id, authentication);

        if (budget != null) {
            budgetRepo.delete(budget);
        }
    }

    // GET LOGGED-IN USER
    private User getLoggedInUser(
            Authentication authentication) {

        String email = authentication.getName();

        return userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    // GET BUDGET ONLY IF IT BELONGS TO LOGGED-IN USER
    private Budget getUserBudget(
            int id,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Budget budget = budgetRepo.findById(id)
                .orElse(null);

        if (budget != null &&
                budget.getUser_id().getId() == user.getId()) {

            return budget;
        }

        return null;
    }
}