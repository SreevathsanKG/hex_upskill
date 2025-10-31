package com.hex.fsc.service;

import org.springframework.stereotype.Service;

import com.hex.fsc.model.User;
import com.hex.fsc.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}

}
