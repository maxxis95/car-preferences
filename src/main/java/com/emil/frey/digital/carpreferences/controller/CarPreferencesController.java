package com.emil.frey.digital.carpreferences.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emil.frey.digital.carpreferences.dto.Buyer;
import com.emil.frey.digital.carpreferences.dto.Car;
import com.emil.frey.digital.carpreferences.dto.Engine;
import com.emil.frey.digital.carpreferences.service.BuyerService;
import com.emil.frey.digital.carpreferences.service.CarService;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CarPreferencesController {
	
	private final BuyerService buyerService;
	private final CarService carService;
	
	@GetMapping(value = "/buyers")
	public List<Buyer> buyers(@RequestParam("name") Optional<String> name, 
			@RequestParam("lastName") Optional<String> lastName) {
		
		if(!name.isPresent() && !lastName.isPresent()) {
			return buyerService.getAllBuyers();
		} 
	
		return buyerService.getBuyersByNameAndLastName(name.orElse(null), lastName.orElse(null));
	}
	
	@GetMapping(value = "/engine")
	public List<Engine> engine() {
		
		return buyerService.getAllEngines();
	}
	
	
	@PostMapping(value = {"/addBuyer", "/addBuyer/{id}"})
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void submit(@PathVariable(name = "id") Optional<Long> buyerId, 
    		@Valid @RequestBody Buyer buyer) throws NotFoundException {
		
		if(buyerId.isPresent()) {
			
			buyerService.updateBuyer(buyerId.get(), buyer);	
			log.info("Updated buyer with id: {}", buyerId.get());
			
		} else {
			
			buyerService.saveBuyer(buyer);
			log.info("Created new buyer");
			
		}
    }
	
	@GetMapping(value = "/carsByPreferences/{buyerId}")
	public List<Car> getCarsByPreferences(@PathVariable(name = "buyerId") @NotNull Long buyerId) throws Exception {
		
		return buyerService.getCarsByPreferences(buyerId);
		
	}

	@GetMapping(value = "/insertCars")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void insertCars() {
		
		carService.insertCars();
			
	}


}
