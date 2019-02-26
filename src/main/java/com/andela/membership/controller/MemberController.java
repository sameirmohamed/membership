package com.andela.membership.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andela.membership.exceptoin.PlanNotFoundException;
import com.andela.membership.model.Member;
import com.andela.membership.model.Plan;
import com.andela.membership.repository.MemberRepository;
import com.andela.membership.repository.PlanRepository;

@RestController
public class MemberController {

	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	MemberRepository memberRepository;

	@GetMapping("/plan/{id}/members")
	public Set<Member> getPlanMembmersById(@PathVariable Long id) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		return plan.getMembers();
	}

	@PostMapping("/plan/{id}/members")
	public void createMember(@PathVariable Long id, @RequestBody Member member) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		member.setPlan(plan);
		memberRepository.save(member);
	}
}
