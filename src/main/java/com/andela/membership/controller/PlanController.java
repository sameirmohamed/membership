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

import com.andela.membership.model.Plan;
import com.andela.membership.service.PlanService;

@RestController
public class PlanController {

	@Autowired
	PlanService planService;

	@GetMapping("/plan")
	public List<Plan> getAllPlans() {
		return planService.getAllPlans();
	}

	@GetMapping("/plan/{id}")
	public Plan getPlan(@PathVariable Long id) {
		return planService.getPlan(id);
	}

	@PostMapping("/plan")
	public Plan createPlan(@RequestBody Plan plan) {
		return planService.createPlan(plan);
	}

	@DeleteMapping("/plan/{id}")
	public void deletePlan(@PathVariable Long id) {
		planService.deletePlan(id);
	}

	@PutMapping("/plan/{id}")
	public Plan update(@PathVariable Long id, @RequestBody Plan newPlan) {
		return planService.update(id, newPlan);
	}

}
