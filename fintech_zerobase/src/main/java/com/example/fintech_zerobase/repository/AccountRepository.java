package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Account;
import com.example.fintech_zerobase.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Integer countAccount(Member member);

    Account findByInfo(String accountNumber);

    List<Account> findAllAccount(Member member);
}
