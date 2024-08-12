package com.example.demo.services;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Car;
import com.example.demo.repositories.CarRepository;

import jakarta.validation.Valid;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;
	

	public Collection<Car> getCars() {
		
		//return db.values();
		return carRepository.findAll();
	}

	public Car getCarById(String id) {
		return carRepository.findById(Integer.valueOf(id)).orElse(null);
		
	}

	public boolean  remove(String id) {
		// TODO Auto-generated method stub
		carRepository.deleteById(Integer.valueOf(id));
		return true;
	}

	public void createCar(@Valid Car car) {

		carRepository.save(car);
		
	}
	
	public void createCars(@Valid List<Car> cars) {
		carRepository.saveAll(cars);
		
	}

	public boolean updateCar(Car car) {
		Car existingCar = carRepository.findById(car.getId()).orElse(null);
		if(existingCar != null) {
			existingCar.setMake(car.getMake());
			existingCar.setModel(car.getModel());
			carRepository.save(existingCar);
			return true;
		}
		else return false;
			
		
        }
	
}
