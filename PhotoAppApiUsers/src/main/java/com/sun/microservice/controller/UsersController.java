/**
 * 
 */
package com.sun.microservice.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.microservice.dto.UserDto;
import com.sun.microservice.model.CreateUserRequestModel;
import com.sun.microservice.model.CreateUserResponseModel;
import com.sun.microservice.service.UserService;

/**
 * @author Sahidul
 *
 */
@RestController
@RequestMapping("/users")
@Validated
public class UsersController {

	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;

	@GetMapping("/status/check")
	public String status() {
		return "Working on port " + env.getProperty("local.server.port");
	}

	@PostMapping(path = "/createUser", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody @Valid CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		UserDto createUser = userService.createUser(userDto);
		CreateUserResponseModel createUserResponseModel = modelMapper.map(createUser, CreateUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseModel);
	}
}
