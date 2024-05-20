package com.example.fintech_zerobase.dto;

import com.example.fintech_zerobase.domain.Transaction;
import com.example.fintech_zerobase.type.TransactionResult;
import com.example.fintech_zerobase.type.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDto {
    private String accountNumber;
    private TransactionType transactionType;
    private TransactionResult transactionResult;
    private Long amount;
    private LocalDateTime transactedAt;
    private Long balanceSnapShot;

    public static TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .accountNumber(transaction.getAccount().getAccountNumber())
                .transactionResult(transaction.getTransactionResult())
                .amount(transaction.getAmount())
                .balanceSnapShot(transaction.getBalanceSnapShot())
                .transactionType(transaction.getTransactionType())
                .build();

    }
}
