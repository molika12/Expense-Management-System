package com.expense.expence_management.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.expense.expence_management.Entity.Category;
import com.expense.expence_management.Entity.Transaction;
import com.expense.expence_management.Services.transactionService;

@RequestMapping("/expence-management/transition")
@RestController
public class transactionController {

    private final transactionService transactionservice;

    public transactionController(
            transactionService transactionservice) {

        this.transactionservice = transactionservice;
    }

    // ADD TRANSACTION
    @PostMapping
    public Transaction addAll(
            @RequestBody Transaction transaction,
            Authentication authentication) {

        return transactionservice.addAll(
                transaction, authentication);
    }

    // GET / FILTER TRANSACTIONS
    @GetMapping
    public List<Transaction> getAll(
            Authentication authentication,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {

        return transactionservice.getAll(
                authentication,
                type,
                categoryId,
                startDate,
                endDate);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Transaction getId(
            @PathVariable int id,
            Authentication authentication) {

        return transactionservice.getId(
                id, authentication);
    }

    // UPDATE AMOUNT
    @PutMapping("/{id}/amount")
    public Transaction updateAmount(
            @PathVariable int id,
            @RequestParam double amt,
            Authentication authentication) {

        return transactionservice.updateAmount(
                id, amt, authentication);
    }

    // UPDATE TYPE
    @PutMapping("/{id}/type")
    public Transaction updateType(
            @PathVariable int id,
            @RequestParam String type,
            Authentication authentication) {

        return transactionservice.updateType(
                id, type, authentication);
    }

    // UPDATE DESCRIPTION
    @PutMapping("/{id}/description")
    public Transaction updateDescription(
            @PathVariable int id,
            @RequestParam String dec,
            Authentication authentication) {

        return transactionservice.updateDescription(
                id, dec, authentication);
    }

    // UPDATE DATE
    @PutMapping("/{id}/date")
    public Transaction updateDate(
            @PathVariable int id,
            @RequestParam LocalDate date,
            Authentication authentication) {

        return transactionservice.updateDate(
                id, date, authentication);
    }

    // UPDATE CATEGORY
    @PutMapping("/{id}/category")
    public Transaction updateCategory(
            @PathVariable int id,
            @RequestParam Category category,
            Authentication authentication) {

        return transactionservice.updateCategory(
                id, category, authentication);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable int id,
            Authentication authentication) {

        transactionservice.delete(
                id, authentication);
    }
}