package com.sun.microservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestModel {
	@NotNull(message = "First name can not be null")
	@Size(min = 2, message = "First name must not be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last name can not be null")
	@Size(min = 2, message = "Last name must not be less than 2 characters")
	private String lastName;
	@NotNull(message = "Password can not be null")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters")
	private String password;
	@NotNull(message = "Email can not be null")
	@Email
	private String email;

}
