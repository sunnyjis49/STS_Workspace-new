/**
 * 
 */
package com.sun.security.jwt.api.entity;

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
public class AuthRequest {
	private String userName;
	
	private String password;

}
