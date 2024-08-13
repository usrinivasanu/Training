package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data
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
	
	public Car() {
	
	}
}
