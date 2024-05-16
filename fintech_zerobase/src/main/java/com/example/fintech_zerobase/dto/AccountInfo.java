package com.example.fintech_zerobase.dto;

import com.example.fintech_zerobase.type.AccountStatus;
import lombok.Data;

@Data
public class AccountInfo {
    private String accountNumber;
    private String accountPassword;
    private int account_amount;
    private AccountStatus accountStatus;
}
