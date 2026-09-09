package com.expense.expence_management.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expence_management.Entity.Summary;
import com.expense.expence_management.Services.summaryService;

@RestController
@RequestMapping("/expence-management/summary")
public class summaryController {

    private final summaryService summaryservice;

    public summaryController(summaryService summaryservice) {
        this.summaryservice = summaryservice;
    }

    @GetMapping
    public Summary getSummary(Authentication authentication) {

        return summaryservice.getSummary(authentication);
    }
}