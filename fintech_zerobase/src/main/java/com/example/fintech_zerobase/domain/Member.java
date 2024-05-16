package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.Grade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member extends BaseEntity{

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

    public Member(Long id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int check_Age(int age){
        if (age < 18) {
            System.out.println("부모의 동의가 필요 합니다.");
        }
        return age;
    }
}
