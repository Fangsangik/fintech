package com.example.fintech_zerobase.dto;

import lombok.Data;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
public class DeleteAccountDto {

    private Long userId;
    private String accountNumber;
    private LocalDateTime unRegisteredAt;
}
