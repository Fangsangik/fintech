package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.AccountStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Entity
@Builder
public class Account extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private Long balance;
    private String bankName;
    private String password;
    private Long accountAmount;

    @OneToMany(mappedBy = "account")
    private Member member;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new LinkedList<>();

}
