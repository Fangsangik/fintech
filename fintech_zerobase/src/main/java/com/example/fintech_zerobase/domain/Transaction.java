package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.TransactionResult;
import com.example.fintech_zerobase.type.TransactionType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
public class Transaction extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionResult transactionResult;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    private Account account;

    private Long amount;
    private Long balanceSnapShot;
    private LocalDateTime transactedAt;
}
