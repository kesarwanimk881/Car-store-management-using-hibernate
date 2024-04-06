package com.javadeveloper.car_store_management.repository_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadeveloper.car_store_management.dto.Car;
import com.javadeveloper.car_store_management.dto.Person;

public interface CarRepository extends JpaRepository<Car, Integer>{
	
	@Query(value = "SELECT * FROM car WHERE car_id = ?1", nativeQuery = true)
	  Car findByPanNumber(int car_id);

}
