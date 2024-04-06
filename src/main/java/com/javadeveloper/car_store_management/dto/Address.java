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
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String city;
	private String street;
	private String flatNo;
	private String townNo;
	
	@OneToOne (cascade = CascadeType.ALL)
	Pan pan;
	

	public Address(String city, String street, String flatNo, String townNo, Pan pan) {
		super();
		this.city = city;
		this.street = street;
		this.flatNo = flatNo;
		this.townNo = townNo;
		this.pan = pan;
	}

}
