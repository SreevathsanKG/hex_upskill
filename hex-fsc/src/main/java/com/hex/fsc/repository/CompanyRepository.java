package com.hex.fsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hex.fsc.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	@Query("select c from Company c where c.user.username=?1")
	Company getByusername(String username);

}
