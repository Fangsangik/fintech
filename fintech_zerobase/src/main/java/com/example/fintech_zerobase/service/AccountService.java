package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(Long id, Long balance);

    AccountDto deleteAccount(Long id, String name, String password, String accountNumber);

    List<AccountDto> findAllAccount(Long id);
}
