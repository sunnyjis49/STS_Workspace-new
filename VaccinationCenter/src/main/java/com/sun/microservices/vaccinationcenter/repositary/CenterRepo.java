/**
 * 
 */
package com.sun.microservices.vaccinationcenter.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.microservices.vaccinationcenter.entity.VaccinationCenter;

/**
 * @author USER
 *
 */
@Repository
public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
