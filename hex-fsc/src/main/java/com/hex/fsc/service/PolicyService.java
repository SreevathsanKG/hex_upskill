package com.hex.fsc.service;

import org.springframework.stereotype.Service;

import com.hex.fsc.dto.PolicyReqDto;
import com.hex.fsc.mapper.PolicyMapper;
import com.hex.fsc.model.Customer;
import com.hex.fsc.model.Policy;
import com.hex.fsc.repository.CustomerRepository;
import com.hex.fsc.repository.PolicyRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PolicyService {

	private final PolicyRepository policyRepository;
	private final PolicyMapper policyMapper;
	private final CustomerRepository customerRepository;
	
	public Policy postPolicyByCustomer(String username, @Valid PolicyReqDto policyReqDto) {
		Customer customer = customerRepository.getByUsername(username);
		Policy policy = policyMapper.toEntity(policyReqDto);
		policy.setCustomer(customer);
		return policyRepository.save(policy);
	}

}
