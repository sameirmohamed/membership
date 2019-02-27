package com.andela.membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andela.membership.exceptoin.PlanNotFoundException;
import com.andela.membership.model.Plan;
import com.andela.membership.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepository;
	
	public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}

	public Plan getPlan(Long id) {
		return planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
	}

	public Plan createPlan(Plan plan) {
		return planRepository.save(plan);
	}

	public void deletePlan(Long id) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		planRepository.delete(plan);
	}

	public Plan update(Long id, Plan newPlan) {
		return planRepository.findById(id).map(plan -> {
			plan.setName(newPlan.getName());
			plan.setStartDate(newPlan.getStartDate());
			plan.setEndDate(newPlan.getEndDate());
			return planRepository.save(plan);
		}).orElseThrow(() -> new PlanNotFoundException(id));
	}

}
