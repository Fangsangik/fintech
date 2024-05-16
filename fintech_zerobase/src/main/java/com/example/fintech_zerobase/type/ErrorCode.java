package com.example.fintech_zerobase.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 없습니다."),
    USER_UN_MATCH("사용자가 맞지 않습니다."),
    EMPTY_YOUR_BALANCE("잔고를 비워주세요"),
    TOO_MUCH_ACCOUNT("생성된 계좌가 너무 많습니다"),
    TOO_YOUNG_TO_CREATE_BALANCE("너무 어려서 만들 수 없습니다.");
    private final String getMessage;
}
