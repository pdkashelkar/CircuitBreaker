package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.UserClient;
import com.order.model.UserDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

	@Autowired
	private UserClient userClient;
	
	@CircuitBreaker(name="UserServiceCB", fallbackMethod = "fallBackGetUser")
	public UserDetails getUser(long userId) {
		UserDetails user = userClient.getUserById(userId);
		user.setError(false);
		return user;
	}
	
	public UserDetails fallBackGetUser(long userId, Throwable t) {
		UserDetails user = new UserDetails();
		user.setError(true);
		user.setErrMsg("User service is temporarily unavailable " + t.getMessage());
		return user;
	}
}
