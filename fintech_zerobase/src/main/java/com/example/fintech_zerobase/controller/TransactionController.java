package com.example.fintech_zerobase.controller;

import com.example.fintech_zerobase.dto.CancelAccountDto;
import com.example.fintech_zerobase.service.TransactionService;
import com.example.fintech_zerobase.type.BankType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
