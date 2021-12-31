/**
 * 
 */
package com.sun.springboot.jasperreport.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.springboot.jasperreport.entity.User;
import com.sun.springboot.jasperreport.service.ReportService;
import com.sun.springboot.jasperreport.service.UserService;

import net.sf.jasperreports.engine.JRException;

/**
 * @author SUN
 *
 */
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ReportService reportService;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
	}
	
	@GetMapping("/getReport/{reportFormat}")
	public String generateReport(@PathVariable String reportFormat, @RequestParam String title) throws FileNotFoundException, JRException{
		System.out.println("title: "+title);
		return reportService.exportReport(reportFormat, title);
	}
}
