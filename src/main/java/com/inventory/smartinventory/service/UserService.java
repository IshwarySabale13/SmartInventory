package com.inventory.smartinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.User;
import com.inventory.smartinventory.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User saveUser(User user)
	{
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		return userRepository.save(user);
	}
	
	public User login(String username , String password)
	{
		User user = userRepository.findByUsername(username);
		
		if(user == null)
		{
			return null;
		}
		
		if(!passwordEncoder.matches(password, user.getPassword()))
		{
			return null;
		}
		
		return user;
	}
}
