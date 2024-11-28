package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.priya.model.Users;
import com.priya.repo.UserRepo;

@Component
public class UserService {
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	UserRepo repo;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return user;
	}

	public String verify(Users user) {
		Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication!=null)
			return jwtService.generateTokens(user.getUsername());
		
		return "not success";
	}

}
