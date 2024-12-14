package com.sbs.tutorial1.boundedContext.member.repository;

import com.sbs.tutorial1.boundedContext.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByUsername(String username);
}
