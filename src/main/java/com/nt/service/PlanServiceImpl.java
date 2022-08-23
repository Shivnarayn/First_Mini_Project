package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Plan;
import com.nt.entity.PlanCategory;
import com.nt.repository.PlanCategoryRepository;
import com.nt.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	public PlanRepository PlanRepo;
	
	@Autowired
	public PlanCategoryRepository PlanCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = PlanCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category->{
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = PlanRepo.save(plan);
/*		
		if(saved.getPlanId()!=null) {
			return true;
		}
		else {
		return false;
		}*/
//		OR
	
//		 return saved.getPlanId()!=null ? true : false;
		
//		OR
		
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> findAll = PlanRepo.findAll();
		return findAll;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = PlanRepo.findById(planId);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = PlanRepo.save(plan);//upsert method	
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean  status = false;
		try {			
			PlanRepo.deleteById(planId);	
			status = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean PlanStatusChange(Integer id, String status) {
		Optional<Plan> findById = PlanRepo.findById(id);
		
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			PlanRepo.save(plan);
			return true;
		}
		return false;
	}

}
