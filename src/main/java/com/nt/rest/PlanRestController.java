package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Plan;
import com.nt.service.PlanService;


@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String responseMsg = "";
		boolean isSaved = planService.savePlan(plan);
		
		if(isSaved) {
			responseMsg = "Plan Save";
		}else {
			responseMsg = "Plan Not Save";
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean isUpdate = planService.updatePlan(plan);
		
	    String msg = "";
		
		if(isUpdate) {
			msg = "Plan Update";
		}else {
			msg = "Plan Not Update";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		
		String msg = "";
		
		if(isDeleted) {
			msg = "Plan Delete";
		}else {
			msg = "Plan Not Delete";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
	 
		String msg = "";
		boolean isStatusChanged = planService.PlanStatusChange(planId, status);
	       if(isStatusChanged) {
	    	   msg = "Status change"; 
	       }else {
	    	   msg = "Status Not change"; 
	       }
	       return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}






