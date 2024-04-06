package com.javadeveloper.car_store_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadeveloper.car_store_management.dto.Car;
import com.javadeveloper.car_store_management.dto.Person;
import com.javadeveloper.car_store_management.service.CarPersonPanAddressService;

@RestController
@RequestMapping(value = "/carOpereation")
public class CarPersonPanAddressController {
	@Autowired
	private CarPersonPanAddressService carPersonPanAddressService;
	
	@PostMapping(value = "/saveCar")
	public Car saveCar(@RequestBody Car car) {
		return carPersonPanAddressService.addCarService(car); 
	}
	
	@PostMapping(value = "/sevePerson")
	public Person savePerson(Person person ) {
		return carPersonPanAddressService.saveAllPersonDetailsService( person, person.getPan(), person.getAddress());
		
	}
	
	

}
