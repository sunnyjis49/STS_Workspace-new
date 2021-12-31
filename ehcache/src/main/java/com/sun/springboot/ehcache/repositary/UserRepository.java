/**
 * 
 */
package com.sun.springboot.ehcache.repositary;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sun.springboot.ehcache.entity.User;

/**
 * @author SUN
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	@Modifying
	@Query("update User u set u.address=?2 where u.id=?1")
	int updateAddressById(Long id, String address);

}
