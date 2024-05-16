package com.example.fintech_zerobase.dto;

import com.example.fintech_zerobase.type.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto {
    private Long id;
    private String bankName;
    private String password;
    private String balance;
    private String accountNumber;
    private Long account_amount;
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
