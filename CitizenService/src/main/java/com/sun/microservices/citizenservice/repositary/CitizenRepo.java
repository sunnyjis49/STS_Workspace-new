/**
 * 
 */
package com.sun.microservices.citizenservice.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.microservices.citizenservice.entity.Citizen;

/**
 * @author USER
 *
 */
@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen>  findByVaccinationCenterId(Integer Id);
	

}
