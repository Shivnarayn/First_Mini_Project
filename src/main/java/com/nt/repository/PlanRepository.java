package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
 
	
}
