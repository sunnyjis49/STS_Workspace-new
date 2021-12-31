package com.sun.microservices.vaccinationcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.sun.microservices.vaccinationcenter.model.Citizen;
import com.sun.microservices.vaccinationcenter.model.RequiredResponse;
import com.sun.microservices.vaccinationcenter.service.ICenterService;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private ICenterService centerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newCenter) {
		VaccinationCenter center = centerService.add(newCenter);
		return new ResponseEntity<VaccinationCenter>(center, HttpStatus.OK);
	}
	
	@GetMapping("/getAlldataOnCenterId/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAlldataOnCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse = new RequiredResponse();
		//1st get vaccination center details
		VaccinationCenter center = centerService.findById(id);
		requiredResponse.setCenter(center);
		//2nd get all citizens registered to vaccination center
		//List<Citizen> citizenList = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		List<Citizen> citizenList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(citizenList);
		return  new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
	
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
		RequiredResponse requiredResponse = new RequiredResponse();
		VaccinationCenter center = centerService.findById(id);
		requiredResponse.setCenter(center);
		return  new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}

}
