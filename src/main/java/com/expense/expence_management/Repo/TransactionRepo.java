package com.expense.expence_management.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.expence_management.Entity.Transaction;
import com.expense.expence_management.Entity.User;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.user_id = :user")
    List<Transaction> findTransactionsByUser(
            @Param("user") User user);

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.user_id = :user
            AND t.type = :type
            """)
    List<Transaction> findTransactionsByUserAndType(
            @Param("user") User user,
            @Param("type") String type);

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.user_id = :user
            AND t.category_id.id = :categoryId
            """)
    List<Transaction> findTransactionsByUserAndCategory(
            @Param("user") User user,
            @Param("categoryId") int categoryId);

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.user_id = :user
            AND t.date BETWEEN :startDate AND :endDate
            """)
    List<Transaction> findTransactionsByUserAndDateRange(
            @Param("user") User user,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.user_id = :user
            AND (:type IS NULL OR t.type = :type)
            AND (:categoryId IS NULL OR t.category_id.id = :categoryId)
            AND (:startDate IS NULL OR t.date >= :startDate)
            AND (:endDate IS NULL OR t.date <= :endDate)
            """)
    List<Transaction> findFilteredTransactions(
            @Param("user") User user,
            @Param("type") String type,
            @Param("categoryId") Integer categoryId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}