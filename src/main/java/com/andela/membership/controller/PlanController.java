package com.andela.membership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andela.membership.exceptoin.PlanNotFoundException;
import com.andela.membership.model.Plan;
import com.andela.membership.repository.PlanRepository;

@RestController
public class PlanController {

	@Autowired
	PlanRepository planRepository;

	@GetMapping("/plan")
	public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}

	@GetMapping("/plan/{id}")
	public Plan getPlan(@PathVariable Long id) {
		return planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
	}

	@PostMapping("/plan")
	public Plan createPlan(@RequestBody Plan plan) {
		return planRepository.save(plan);
	}

	@DeleteMapping("/plan/{id}")
	public void deletePlan(@PathVariable Long id) {
		Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException(id));
		planRepository.delete(plan);
	}

	@PutMapping("/plan/{id}")
	public Plan update(@PathVariable Long id, @RequestBody Plan newPlan) {
		return planRepository.findById(id).map(plan -> {
			plan.setName(newPlan.getName());
			plan.setStartDate(newPlan.getStartDate());
			plan.setEndDate(newPlan.getEndDate());
			return planRepository.save(plan);
		}).orElseThrow(() -> new PlanNotFoundException(id));
	}

}
