package com.priya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByUsername(String username);

}
