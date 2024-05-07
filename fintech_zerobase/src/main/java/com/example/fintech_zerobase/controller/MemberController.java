package com.example.fintech_zerobase.controller;

import com.example.fintech_zerobase.domain.Member;
import com.example.fintech_zerobase.repository.MemoryMemberRepository;
import com.example.fintech_zerobase.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/members")
@RequiredArgsConstructor
public class MemberController {
    private MemoryMemberRepository memberRepository;
    private MemberServiceImpl memberService;

    @GetMapping("/form")
    public ResponseEntity<String> findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id);
        if (member != null){
            return ResponseEntity.ok(member.getName());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("age") int age,
            Model model){
        Member member = new Member(id, name, password, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
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

