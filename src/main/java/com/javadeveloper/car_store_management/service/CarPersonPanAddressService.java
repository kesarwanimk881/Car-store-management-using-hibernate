package com.javadeveloper.car_store_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadeveloper.car_store_management.dao.CarPersonPanAddressDao;
import com.javadeveloper.car_store_management.dto.Address;
import com.javadeveloper.car_store_management.dto.BillGenerator;
import com.javadeveloper.car_store_management.dto.Car;
import com.javadeveloper.car_store_management.dto.Pan;
import com.javadeveloper.car_store_management.dto.Person;

@Service
public class CarPersonPanAddressService {
	@Autowired
	private CarPersonPanAddressDao carPersonPanAddressDao;
	
	/*
	 * save Person Pan Address Car details
	 */
	
	public Person saveAllService(Person person, Pan pan, Address address, Car car) {
		return carPersonPanAddressDao.saveAllDao(person, pan, address, car);
	}
	
	
	/*
	 * save Person Pan Address details
	 */
	
	
	public Person saveAllPersonDetailsService(Person person, Pan pan, Address address) {
		
		return carPersonPanAddressDao.saveAllPersonDetailsDao(person, pan, address);
	}
	

	/*
	 * generateBill Service
	 */
	
	public BillGenerator generateBillService(BillGenerator billGenerator, int carId) {
		Car car = carPersonPanAddressDao.getCarDao(carId);
		if(car!= null) {
//			saveAllService(billGenerator.getPerson(),billGenerator.getPan(), billGenerator.getPerson().getAddress(),car);
			Person person = car.getPerson();
			if(person ==null) {
				
				billGenerator.setCar(car);
				saveAllPersonDetailsService(billGenerator.getPerson(),billGenerator.getPerson().getAddress().getPan() , billGenerator.getPerson().getAddress());
				return carPersonPanAddressDao.generateBillDao(billGenerator, car ,billGenerator.getPerson() );
			}else {
				System.out.println("this car is already sold");
				return null; 
			}
			
		}else 
		{
			System.out.println("Car is not present in store ");
			return null;
		}
	}
	
	/*
	 * generateBill for pre register customer Service
	 */
	
	@SuppressWarnings("unused")
	public BillGenerator generateBillPreRegisterCustomerService(BillGenerator billGenerator, String panNumber, int carId) {
		Car car = carPersonPanAddressDao.getCarDao(carId);
		if(car!= null) {
			System.out.println(car);
//			saveAllService(billGenerator.getPerson(),billGenerator.getPan(), billGenerator.getPerson().getAddress(),car);
			Person person = car.getPerson();
			if(person ==null) {
				
				Pan pan = carPersonPanAddressDao.getPanDao(panNumber);
				System.out.println(pan.getDob());
				if(pan !=null) {
					System.out.println(pan.getDob());
					person = pan.getPerson();
					System.out.println(person.getPersonName());
					billGenerator.setCar(car);
					System.out.println(car);
//					saveAllPersonDetailsService(person,person.getAddress().getPan() , person.getAddress());
					
					return carPersonPanAddressDao.generateBillDao(billGenerator, car ,person );
					
				}else {
					System.out.println("customer is not pre register");
					return null;
				}
			}else {
				System.out.println("this car is already sold");
				return null; 
			}
			
		}else 
		{
			System.out.println("Car is not present in store ");
			return null;
		}
	}
	
	
	/*
	 * addCar Service
	 */
	
	public Car addCarService(Car car) {
		
		return carPersonPanAddressDao.addCarDao(car);
	}
	
	
	/*
	 * get person by pan id
	 */
	public Person getPersonByPanIdService(String panId) {
		return carPersonPanAddressDao.getPersonByPanIdDao(panId); 
	}

}
