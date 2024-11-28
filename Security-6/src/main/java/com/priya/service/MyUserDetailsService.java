package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.priya.model.UserPrincipal;
import com.priya.model.Users;
import com.priya.repo.UserDetailsRep;

@Component
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDetailsRep rep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = rep.findByUsername(username);
		if(user==null)
			System.out.println("Not Found");
			
		return new UserPrincipal(user);
	}
}