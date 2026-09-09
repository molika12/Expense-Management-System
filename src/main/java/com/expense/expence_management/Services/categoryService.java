package com.expense.expence_management.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.Category;
import com.expense.expence_management.Repo.CategoryRepo;

@Service
public class categoryService {

    private final CategoryRepo categoryRepo;

    public categoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    // SAVE
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    // GET ALL
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    // GET BY ID
    public Category getId(int id) {
        return categoryRepo.findById(id).orElse(null);
    }

    // UPDATE NAME
    public Category updateName(int id, String name) {

        Category oldCategory = categoryRepo.findById(id).orElse(null);

        if (oldCategory != null) {
            oldCategory.setName(name);
            return categoryRepo.save(oldCategory);
        }

        return null;
    }

    // DELETE
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}