package com.andela.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andela.membership.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
