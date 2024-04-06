package com.javadeveloper.car_store_management.repository_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadeveloper.car_store_management.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	@Query(value = "SELECT * FROM address WHERE address_id = ?1", nativeQuery = true)
	  Address findByAddressId(int Address_id);
}
