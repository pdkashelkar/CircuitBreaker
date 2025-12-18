package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.model.UserDetails;

@FeignClient(name = "user-service", url = "http://localhost:8082")
public interface UserClient {

	@GetMapping("/users/user/{userId}")
	public UserDetails getUserById(@PathVariable("userId") long userId);

}
