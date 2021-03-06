/**
 * 
 */
package com.sun.microservices.citizenservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author USER
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Id cannot be null")
	private int id;
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, message = "Name cannot be less than two characters")
	private String name;
	
	@Column(nullable = false)
	@NotNull(message = "vaccinationCenterId cannot be null")
	private int vaccinationCenterId;

}
