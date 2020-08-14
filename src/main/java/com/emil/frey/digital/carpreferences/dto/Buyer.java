package com.emil.frey.digital.carpreferences.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Buyer {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	@Email
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotNull
	private CarPreferences carPreferences;
}
