package com.hex.fsc.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hex.fsc.dto.CompanyReqDto;
import com.hex.fsc.mapper.CompanyMapper;
import com.hex.fsc.mapper.UserMapper;
import com.hex.fsc.model.Company;
import com.hex.fsc.model.User;
import com.hex.fsc.repository.CompanyRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;
	private final UserService userService;
	private final UserMapper userMapper;
	private final CompanyMapper companyMapper;
	private final PasswordEncoder passwordEncoder;
	
	public void postCompany(@Valid CompanyReqDto companyReqDto) {
		Company company = companyMapper.toEntity(companyReqDto);
		User user = userMapper.toEntity(companyReqDto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userService.save(user);
		company.setUser(user);
		companyRepository.save(company);
	}

}
