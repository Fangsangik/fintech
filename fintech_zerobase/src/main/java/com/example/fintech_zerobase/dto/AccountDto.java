package com.example.fintech_zerobase.dto;

import com.example.fintech_zerobase.domain.Account;
import com.example.fintech_zerobase.type.AccountStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AccountDto {
    private Long id;
    private String bankName;
    private String password;
    private String balance;
    private String accountNumber;
    private Long accountAmount;
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .bankName(account.getBankName())
                .password(account.getPassword())
                .balance(account.getBalance().toString())
                .accountNumber(account.getAccountNumber())
                .accountAmount(account.getAccountAmount())
                .accountStatus(account.getAccountStatus())
                .build();
    }
}
