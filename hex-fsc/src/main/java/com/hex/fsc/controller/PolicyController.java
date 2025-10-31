package com.hex.fsc.controller;

import java.net.URI;
import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.fsc.dto.PolicyReqDto;
import com.hex.fsc.service.PolicyService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/policy")
@AllArgsConstructor
public class PolicyController {

	private final PolicyService policyService;
	
	@PostMapping("/customer/add")
	public ResponseEntity<?> postPolicyByCustomer(Principal principal,@Valid @RequestBody PolicyReqDto policyReqDto) {
		String username = principal.getName();
		return ResponseEntity.created(URI.create("")).body(policyService.postPolicyByCustomer(username, policyReqDto));
	}
}
