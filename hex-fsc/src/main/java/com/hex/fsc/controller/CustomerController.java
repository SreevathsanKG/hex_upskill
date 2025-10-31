package com.hex.fsc.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.fsc.dto.CustomerReqDto;
import com.hex.fsc.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> postCustomer(@Valid @RequestBody CustomerReqDto customerReqDto) {
		customerService.postCustomer(customerReqDto);
		return ResponseEntity.created(URI.create("")).body("Customer Signed Up");
	}
}
