package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;

public interface DiscountPolicy {
    long discount(Member member, int price);
}
