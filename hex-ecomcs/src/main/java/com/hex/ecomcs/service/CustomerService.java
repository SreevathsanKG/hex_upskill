package com.hex.ecomcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hex.ecomcs.dto.CustomerInfoDto;
import com.hex.ecomcs.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public List<CustomerInfoDto> getCustomerWithProductBoughtCount() {
		return customerRepository.getCustomerWithProductBoughtCount();
	}

}
