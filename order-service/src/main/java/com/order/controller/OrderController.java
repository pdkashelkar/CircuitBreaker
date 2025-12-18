package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.UserDetails;
import com.order.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String getUser() {
		return "Working";
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDetails> getUser(@PathVariable("userId") long userId) {
		UserDetails  user = userService.getUser(userId);
		if(null==user || user.isError()) {
			ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Please try again later");
		}
		return ResponseEntity.ok(user);
	}
}
