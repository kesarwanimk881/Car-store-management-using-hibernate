package com.javadeveloper.car_store_management.repository_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadeveloper.car_store_management.dto.Pan;
import com.javadeveloper.car_store_management.dto.Person;

public interface PanRepository extends JpaRepository<Pan, String> {
	
	@Query(value = "SELECT * FROM pan WHERE pan_number = ?1", nativeQuery = true)
	  Pan findByPanNumber(String Pan_number);

}
