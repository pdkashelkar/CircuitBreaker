package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserDetails;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDetails> findAllUsers() {
		return userRepository.findAll();
	}
	
	public UserDetails createUser(UserDetails newUser){
		return userRepository.save(newUser);
	}
	
	public List<UserDetails> createUser(List<UserDetails> newUsers){
		return userRepository.saveAll(newUsers);
	}
	
	public UserDetails getUserById(long userId) {
		return userRepository.findByUserId(userId);
	}
}
