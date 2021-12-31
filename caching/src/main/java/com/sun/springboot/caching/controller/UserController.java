/**
 * 
 */
package com.sun.springboot.caching.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.springboot.caching.entity.User;
import com.sun.springboot.caching.service.UserService;

/**
 * @author SUN
 *
 */
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUsers(@PathVariable Long id){
		return userService.getUser(id);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id){
		return userService.deleteUser(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user){
		return userService.update(user);
	}
	
}
