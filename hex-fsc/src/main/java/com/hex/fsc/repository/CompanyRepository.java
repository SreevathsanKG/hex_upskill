package com.hex.fsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.fsc.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
