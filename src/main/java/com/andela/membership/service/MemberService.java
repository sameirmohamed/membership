package com.andela.membership.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andela.membership.exceptoin.PlanNotFoundException;
import com.andela.membership.model.Member;
import com.andela.membership.model.Plan;
import com.andela.membership.repository.MemberRepository;
import com.andela.membership.repository.PlanRepository;

@Service
public class MemberService {

	@Autowired
	PlanRepository planRepository;

	@Autowired
	MemberRepository memberRepository;

	public Set<Member> getPlanMembmersById(Long id) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		return plan.getMembers();
	}

	public void createMember(Long id, Member member) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		member.setPlan(plan);
		memberRepository.save(member);
	}

}
