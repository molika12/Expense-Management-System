package com.expense.expence_management.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.expence_management.Entity.Budget;
import com.expense.expence_management.Entity.User;

public interface BudgetRepo extends JpaRepository<Budget, Integer> {

    @Query("SELECT b FROM Budget b WHERE b.user_id = :user")
    List<Budget> findBudgetsByUser(@Param("user") User user);
}