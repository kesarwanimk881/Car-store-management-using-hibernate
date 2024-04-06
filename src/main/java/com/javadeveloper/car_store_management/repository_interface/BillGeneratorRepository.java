package com.javadeveloper.car_store_management.repository_interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadeveloper.car_store_management.dto.BillGenerator;

public interface BillGeneratorRepository extends JpaRepository<BillGenerator, Integer>{

	@Query(value = "SELECT * FROM bill_generator WHERE bill_id = ?1", nativeQuery = true)
	  BillGenerator findByBillId(int bill_id);
}
