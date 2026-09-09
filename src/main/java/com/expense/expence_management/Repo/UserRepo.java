package com.expense.expence_management.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expence_management.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User>findByEmail(String email);
}
