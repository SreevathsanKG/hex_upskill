package com.hex.trs.controller;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.dto.CustomerTicketDto;
import com.hex.trs.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("/ticket/info")
	public List<CustomerDto> getCustomerWithTicketsCount() {
		return customerService.getCustomerWithTicketsCount();
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> postCustomer(@Valid @RequestBody CustomerReqDto customerReqDto) {
		customerService.postCustomer(customerReqDto);
		return ResponseEntity.created(URI.create("")).body("Customer Signed Up!!");
	}
	
	@PostMapping("/plan/{planId}")
	public ResponseEntity<?> purchasePlan(Principal principal, @PathVariable Long planId) {
		String username = principal.getName();
		customerService.purchasePlan(username, planId);
		return ResponseEntity.ok("Purchase Successful");
	}
	
	@GetMapping("/ticket/info/2")
	public List<CustomerTicketDto> getCustomerTicketInfo(Principal principal) {
		String username = principal.getName();
		return customerService.getCustomerTicketInfo(username);
	}
}
