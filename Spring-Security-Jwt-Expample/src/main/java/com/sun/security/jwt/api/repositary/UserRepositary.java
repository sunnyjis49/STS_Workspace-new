/**
 * 
 */
package com.sun.security.jwt.api.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.security.jwt.api.entity.User;

/**
 * @author USER
 *
 */
@Repository
public interface UserRepositary extends JpaRepository<User, Integer>{

	User findByUserName(String username);

}
