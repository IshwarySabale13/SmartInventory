package com.inventory.smartinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.smartinventory.config.JwtUtil;
import com.inventory.smartinventory.dto.LoginRequest;
import com.inventory.smartinventory.dto.LoginResponse;
import com.inventory.smartinventory.model.User;
import com.inventory.smartinventory.service.UserService;

@RestController
@RequestMapping("/users")
public class Userontroller 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public User saveUser(@RequestBody User user)
	{
		return userService.saveUser(user); 
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest)
	{
	    User user = userService.login(
	            loginRequest.getUsername(),
	            loginRequest.getPassword()
	    );

	    if(user == null)
	    {
	        return null;
	    }

	    String token = jwtUtil.generateToken(user.getUsername());

	    return new LoginResponse(
	            token,
	            user.getUsername(),
	            user.getRole()
	    );
	}
	
}
