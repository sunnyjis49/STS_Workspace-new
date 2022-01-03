package com.sun.security.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.security.jwt.api.entity.User;
import com.sun.security.jwt.api.repositary.UserRepositary;

@SpringBootApplication
public class SpringSecurityJwtExpampleApplication {
	
	@Autowired
	private UserRepositary userRepositary;
	
	@PostConstruct
	public void initUsers() {
		List<User> usersList = Stream.of(new User(101,"SAhid","password","sahid@yopmail.com"),
				new User(102,"user1","pwd1","user1@yopmail.com"),
				new User(103,"user2","pwd2","user2@yopmail.com"),
				new User(104,"user3","pwd3","user3@yopmail.com")).collect(Collectors.toList());
		userRepositary.saveAll(usersList);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExpampleApplication.class, args);
	}

}
