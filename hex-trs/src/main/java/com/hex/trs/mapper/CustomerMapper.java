package com.hex.trs.mapper;

import org.springframework.stereotype.Component;

import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.model.Customer;

@Component
public class CustomerMapper {
	
	public Customer toEntity(CustomerReqDto customerReqDto) {
		Customer customer = new Customer();
		customer.setName(customerReqDto.name());
		customer.setCity(customerReqDto.city());
		return customer;
	}

}
