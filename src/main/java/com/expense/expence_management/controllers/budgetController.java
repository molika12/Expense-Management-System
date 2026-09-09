package com.expense.expence_management.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.expense.expence_management.Entity.Budget;
import com.expense.expence_management.Services.budgetService;

import jakarta.validation.Valid;

@RequestMapping("/expence-management/budget")
@RestController
public class budgetController {

    private final budgetService budgetservice;

    public budgetController(budgetService budgetservice) {
        this.budgetservice = budgetservice;
    }

    @PostMapping
    public Budget addAll(
            @RequestBody @Valid Budget budget,
            Authentication authentication) {

        return budgetservice.addAll(budget, authentication);
    }

    @GetMapping
    public List<Budget> getAll(
            Authentication authentication) {

        return budgetservice.getAll(authentication);
    }

    @GetMapping("/{id}")
    public Budget getId(
            @PathVariable int id,
            Authentication authentication) {

        return budgetservice.getId(id, authentication);
    }

    @PutMapping("/{id}/amount")
    public Budget updateAmount(
            @PathVariable int id,
            @RequestParam double amount,
            Authentication authentication) {

        return budgetservice.updateAmount(
                id, amount, authentication);
    }

    @PutMapping("/{id}/month")
    public Budget updateMonth(
            @PathVariable int id,
            @RequestParam String month,
            Authentication authentication) {

        return budgetservice.updateMonth(
                id, month, authentication);
    }

    @PutMapping("/{id}/year")
    public Budget updateYear(
            @PathVariable int id,
            @RequestParam int year,
            Authentication authentication) {

        return budgetservice.updateYear(
                id, year, authentication);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable int id,
            Authentication authentication) {

        budgetservice.delete(id, authentication);
    }
}