package com.example.fintech_zerobase.controller;

import com.example.fintech_zerobase.dto.CancelAccountDto;
import com.example.fintech_zerobase.dto.CreateAccountDto;
import com.example.fintech_zerobase.dto.DeleteAccountDto;
import com.example.fintech_zerobase.service.TransactionService;
import com.example.fintech_zerobase.type.BankType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;


    @ModelAttribute("bank")
    public Map<String, String> banks(){
        Map<String, String> banks = new LinkedHashMap<>();

        banks.put("SINHAN", "신한");
        banks.put("KOOKMIN", "국민");
        banks.put("KAKO", "카카오");
        banks.put("ETC", "기타");
        return banks;
    }

    @PostMapping("/cancelAccount")
    public ResponseEntity<CancelAccountDto> cancelAccount(
            @RequestBody CancelAccountDto cancelAccountDto
    ) {
        log.info("CancelAccount request" + cancelAccountDto);
        return new ResponseEntity<>(cancelAccountDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<DeleteAccountDto> deleteAccountDto (
            @RequestBody DeleteAccountDto deleteAccountDto
    ){
        log.info("DeleteAccount request" + deleteAccountDto);
        return new ResponseEntity<>(deleteAccountDto, HttpStatus.OK);
    }
}
