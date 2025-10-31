package com.hex.fsc.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.fsc.dto.CompanyReqDto;
import com.hex.fsc.service.CompanyService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/company")
@AllArgsConstructor
public class CompanyController {

	private final CompanyService companyService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> postCompany(@Valid @RequestBody CompanyReqDto companyReqDto) {
		companyService.postCompany(companyReqDto);
		return ResponseEntity.created(URI.create("")).body("Company Signed Up");
	}
}
