package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.domain.Member;

public interface MemberService {

    Long join(Member member);

    void validateDuplicateMember(Long id, Member member);

    boolean deleteMemberById(Long id);
}
