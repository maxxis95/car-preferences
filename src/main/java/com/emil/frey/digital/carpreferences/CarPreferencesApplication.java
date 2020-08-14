package com.emil.frey.digital.carpreferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan()
@EntityScan
public class CarPreferencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPreferencesApplication.class, args);
	}

}
