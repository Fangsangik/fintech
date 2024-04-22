package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.type.Grade;

public class DiscountRepository implements DiscountPolicy{
    private final long fee = 1 / 100;

    @Override
    public long discount(Member member, int price) {
        if (member.getGrade() == Grade.BASIC){
            return fee;
        }
        return 0;
    }
}
