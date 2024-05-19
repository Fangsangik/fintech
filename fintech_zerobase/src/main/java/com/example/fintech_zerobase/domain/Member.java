package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.Grade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private int age;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public int check_Age(int age){
        if (age < 18) {
            System.out.println("부모의 동의가 필요 합니다.");
        }
        return age;
    }
}
