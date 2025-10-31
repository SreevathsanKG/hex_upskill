package com.hex.fsc.mapper;

import org.springframework.stereotype.Component;

import com.hex.fsc.dto.CustomerReqDto;
import com.hex.fsc.enums.Idproof;
import com.hex.fsc.model.Customer;

@Component
public class CustomerMapper {

	public Customer toEntity(CustomerReqDto customerReqDto) {
		Customer customer = new Customer();
		customer.setName(customerReqDto.name());
		customer.setIdproof(Idproof.valueOf(customerReqDto.idproof()));
		return customer;
	}
}
