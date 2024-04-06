package com.javadeveloper.car_store_management.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class BillGenerator {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billId;
	private String paymentType;
	private String date;
	private String time;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Car car;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pan pan;

	public BillGenerator(String paymentType, Person person, Pan pan) {
		super();
		this.paymentType = paymentType;
		this.person = person;
		this.pan = pan;
	}

	public BillGenerator(String paymentType, Person person,String date, String time) {
		super();
		this.paymentType = paymentType;
		this.person = person;
		this.date = date;
		this.time= time;
	}

	public BillGenerator(int billId, String paymentType, String date, String time, Car car) {
		super();
		this.billId = billId;
		this.paymentType = paymentType;
		this.date = date;
		this.time = time;
		this.car = car;
	}

	public BillGenerator(String paymentType, String date, String time) {
		super();
		this.paymentType = paymentType;
		this.date = date;
		this.time = time;
	}
}
