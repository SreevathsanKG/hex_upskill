package com.hex.fsc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.fsc.dto.PremiumPaidDto;
import com.hex.fsc.exception.InvalidIdException;
import com.hex.fsc.service.PolicyCompanyService;

import lombok.AllArgsConstructor;

import java.net.URI;
import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/policycompany")
@AllArgsConstructor
public class PolicyCompanyController {

	private final PolicyCompanyService policyCompanyService;
	
	@PostMapping("/add/{policyId}")
	public ResponseEntity<?> posyPolicyCompany(Principal principal, @PathVariable Long policyId, @RequestBody PremiumPaidDto premiumPaid) throws InvalidIdException{
		String username = principal.getName();
		return ResponseEntity.created(URI.create("")).body(policyCompanyService.postPolicyCompany(username, policyId, premiumPaid));
		
	}

	
}
