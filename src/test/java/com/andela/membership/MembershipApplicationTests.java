package com.andela.membership;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.andela.membership.MembershipApplication;
import com.andela.membership.controller.MemberController;
import com.andela.membership.controller.PlanController;
import com.andela.membership.repository.MemberRepository;
import com.andela.membership.repository.PlanRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembershipApplicationTests {

	@Autowired
	PlanController planController;
	
	@Autowired
	MemberController memberController;
	
	@Autowired
	PlanRepository planRepository;
	
	@Autowired 
	MemberRepository memberRepository;

	@Test
	public void contextLoads() {
		 assertThat(planController).isNotNull();
		 assertThat(memberController).isNotNull();
		 assertThat(planRepository).isNotNull();
		 assertThat(memberRepository).isNotNull();
	}

}
