package com.sun.springboot.caching.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sun.springboot.caching.entity.User;
import com.sun.springboot.caching.repositary.UserRepository;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	@Cacheable(cacheNames="users_cache", key="#id")
	public User getUser(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		logger.info("Fetching from DB....");
		if (user.isPresent()) {
			return user.get();
		}else{
			return new User();
		}
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@CacheEvict(cacheNames="users_cache", key="#id")
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		logger.info("Deleted from DB..");
		return "Deleted successfully";
	}
	
	@CachePut(cacheNames="users_cache", key="#user.id")
	public User update(User user) {
		
		userRepository.updateAddressById(user.getId(), user.getAddress());
		logger.info("Updating DB....");
		return user;
		
	}
}
