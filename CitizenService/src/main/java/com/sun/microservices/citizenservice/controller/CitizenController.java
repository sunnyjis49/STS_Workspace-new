/**
 * 
 */
package com.sun.microservices.citizenservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.microservices.citizenservice.entity.Citizen;
import com.sun.microservices.citizenservice.service.ICitizenService;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private ICitizenService citiService;

	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getCitizenByCenterId(@PathVariable int id) {
		List<Citizen> citizenList = citiService.findbyVaccinationCenterId(id);
		return new ResponseEntity<List<Citizen>>(citizenList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@Valid @RequestBody Citizen newCitizen) {
		Citizen citizen = citiService.add(newCitizen);
		return new ResponseEntity<Citizen>(citizen, HttpStatus.OK);
	}
}
