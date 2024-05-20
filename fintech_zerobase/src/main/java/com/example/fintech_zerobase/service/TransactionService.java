package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.domain.Account;
import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.domain.Transaction;
import com.example.fintech_zerobase.dto.TransactionDto;
import com.example.fintech_zerobase.exception.AccountException;
import com.example.fintech_zerobase.repository.AccountRepository;
import com.example.fintech_zerobase.repository.MemberRepository;
import com.example.fintech_zerobase.repository.TransactionRepository;
import com.example.fintech_zerobase.type.AccountStatus;
import com.example.fintech_zerobase.type.ErrorCode;
import com.example.fintech_zerobase.type.TransactionResult;
import com.example.fintech_zerobase.type.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final AccountRepository accountRepository;

    @Transactional
    public TransactionDto useBalance(Long id, String accountNumber, Long amount) {
        Optional<Member> member = memberRepository.findById(id)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));

        Optional<Account> account = accountRepository.findByInfo(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.ACCOUNT_NOT_FOUND));

        validateUseBalance(member, account, amount);

        return TransactionDto.fromEntity(saveGetTransaction())
    }

    private Transaction saveGetTransaction(TransactionType transactionType, TransactionResult transactionResult,
                                           Account account, Long amount) {

        if (account == null) {
            throw new AccountException(ErrorCode.ACCOUNT_NOT_FOUND);
        }


        Transaction transaction = Transaction.builder()
                        .transactionType(transactionType)
                        .transactionResult(TransactionResult.SUCCESS)
                        .account(account)
                        .balanceSnapShot(account.getBalance())
                        .transactedAt(LocalDateTime.now())
                        .build();

        if (transactionRepository == null) {
            throw new AccountException(ErrorCode.TRANSACTION_NOT_VALID);

        }

        return transactionRepository.save(transaction);

    }

    private void validateUseBalance(Optional<Member> member, Optional<Account> account, Long amount) {
        if (member.get().getId() != account.get().getId()) {
            throw new AccountException(ErrorCode.USER_NOT_FOUND);
        }

        if (account.get().getAccountStatus() != AccountStatus.REGISTERED){
            throw new AccountException(ErrorCode.ACCOUNT_NOT_FOUND);
        }

        if (account.get().getBalance() < amount){
            throw new AccountException(ErrorCode.AMOUNT_EXCEED);
        }
    }

    @Transactional
    public TransactionDto cancelBalance(Long id, String accountNumber, Long amount) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new AccountException(ErrorCode.TRANSACTION_NOT_VALID));


        Account account = accountRepository.findByInfo(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.ACCOUNT_NOT_FOUND));

        validateCancelBalance(transaction, account, amount);

        return TransactionDto.fromEntity(
                saveGetTransaction(TransactionType.CANCEL, TransactionResult.SUCCESS, account, amount)
        );
    }

    private void validateCancelBalance(Transaction transaction, Account account, Long amount) throws AccountException {
        if (transaction.getAccount() != account) {
            throw new AccountException(ErrorCode.CANCEL);
        }

        if (transaction.getTransactedAt().isBefore(LocalDateTime.now().minusDays(3))) {
            throw new AccountException(ErrorCode.TOO_OLD_TO_FIND)
        }
    }
}
