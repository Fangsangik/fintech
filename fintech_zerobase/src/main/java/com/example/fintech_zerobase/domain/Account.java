package com.example.fintech_zerobase.domain;

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
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long balance;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
}
