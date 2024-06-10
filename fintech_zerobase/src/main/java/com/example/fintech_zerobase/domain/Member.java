package com.example.fintech_zerobase.domain;

import com.example.fintech_zerobase.type.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
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

    public int checkAge(int age){
        if (age < 18) {
            log.error("age not fullfill {}", HttpStatus.FORBIDDEN);
        }
        return age;
    }
}
