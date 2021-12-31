package com.sun.springboot.jasperreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.springboot.jasperreport.entity.User;
import com.sun.springboot.jasperreport.repositary.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
	
		return userRepository.findAll();
	}
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id){
		userRepository.deleteById(id);
		System.out.println("Deleted succesfully....");
	}
}
