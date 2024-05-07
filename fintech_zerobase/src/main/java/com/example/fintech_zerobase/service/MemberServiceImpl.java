package com.example.fintech_zerobase.service;

import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemoryMemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public void validateDuplicateMember(Long id, Member member) {
//        if(memberRepository.findById(member.getId())
//                .equals(id)){
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        } else {
//            memberRepository.save(member);
//        }
//
//    }
        Optional<Member> existingMember = Optional.ofNullable(memberRepository.findById(member.getId()));
        if (existingMember.isPresent() && existingMember.get().getId().equals(id)) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        } else {
            memberRepository.save(member);
        }
    }

    @Override
    public boolean deleteMemberById(Long id) {
        Optional<Member> memberId = Optional.ofNullable(memberRepository.findById(id));

        if (memberId != null){
            memberRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member findMember(long id) {
        return memberRepository.findById(id);
    }
}
