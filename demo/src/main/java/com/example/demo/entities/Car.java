package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@Data
@Entity
@Table(name = "car")
public class Car {
	@NotNull
	@Id
	@GeneratedValue
	private int id;

    private String make;

    private String model;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Car(int id, String make, String model) {
	
		this.id = id;
		this.make = make;
		this.model = model;
	}
	public Car() {
	
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + "]";
	}

	
	
}
