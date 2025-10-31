package com.hex.trs.service;

import org.springframework.stereotype.Service;

import com.hex.trs.model.User;
import com.hex.trs.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
