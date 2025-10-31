package com.hex.fsc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.fsc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	Optional<User> findByUsername(String username);

}
