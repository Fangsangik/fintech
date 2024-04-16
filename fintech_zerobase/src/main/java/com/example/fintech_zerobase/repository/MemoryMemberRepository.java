package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemoryMemberRepository {

    private final MemberRepository memberRepository;
    private final HashMap<Long, Member> store = new HashMap<>();

    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    public Long findById(Member member, Long id) {
        if (member.getId().equals(id)){
            return member.getId();
        }
        return null;
    }

    public Optional<Member> findByName(String name){
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
}
