package com.expense.expence_management.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Positive(message = "Enter a valid amount")
    double amount;

    @NotEmpty(message = "Enter the Type")
    String type;

    @NotEmpty(message = "Enter the description")
    String description;

    @NotNull(message = "Enter the date")
    @PastOrPresent(message = "The transaction date cannot be future")
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    public Transaction() {
    }

    public Transaction(Integer id, double amount, String type,
                       String description, LocalDate date,
                       User user_id, Category category_id) {

        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.date = date;
        this.user_id = user_id;
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user_id;
    }

    public Category getCategory() {
        return category_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user_id) {
        this.user_id = user_id;
    }

    public void setCategory(Category category_id) {
        this.category_id = category_id;
    }
}