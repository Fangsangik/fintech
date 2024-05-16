package com.example.fintech_zerobase.exception;

import com.example.fintech_zerobase.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountException.class)
    //발생한 특정 예외를 잡아서 하나의 메소드에서 공통 처리
    public ResponseEntity<ErrorResponse> handelAccountException(AccountException ex){
        log.error("handelAccountException");
       return ErrorResponse.toResponse(ex.getErrorCode());
    }
}
