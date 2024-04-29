package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    Long join(Member member);

    void validateDuplicateMember(Long id, Member member);

    boolean deleteMemberById(Long id);

    Member findMember(long id);
}
