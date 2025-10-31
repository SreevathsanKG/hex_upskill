package com.hex.trs.mapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.enums.Role;
import com.hex.trs.model.User;

@Component
public class UserMapper {
	
	public User toEntity(CustomerReqDto customerReqDto) {
		User user = new User();
		String username = new String((Base64.getDecoder().decode(customerReqDto.authCode())), StandardCharsets.UTF_8).split(":")[0];
		String password = new String((Base64.getDecoder().decode(customerReqDto.authCode())), StandardCharsets.UTF_8).split(":")[1];
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(Role.CUSTOMER);
		System.out.println(user);
		return user;
	}

}


/*
 * String authCode = dto.autoCode(); // Sample :- aGFycnk6aGFycnkxMjM=
 * // 1. Decode auth code
 * byte[] code =  Base64.getDecoder().decode(authCode);
 * // 2. Convert the byte array into a String using UTF-8 encoding
 * String usernamePass = new String(code, StandardCharsets.UTF_8);
 * //System.out.println(usernamePass); //harry:harry123
 * String username = usernamePass.split(":")[0];
 * String password = usernamePass.split(":")[1];
 *
 */