package com.example.fintech_zerobase.service;

import ch.qos.logback.core.spi.ErrorCodes;
import com.example.fintech_zerobase.domain.Account;
import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.dto.AccountDto;
import com.example.fintech_zerobase.exception.AccountException;
import com.example.fintech_zerobase.repository.AccountRepository;
import com.example.fintech_zerobase.repository.MemberRepository;
import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import com.example.fintech_zerobase.type.AccountStatus;
import com.example.fintech_zerobase.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final MemberRepository memberRepository;


    @Override
    public AccountDto createAccount(Long id, Long balance) {
        Member member = getAccountMember(id);

        validateCreateAccount(member);


        //빌더 페턴 적용해서 dirtychecking 피함
        Account account = Account.builder()
                .member(member)
                .balance(balance)
                .accountStatus(AccountStatus.REGISTERED)
                .build();

        accountRepository.save(account);
        return AccountDto.fromEntity(account);
    }

    @Override
    public AccountDto deleteAccount(Long id, String name, String password, String accountNumber) {
        Member member = getAccountMember(id);

        Account account = accountRepository.findByInfo(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));

        validateDeleteAccount(member, account);

        accountRepository.delete(account);
        return AccountDto.fromEntity(account);
    }

    @Override
    public List<AccountDto> findAllAccount(Long id) {
        Member member = getAccountMember(id);

        List<Account> accounts = accountRepository.findAllAccount(member);

        return accountDtoList(accounts);
    }

    private List<AccountDto> accountDtoList(List<Account> accounts) {
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto accountDto = AccountDto.fromEntity(account);
            accountDtoList.add(accountDto);
        }

        return accountDtoList;
    }

    private void validateDeleteAccount(Member member, Account account) {
        if (!Objects.equals(member.getId(), account.getMember().getId())) {
            throw new AccessException(ErrorCode.USER_UN_MATCH);
        }

        if (account.getAccountStatus() == AccountStatus.UN_REGISTERED) {
            throw new AccountException(ErrorCode.USER_NOT_FOUND);
        }

        if (account.getBalance() != 0) {
            throw new AccountException(ErrorCode.EMPTY_YOUR_BALANCE);
        }

        //비밀번호 유효성 검사 추가
    }

    private AccountDto accountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setBalance(accountDto.getBalance());
        return accountDto;
    }

    private void validateCreateAccount(Member member) {
        if (accountRepository.countAccount(member) >= 10) {
            throw new AccountException(ErrorCode.TOO_MUCH_ACCOUNT);
        }

        if (member.checkAge(member.getAge()) < 18) {
            throw new AccountException(ErrorCode.TOO_YOUNG_TO_CREATE_BALANCE);
        }
    }

    private Member getAccountMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));
    }

}
