package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserDetails;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/allusers")
	public ResponseEntity<List<UserDetails>> getUsers() {
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	@PostMapping("/saveusers")
	public ResponseEntity<List<UserDetails>> createUsers(@RequestBody List<UserDetails> newUsers) {
		return ResponseEntity.ok(userService.createUser(newUsers));
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails newUser) {
		return ResponseEntity.ok(userService.createUser(newUser));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDetails> getUserByUserId(@PathVariable("userId") long userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
}
