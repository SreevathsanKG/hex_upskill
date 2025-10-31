package com.hex.trs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hex.trs.exception.InvalidIdException;
import com.hex.trs.model.Plan;
import com.hex.trs.repository.PlanRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanService {

	private final PlanRepository planRepository;
	
	public List<Plan> getPlanByCustomer(Long customerId) {
		return planRepository.getPlanByCustomer(customerId);
	}

	public Plan getById(Long planId) {
		return planRepository.findById(planId).orElseThrow(()-> new InvalidIdException("Plan Id Invalid"));
	}

}
