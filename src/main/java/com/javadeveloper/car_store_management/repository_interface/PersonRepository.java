package com.javadeveloper.car_store_management.repository_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadeveloper.car_store_management.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Query(value = "SELECT * FROM person WHERE pan_pan_number = ?1", nativeQuery = true)
	  Person findByPanNumber(String Pan_number);
	
	
	@Query(value = "SELECT * FROM person WHERE person_id  = ?1", nativeQuery = true)
	  Person findByPersonId(int pId);
}
