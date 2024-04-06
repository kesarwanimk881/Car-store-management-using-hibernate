package com.javadeveloper.car_store_management.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carId;
	private String carName;
	private String carColor;
	private double carPrice;
	private int carModel;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	private Person person;

	public Car(String carName, String carColor, double carPrice, int carModel, Person person) {
		super();
		this.carName = carName;
		this.carColor = carColor;
		this.carPrice = carPrice;
		this.carModel = carModel;
		this.person = person;
	}

}
