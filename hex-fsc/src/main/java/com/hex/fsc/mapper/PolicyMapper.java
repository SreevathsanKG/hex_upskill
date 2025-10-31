package com.hex.fsc.mapper;

import org.springframework.stereotype.Component;

import com.hex.fsc.dto.PolicyReqDto;
import com.hex.fsc.enums.PolicyType;
import com.hex.fsc.model.Policy;

import jakarta.validation.Valid;

@Component
public class PolicyMapper {

	public Policy toEntity(@Valid PolicyReqDto policyReqDto) {
		Policy policy = new Policy();
		policy.setTitle(policyReqDto.title());
		policy.setTenure(policyReqDto.tenure());
		policy.setType(PolicyType.valueOf(policyReqDto.type()));
		return policy;
	}
}
