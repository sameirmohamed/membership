package com.andela.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andela.membership.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
