package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.domain.Account;
import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.dto.AccountDto;
import com.example.fintech_zerobase.repository.AccountRepository;
import com.example.fintech_zerobase.repository.MemberRepository;
import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import com.example.fintech_zerobase.type.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final MemberRepository memberRepository;


    @Override
    public AccountDto createAccount(Long id, Long balance) {
        Member member = getAccountMember(id);

        validateCreateAccount(member);

        //본인인증 ??

        Account account = new Account();
        account.setId(1L);
        account.setBalance(balance);
        accountRepository.save(account);
        return accountDto(account);
    }

    @Override
    public AccountDto deleteAccount(Long id, String name, String password, String accountNumber) {
        Member member = getAccountMember(id);

        Account account = accountRepository.findByInfo(accountNumber);

        validateDeleteAccount(member, account);

        account.setAccountStatus(AccountStatus.UN_REGISTERED);
        accountRepository.save(account);
        return accountDto(account);
    }

    @Override
    public List<AccountDto> findAllAccount(Long id) {
       Member member = getAccountMember(id);

       List<Account> accounts = accountRepository.findAllAccount(member);

       return accountDtoList(accounts);
    }

    private List<AccountDto> accountDtoList(List<Account> accounts) {
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (AccountDto account : accountDtoList) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setBalance(account.getBalance());
            accountDtoList.add(accountDto);
        }

        return accountDtoList;
    }

    private void validateDeleteAccount(Member member, Account account) {
        if (!Objects.equals(member.getId(), account.getMember().getId())){
            throw new RuntimeException("아이디가 맞지 않습니다.");
        }

        if (account.getAccountStatus() == AccountStatus.UN_REGISTERED){
            throw new RuntimeException("이미 해지된 계좌 입니다");
        }

        if (account.getBalance() != 0){
            throw new RuntimeException("잔고를 비워주세요");
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
            throw new RuntimeException("만들수 있는 계좌 수를 초과 했습니다.");
        }

        if (member.check_Age(member.getAge()) < 18){
            throw new RuntimeException("미성년자는 부모님의 동의가 있어야 계좌 생성이 가능합니다.");
        }
    }

    private Member getAccountMember(Long id) {
       return memberRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("회원을 찾지 못했습니다."));
    }

}
