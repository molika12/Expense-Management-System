package com.expense.expence_management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expence_management.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}