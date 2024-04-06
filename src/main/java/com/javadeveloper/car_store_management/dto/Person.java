package com.javadeveloper.car_store_management.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personId;
	private String personName;
	private long personPhone;
	private String personEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pan pan;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	

	public Person(String personName, long personPhone, String personEmail, Pan pan, Address address) {
		super();
		this.personName = personName;
		this.personPhone = personPhone;
		this.personEmail = personEmail;
		this.pan = pan;
		this.address = address;
	}


	public Person(String personName, long personPhone, String personEmail, Address address) {
		super();
		this.personName = personName;
		this.personPhone = personPhone;
		this.personEmail = personEmail;
		this.address = address;
	}
}
