package com.emil.frey.digital.carpreferences.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.emil.frey.digital.carpreferences.data.entity.CarEntity;
import com.emil.frey.digital.carpreferences.data.repository.CarRepository;
import com.emil.frey.digital.carpreferences.data.repository.EngineRepository;
import com.emil.frey.digital.carpreferences.dto.ECarType;

import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	private final EngineRepository engineRepository;
	
	@Override
	public void insertCars() {
		
		CarEntity carEntity = new CarEntity();
		carEntity.setColour("black");
		carEntity.setModel("m6");
		carEntity.setName("Bmw series 6");
		carEntity.setType(ECarType.COUPE);
		carEntity.setEngine(engineRepository.findById(3L).get());
		carRepository.save(carEntity);

		CarEntity carEntity2 = new CarEntity();
		carEntity2.setColour("red");
		carEntity2.setModel("m6");
		carEntity2.setName("Bmw series 6");
		carEntity2.setType(ECarType.CONVERTIBLE);
		carEntity2.setEngine(engineRepository.findById(3L).get());
		carRepository.save(carEntity2);
		
		CarEntity carEntity3 = new CarEntity();
		carEntity3.setColour("black");
		carEntity3.setModel("s65");
		carEntity3.setName("Mercedes S amg");
		carEntity3.setType(ECarType.COUPE);
		carEntity3.setEngine(engineRepository.findById(3L).get());
		carRepository.save(carEntity3);
		
	}
}
