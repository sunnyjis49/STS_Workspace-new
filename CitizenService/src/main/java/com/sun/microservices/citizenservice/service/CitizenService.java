/**
 * 
 */
package com.sun.microservices.citizenservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.microservices.citizenservice.entity.Citizen;
import com.sun.microservices.citizenservice.repositary.CitizenRepo;

/**
 * @author USER
 *
 */
@Service
public class CitizenService implements ICitizenService{
	@Autowired
	private CitizenRepo citiRepo;

	public List<Citizen>  findbyVaccinationCenterId(Integer Id){
		return citiRepo.findByVaccinationCenterId(Id);
	}
	
	public Citizen add(Citizen citizen){
		return citiRepo.save(citizen);
	}

}
