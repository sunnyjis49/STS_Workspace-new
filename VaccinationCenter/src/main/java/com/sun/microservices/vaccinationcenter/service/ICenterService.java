/**
 * 
 */
package com.sun.microservices.vaccinationcenter.service;

import com.sun.microservices.vaccinationcenter.entity.VaccinationCenter;

/**
 * @author USER
 *
 */
public interface ICenterService {

	VaccinationCenter add(VaccinationCenter newCenter);

	VaccinationCenter findById(Integer id);

}
