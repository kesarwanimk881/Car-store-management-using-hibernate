package com.javadeveloper.car_store_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pan {
	
	@Id
	private String panNumber;
	private String dob;
	private String gender;
	
	@OneToOne(mappedBy = "pan")
	Address address;
	
	@OneToOne(mappedBy = "pan")
	Person person;

	public Pan(String panNumber, String dob, String gender) {
		super();
		this.panNumber = panNumber;
		this.dob = dob;
		this.gender = gender;
	}

}
