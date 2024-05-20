package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    AccountDto createAccount(Long id, Long balance);

    AccountDto deleteAccount(Long id, String name, String password, String accountNumber);

    List<AccountDto> findAllAccount(Long id);
}
