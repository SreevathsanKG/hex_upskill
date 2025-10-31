package com.hex.fsc.mapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.hex.fsc.dto.CompanyReqDto;
import com.hex.fsc.dto.CustomerReqDto;
import com.hex.fsc.enums.Role;
import com.hex.fsc.model.User;

@Component
public class UserMapper {

	// for customer
	public User toEntity(CustomerReqDto customerReqDto) {
		User user = new User();
		String usernamePassword = new String((Base64.getDecoder().decode(customerReqDto.authCode())), StandardCharsets.UTF_8);
		user.setUsername(usernamePassword.split(":")[0]);
		user.setPassword(usernamePassword.split(":")[1]);
		user.setRole(Role.CUSTOMER);
		return user;
	}
	
	// for company
	public User toEntity(CompanyReqDto companyReqDto) {
		User user = new User();
		String usernamePassword = new String((Base64.getDecoder().decode(companyReqDto.authCode())), StandardCharsets.UTF_8);
		user.setUsername(usernamePassword.split(":")[0]);
		user.setPassword(usernamePassword.split(":")[1]);
		user.setRole(Role.COMPANY);
		return user;
	}
}
