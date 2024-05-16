package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.config.MemberConfig;
import com.example.fintech_zerobase.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        MemberConfig memberConfig = new MemberConfig();
        memberService = memberConfig.memberService();
    }
    @Test
        void join(){
        //given
        Member member = new Member(1L, "황", "1234", 25);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
       }
}