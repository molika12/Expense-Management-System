package com.expense.expence_management.Entity;

public class BudgetSummary {

    private double budget;
    private double totalExpense;
    private double remainingBudget;
    private boolean budgetExceeded;

    public BudgetSummary() {
    }

    public BudgetSummary(double budget, double totalExpense,
                         double remainingBudget, boolean budgetExceeded) {
        this.budget = budget;
        this.totalExpense = totalExpense;
        this.remainingBudget = remainingBudget;
        this.budgetExceeded = budgetExceeded;
    }

    public double getBudget() {
        return budget;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public boolean isBudgetExceeded() {
        return budgetExceeded;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public void setBudgetExceeded(boolean budgetExceeded) {
        this.budgetExceeded = budgetExceeded;
    }
}