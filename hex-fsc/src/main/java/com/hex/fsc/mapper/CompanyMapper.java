package com.hex.fsc.mapper;

import org.springframework.stereotype.Component;

import com.hex.fsc.dto.CompanyReqDto;
import com.hex.fsc.model.Company;

@Component
public class CompanyMapper {

	public Company toEntity(CompanyReqDto companyReqDto) {
		Company company = new Company();
		company.setName(companyReqDto.name());
		return company;
	}
}
