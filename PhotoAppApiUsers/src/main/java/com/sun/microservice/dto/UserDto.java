/**
 * 
 */
package com.sun.microservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author USER
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399138032989196537L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userId;
	private String encryptedPassword;

}
