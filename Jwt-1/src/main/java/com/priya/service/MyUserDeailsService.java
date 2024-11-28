package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.priya.model.UserPrinciple;
import com.priya.model.Users;
import com.priya.repo.UserRepo;

@Component
public class MyUserDeailsService implements UserDetailsService {
	
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		return new UserPrinciple(user);
	}

}
