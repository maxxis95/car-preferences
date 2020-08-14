package com.emil.frey.digital.carpreferences.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class Car {
	
	private String name;
	
	private String model;
	
	private ECarType type;
	
	private String colour;
	
	@JsonBackReference
	private Engine engine;

}
