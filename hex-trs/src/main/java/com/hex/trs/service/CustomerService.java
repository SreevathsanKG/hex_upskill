package com.hex.trs.service;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.dto.CustomerTicketDto;
import com.hex.trs.mapper.CustomerMapper;
import com.hex.trs.mapper.UserMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.CustomerPlan;
import com.hex.trs.model.Plan;
import com.hex.trs.model.User;
import com.hex.trs.repository.CustomerPlanRepository;
import com.hex.trs.repository.CustomerRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerPlanRepository customerPlanRepository;
	private final PlanService planService;
	private final UserService userService;
	private final CustomerMapper customerMapper;
	private final UserMapper userMapper; 
	private final PasswordEncoder passwordEncoder;

    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer ID Invalid"));
    }

	public List<CustomerDto> getCustomerWithTicketsCount() {
		return customerRepository.getCustomerWithTicketsCount();
	}

	public void postCustomer(@Valid CustomerReqDto customerReqDto) {
		Customer customer = customerMapper.toEntity(customerReqDto);
		User user = userMapper.toEntity(customerReqDto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		customer.setUser(user);
		customerRepository.save(customer);		
	}

	public void purchasePlan(String username, Long planId) {
		Customer customer = customerRepository.getByUsername(username);
		Plan plan = planService.getById(planId);
		CustomerPlan customerPlan = new CustomerPlan();
		customerPlan.setCustomer(customer);
		customerPlan.setPlan(plan);
		customerPlan.setStartDate(Instant.now());
		customerPlanRepository.save(customerPlan);
	}

	public List<CustomerTicketDto> getCustomerTicketInfo(String username) {
	return customerRepository.getCustomerTicketInfo(username);
}
}