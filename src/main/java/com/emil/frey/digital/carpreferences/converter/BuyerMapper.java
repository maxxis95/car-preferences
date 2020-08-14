package com.emil.frey.digital.carpreferences.converter;

import java.util.List;

import org.mapstruct.Mapper;

import com.emil.frey.digital.carpreferences.data.entity.BuyerEntity;
import com.emil.frey.digital.carpreferences.data.entity.CarEntity;
import com.emil.frey.digital.carpreferences.data.entity.CarPreferencesEntity;
import com.emil.frey.digital.carpreferences.data.entity.EngineEntity;
import com.emil.frey.digital.carpreferences.dto.Buyer;
import com.emil.frey.digital.carpreferences.dto.Car;
import com.emil.frey.digital.carpreferences.dto.CarPreferences;
import com.emil.frey.digital.carpreferences.dto.Engine;

@Mapper(componentModel = "spring")
public interface BuyerMapper {
	
	BuyerEntity buyerToBuyerEnity (Buyer buyer);
	
	Buyer buyerEnityToBuyer (BuyerEntity buyer);
	
	CarPreferencesEntity carPreferencesToCarPreferencesEnity (CarPreferences carPreferences);
	
	EngineEntity engineToEngineEnity (Engine engine);
	
	CarPreferences CarPreferencesEnityToCarPreferences (CarPreferencesEntity carPreferences);
	
	Engine engineEntityToEngine (EngineEntity engine);
	
	List<Engine> engineEntitiesToEngines (List<EngineEntity> engines);
	
	List<BuyerEntity> buyersToBuyerEntitys (List<Buyer> buyer);
	
	List<Buyer> buyerEnitysToBuyers (List<BuyerEntity> buyer);
	
	List<Car> carEntitiesToCars (List<CarEntity> cars);
	
	Car carEntityToCar (CarEntity car);
	
}
