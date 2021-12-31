/**
 * 
 */
package com.sun.microservices.citizenservice.service;

import java.util.List;

import com.sun.microservices.citizenservice.entity.Citizen;

/**
 * @author USER
 *
 */

public interface ICitizenService {
	
	public List<Citizen>  findbyVaccinationCenterId(Integer Id);
	
	public Citizen add(Citizen citizen);
}
