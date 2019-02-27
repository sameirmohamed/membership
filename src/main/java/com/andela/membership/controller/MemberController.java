package com.andela.membership.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andela.membership.model.Member;
import com.andela.membership.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/plan/{id}/members")
	public Set<Member> getPlanMembmersById(@PathVariable Long id) {
		return memberService.getPlanMembmersById(id);
	}

	@PostMapping("/plan/{id}/members")
	public void createMember(@PathVariable Long id, @RequestBody Member member) {
		memberService.createMember(id, member);
	}
}
