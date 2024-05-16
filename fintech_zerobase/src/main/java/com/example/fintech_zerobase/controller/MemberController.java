package com.example.fintech_zerobase.controller;

import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import com.example.fintech_zerobase.service.MemberServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private MemoryMemberRepository memberRepository;
    private MemberServiceImpl memberService;

    @GetMapping("/members/{id}")
    public ResponseEntity<String> findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id);
        if (member != null){
            return ResponseEntity.ok(member.getName());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostConstruct
    public void save(){
        memberRepository.save(new Member());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMember(@PathVariable("id") Long id){
        boolean deleted = memberService.deleteMemberById(id);

        if (deleted){
            return ResponseEntity.ok("Member has been deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Deleting member has been failed");
        }
    }
}

