package com.expense.expence_management.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.expense.expence_management.Entity.Category;
import com.expense.expence_management.Entity.Transaction;
import com.expense.expence_management.Entity.User;
import com.expense.expence_management.Repo.TransactionRepo;
import com.expense.expence_management.Repo.UserRepo;

@Service
public class transactionService {

    private final TransactionRepo transactionRepo;
    private final UserRepo userRepo;

    public transactionService(
            TransactionRepo transactionRepo,
            UserRepo userRepo) {

        this.transactionRepo = transactionRepo;
        this.userRepo = userRepo;
    }

    // ADD TRANSACTION
    public Transaction addAll(
            Transaction transaction,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        transaction.setUser(user);

        return transactionRepo.save(transaction);
    }

    // GET / FILTER TRANSACTIONS
    public List<Transaction> getAll(
            Authentication authentication,
            String type,
            Integer categoryId,
            LocalDate startDate,
            LocalDate endDate) {

        User user = getLoggedInUser(authentication);

        return transactionRepo.findFilteredTransactions(
                user,
                type,
                categoryId,
                startDate,
                endDate);
    }

    // GET BY ID
    public Transaction getId(
            int id,
            Authentication authentication) {

        return getUserTransaction(id, authentication);
    }

    // UPDATE AMOUNT
    public Transaction updateAmount(
            int id,
            double amount,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transaction.setAmount(amount);
            return transactionRepo.save(transaction);
        }

        return null;
    }

    // UPDATE TYPE
    public Transaction updateType(
            int id,
            String type,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transaction.setType(type);
            return transactionRepo.save(transaction);
        }

        return null;
    }

    // UPDATE DESCRIPTION
    public Transaction updateDescription(
            int id,
            String des,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transaction.setDescription(des);
            return transactionRepo.save(transaction);
        }

        return null;
    }

    // UPDATE DATE
    public Transaction updateDate(
            int id,
            LocalDate date,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transaction.setDate(date);
            return transactionRepo.save(transaction);
        }

        return null;
    }

    // UPDATE CATEGORY
    public Transaction updateCategory(
            int id,
            Category category,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transaction.setCategory(category);
            return transactionRepo.save(transaction);
        }

        return null;
    }

    // DELETE
    public void delete(
            int id,
            Authentication authentication) {

        Transaction transaction =
                getUserTransaction(id, authentication);

        if (transaction != null) {
            transactionRepo.delete(transaction);
        }
    }

    // GET LOGGED-IN USER
    private User getLoggedInUser(
            Authentication authentication) {

        String email = authentication.getName();

        return userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    // GET USER'S TRANSACTION
    private Transaction getUserTransaction(
            int id,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Transaction transaction =
                transactionRepo.findById(id)
                        .orElse(null);

        if (transaction != null &&
                transaction.getUser().getId() == user.getId()) {

            return transaction;
        }

        return null;
    }
}