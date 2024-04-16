package com.example.fintech_zerobase.repository;

import com.example.fintech_zerobase.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
