package com.javadeveloper.car_store_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javadeveloper.car_store_management.dto.Address;
import com.javadeveloper.car_store_management.dto.BillGenerator;
import com.javadeveloper.car_store_management.dto.Car;
import com.javadeveloper.car_store_management.dto.Pan;
import com.javadeveloper.car_store_management.dto.Person;
import com.javadeveloper.car_store_management.repository_interface.AddressRepository;
import com.javadeveloper.car_store_management.repository_interface.BillGeneratorRepository;
import com.javadeveloper.car_store_management.repository_interface.CarRepository;
import com.javadeveloper.car_store_management.repository_interface.PanRepository;
import com.javadeveloper.car_store_management.repository_interface.PersonRepository;

@Repository
public class CarPersonPanAddressDao {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PanRepository panRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private BillGeneratorRepository billGeneratorRepository;

	/*
	 * addCar Dao
	 */

	public Car addCarDao(Car car) {
		carRepository.save(car);
		return car;
	}

	/*
	 * addPan Dao
	 */

	public Pan addPanDao(Pan pan) {
		panRepository.save(pan);
		return pan;
	}

	/*
	 * addAddress Dao
	 */

	public Address addAddressDao(Address address) {
		addressRepository.save(address);
		return address;
	}

	/*
	 * addPerson Dao
	 */

	public Person addPersonDao(Person person) {
		person.setPan(person.getAddress().getPan());
		personRepository.save(person);
		return person;
	}

	// get details method stared here

	/*
	 * get person by person id
	 */
	public Person getPersonDao(int personId) {
		Person person = personRepository.findByPersonId(personId);
		return person;
	}

	/*
	 * get person by pan id
	 */
	public Person getPersonByPanIdDao(String panId) {
		Person person = personRepository.findByPanNumber(panId);
		return person;
	}

	/*
	 * get pan by pan id
	 */
	public Pan getPanDao(String panId) {
		Pan pan = panRepository.findByPanNumber(panId);
		return pan;
	}

	/*
	 * get getCar by car id
	 */
	public Car getCarDao(int carId) {
		Car car = carRepository.getById(carId);
		return car;
	}

	/*
	 * get address by address id
	 */
	public Address getAddressDao(int addressId) {
		Address address = addressRepository.findByAddressId(addressId);
		return address;
	}

	/*
	 * get bill by bill id
	 */
	public BillGenerator getBillDao(int billId) {
		BillGenerator billGenerator = billGeneratorRepository.findByBillId(billId);
		return billGenerator;
	}

	/*
	 * update car Dao
	 */
	public Car updateCarDao(Car car, Person person) {
		car.setPerson(person);
		carRepository.save(car);
		
		return car;
	}
	
	/*
	 * generateBillDao Dao
	 */
	
	public BillGenerator generateBillDao(BillGenerator billGenerator, Car car, Person person) {
		car= updateCarDao(car, person);
		billGenerator.setPan(person.getAddress().getPan());
		billGenerator.setPerson(person);
		billGenerator.setCar(car);
		return billGeneratorRepository.save(billGenerator);
		
	}
	
	/*
	 * save Person Pan Address details
	 */
	
	
	public Person saveAllPersonDetailsDao(Person person, Pan pan, Address address) {
		addAddressDao(address);
		addPanDao(pan);
		addPersonDao(person);
		return person;
		
	}
	
	/*
	 * save Person Pan Address Car details
	 */
	
	
	public Person saveAllDao(Person person, Pan pan, Address address, Car car) {
		
		addAddressDao(address);
		addCarDao(car);
		addPanDao(pan);
		addPersonDao(person);
		return person;	
	}
	
	
	
	
	
}
