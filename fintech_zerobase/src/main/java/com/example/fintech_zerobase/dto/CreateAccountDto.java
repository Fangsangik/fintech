package com.example.fintech_zerobase.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class CreateAccountDto {

    @Data
    public static class Request {

        @NotNull
        private long userId;

        @NotNull
        private String init;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long userId;
        private String accountNumber;
        private LocalDateTime registeredAt;

        public static Response from(AccountDto accountDto){
            return Response.builder()
                    .userId(accountDto.getId())
                    .accountNumber(accountDto.getAccountNumber())
                    .registeredAt(accountDto.getCreatedAt())
                    .build();
        }
    }


}
