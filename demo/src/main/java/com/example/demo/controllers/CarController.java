package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.example.demo.services.CarService;

import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarController {
	@Autowired
	private CarService carService;
	
	
	@GetMapping("/cars")
	public Collection<Car> getcar(){
		return carService.getCars();
	}
	
	@GetMapping("/cars/{id}")
	public Car getcar(@PathVariable String id){
		return carService.getCarById(id);
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<String> deletecar(@PathVariable String id){
		System.out.println("in delete method");
		boolean isDeleted = carService.remove(id);
		if (isDeleted) {
            return ResponseEntity.ok("Car with id " + id + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
		
	}
	
	@PutMapping("/cars/")
	public ResponseEntity<String> updateCarById(@RequestBody @Valid Car car){		
		boolean isUpdated = carService.updateCar(car);
		if (isUpdated) {
            return ResponseEntity.ok("Car with id " + car.getId() + " has been updated.");
        } else {
            return ResponseEntity.notFound().build();
        }
		
	}
	
	@PostMapping("/car/")
	public void createcar(@RequestBody @Valid Car car){
		carService.createCar(car);
		
		
				
	}
	
	@PostMapping("/cars/")
	public void createcars(@RequestBody @Valid List<Car> cars){
		carService.createCars(cars);
		
		
				
	}

}
