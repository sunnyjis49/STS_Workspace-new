/**
 * 
 */
package com.sun.springboot.jasperreport.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.springboot.jasperreport.entity.User;

/**
 * @author SUN
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
