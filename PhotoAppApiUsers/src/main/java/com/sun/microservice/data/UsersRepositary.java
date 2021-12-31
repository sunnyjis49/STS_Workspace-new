package com.sun.microservice.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositary extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);

}
