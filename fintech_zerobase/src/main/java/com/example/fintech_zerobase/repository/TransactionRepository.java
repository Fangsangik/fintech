package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
