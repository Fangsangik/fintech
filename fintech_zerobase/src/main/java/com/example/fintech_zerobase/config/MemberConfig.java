package com.example.fintech_zerobase.config;

import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import com.example.fintech_zerobase.service.MemberService;
import com.example.fintech_zerobase.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;

public class MemberConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
