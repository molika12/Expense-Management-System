package com.expense.expence_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expence_management.Entity.Category;
import com.expense.expence_management.Services.categoryService;

import jakarta.validation.Valid;

@RequestMapping("/expence-management/category")
@RestController
public class categoryController {

    private final categoryService categoryservice;

    public categoryController(categoryService categoryservice) {
        this.categoryservice = categoryservice;
    }

    // ADD CATEGORY
    @PostMapping
    public Category addCategory(
            @RequestBody @Valid Category category) {

        return categoryservice.addCategory(category);
    }

    // GET ALL
    @GetMapping
    public List<Category> getAll() {
        return categoryservice.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Category getId(@PathVariable int id) {
        return categoryservice.getId(id);
    }

    // UPDATE NAME
    @PutMapping("/{id}")
    public Category updateName(
            @PathVariable int id,
            @RequestParam String name) {

        return categoryservice.updateName(id, name);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryservice.delete(id);
    }
}