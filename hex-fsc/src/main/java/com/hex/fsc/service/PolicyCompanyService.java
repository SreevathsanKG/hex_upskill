package com.hex.fsc.service;

import org.springframework.stereotype.Service;

import com.hex.fsc.dto.PremiumPaidDto;
import com.hex.fsc.exception.InvalidIdException;
import com.hex.fsc.model.Company;
import com.hex.fsc.model.Policy;
import com.hex.fsc.model.PolicyCompany;
import com.hex.fsc.repository.CompanyRepository;
import com.hex.fsc.repository.PolicyCompanyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PolicyCompanyService {

	private final PolicyCompanyRepository policyCompanyRepository;
	private final CompanyRepository companyRepository;
	private final PolicyService policyService;
	
	public PolicyCompany postPolicyCompany(String username, Long policyId, PremiumPaidDto premiumPaid) throws InvalidIdException {
		Policy policy = policyService.getByPolicyId(policyId);
		Company company = companyRepository.getByusername(username);
		PolicyCompany policyCompany = new PolicyCompany();
		policyCompany.setPolicy(policy);
		policyCompany.setCompany(company);
		policyCompany.setPremiumPaid(premiumPaid.premiumPaid());
		return policyCompanyRepository.save(policyCompany);
	}

}
