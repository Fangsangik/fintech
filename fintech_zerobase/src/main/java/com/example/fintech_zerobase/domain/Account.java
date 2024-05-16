package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Account extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private Long balance;

    @OneToMany(mappedBy = "account")
    private List<Member> members = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
