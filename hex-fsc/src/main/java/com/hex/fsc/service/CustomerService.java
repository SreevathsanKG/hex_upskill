package com.hex.fsc.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hex.fsc.dto.CustomerReqDto;
import com.hex.fsc.mapper.CustomerMapper;
import com.hex.fsc.mapper.UserMapper;
import com.hex.fsc.model.Customer;
import com.hex.fsc.model.User;
import com.hex.fsc.repository.CustomerRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	private final UserMapper userMapper;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	public void postCustomer(@Valid CustomerReqDto customerReqDto) {
		Customer customer = customerMapper.toEntity(customerReqDto);
		User user = userMapper.toEntity(customerReqDto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userService.save(user);
		customer.setUser(user);
		customerRepository.save(customer);
	}

}
