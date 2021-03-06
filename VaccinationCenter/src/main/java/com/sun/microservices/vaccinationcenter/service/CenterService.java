/**
 * 
 */
package com.sun.microservices.vaccinationcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.sun.microservices.vaccinationcenter.repositary.CenterRepo;

/**
 * @author USER
 *
 */
@Service
public class CenterService implements ICenterService{
	
	@Autowired
	private CenterRepo centerRepo;
	
	@Override
	public VaccinationCenter add(VaccinationCenter newCenter) {
		// TODO Auto-generated method stub
		return centerRepo.save(newCenter);
	}

	@Override
	public VaccinationCenter findById(Integer id) {
		// TODO Auto-generated method stub
		return centerRepo.findById(id).get();
	}

}
