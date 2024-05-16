package com.example.fintech_zerobase.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CancelAccountDto {

    private int amount;
    private LocalDateTime requestDate;
    private String accountNumber;


    public CancelAccountDto(int amount, LocalDateTime requestDate, String accountNumber) {
        this.amount = amount;
        this.requestDate = requestDate;
        this.accountNumber = accountNumber;
    }
}