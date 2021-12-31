package com.sun.microservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sun.microservice.dto.UserDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto userDetails);
	
	UserDto getUserDetailsByEmail(String email);

}
