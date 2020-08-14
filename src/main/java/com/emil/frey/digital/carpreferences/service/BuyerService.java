package com.emil.frey.digital.carpreferences.service;

import java.util.List;

import com.emil.frey.digital.carpreferences.dto.Buyer;
import com.emil.frey.digital.carpreferences.dto.Car;
import com.emil.frey.digital.carpreferences.dto.Engine;

import javassist.NotFoundException;

public interface BuyerService {
	
	List<Buyer> getAllBuyers();
	List<Buyer> getBuyersByNameAndLastName(String name, String lastName);
	List<Engine> getAllEngines();
	void saveBuyer(Buyer buyer);
	void updateBuyer(Long id, Buyer buyer) throws NotFoundException;
	List<Car> getCarsByPreferences(Long buyerId) throws Exception;

}
