package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountPolicy {
    long discount(Member member, int price);
}
