package com.expense.expence_management.Services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Repo.UserRepo;

@Service
public class userService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public userService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // Add new user
    public User addAll(User user) {

        String encodedPassword =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        return userRepo.save(user);
    }

    // Get all users
    public List<User> getAll() {
        return userRepo.findAll();
    }

    // Get user by ID
    public User getId(int id) {
        return userRepo.findById(id).orElse(null);
    }

    // Delete user
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    // Update user name
    public User updateName(int id, String name) {

        User ol = userRepo.findById(id).orElse(null);

        if (ol != null) {
            ol.setName(name);
            return userRepo.save(ol);
        }

        return null;
    }

    // Update user email
    public User updateEmail(int id, String email) {

        User ol = userRepo.findById(id).orElse(null);

        if (ol != null) {
            ol.setEmail(email);
            return userRepo.save(ol);
        }

        return null;
    }

    // Update user password
    public User updatePassword(int id, String password) {

        User ol = userRepo.findById(id).orElse(null);

        if (ol != null) {

            String encodedPassword =
                    passwordEncoder.encode(password);

            ol.setPassword(encodedPassword);

            return userRepo.save(ol);
        }

        return null;
    }
}