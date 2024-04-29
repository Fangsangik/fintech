package com.example.fintech_zerobase.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountStatus {
    REGISTERED("등록된 계좌 입니다"), UN_REGISTERED("등록 되지 않은 계좌 입니다.");

   private final String str;
}
