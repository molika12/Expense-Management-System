package com.expense.expence_management.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expence_management.Entity.BudgetSummary;
import com.expense.expence_management.Services.budgetSummaryService;

@RestController
@RequestMapping("/expence-management/budget-summary")
public class budgetSummaryController {

    private final budgetSummaryService budgetSummaryservice;

    public budgetSummaryController(
            budgetSummaryService budgetSummaryservice) {

        this.budgetSummaryservice = budgetSummaryservice;
    }

    @GetMapping
    public BudgetSummary getBudgetSummary(
            Authentication authentication,
            @RequestParam String month,
            @RequestParam int year) {

        return budgetSummaryservice.getBudgetSummary(
                authentication,
                month,
                year);
    }
}