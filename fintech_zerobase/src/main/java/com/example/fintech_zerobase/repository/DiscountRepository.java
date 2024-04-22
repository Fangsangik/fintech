package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.type.Grade;

public class DiscountRepository implements DiscountPolicy{
    private final long discount = 1 / 100;

    @Override
    public long discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discount;
        }
        return 0;
    }
}
