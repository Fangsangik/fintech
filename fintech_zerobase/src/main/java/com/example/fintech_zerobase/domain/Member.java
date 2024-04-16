package com.example.fintech_zerobase.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private int age;

    @Embedded
    private Address address;

    public int check_Age(int age){
        if (age < 18) {
            System.out.println("부모의 동의가 필요 합니다.");
        }
        return age;
    }
}
