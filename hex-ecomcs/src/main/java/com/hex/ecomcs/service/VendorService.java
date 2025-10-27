package com.hex.ecomcs.service;

import org.springframework.stereotype.Service;

import com.hex.ecomcs.model.Vendor;
import com.hex.ecomcs.repository.VendorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VendorService {

	private final VendorRepository vendorRepository;
	
	public Vendor getById(Long customerId) {
		return vendorRepository.findById(customerId).orElseThrow(()-> new RuntimeException("Customer ID Invalid"));
	}
}
