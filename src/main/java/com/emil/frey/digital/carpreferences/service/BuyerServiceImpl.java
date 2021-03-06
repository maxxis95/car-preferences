package com.emil.frey.digital.carpreferences.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.emil.frey.digital.carpreferences.converter.BuyerMapper;
import com.emil.frey.digital.carpreferences.data.entity.BuyerEntity;
import com.emil.frey.digital.carpreferences.data.entity.CarEntity;
import com.emil.frey.digital.carpreferences.data.repository.BuyerRepository;
import com.emil.frey.digital.carpreferences.data.repository.CarRepository;
import com.emil.frey.digital.carpreferences.data.repository.EngineRepository;
import com.emil.frey.digital.carpreferences.dto.Buyer;
import com.emil.frey.digital.carpreferences.dto.Car;
import com.emil.frey.digital.carpreferences.dto.Engine;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class BuyerServiceImpl implements BuyerService {

	private final BuyerRepository buyerRepository;
	private final EngineRepository engineRepository;
	private final CarRepository carRepository;
	private final BuyerMapper buyerConverter;
	
	@Override
	public List<Buyer> getAllBuyers() {
		
		return buyerConverter.buyerEnitysToBuyers(buyerRepository.findAll());
		
	}
	
	@Override
	public List<Buyer> getBuyersByNameAndLastName(String name, String lastName) {
		
		return buyerConverter.buyerEnitysToBuyers(
				buyerRepository.findByNameOrLastName(name, lastName));
		
	}
	
	@Transactional
	@Override
	public void saveBuyer(Buyer buyer) {
		
		BuyerEntity buyerEntity = buyerConverter.buyerToBuyerEnity(buyer);
		engineCheck(buyer, buyerEntity);
		buyerRepository.save(buyerEntity);
	}

	@Override
	public List<Engine> getAllEngines() {
		
		return buyerConverter.engineEntitiesToEngines(engineRepository.findAll());
		
	}

	@Transactional
	@Override
	public void updateBuyer(Long id, Buyer buyer) throws NotFoundException {
		
		if(buyerRepository.findById(id).isPresent()) {
			
			BuyerEntity buyerEntity = buyerConverter.buyerToBuyerEnity(buyer);
			buyerEntity.setId(id);
			engineCheck(buyer, buyerEntity);
			buyerRepository.save(buyerEntity);
			
		} else {
			
			log.error("Buyer doesn't exist by id: {} ", id);
			throw new NotFoundException("Buyer doesn't exist by id: "+id);
			
		}
		
	}
	
	private void engineCheck(Buyer buyer, BuyerEntity buyerEntity) {
		
		Engine engine = buyer.getCarPreferences().getEngine();
		
		engineRepository.findBySizeAndCylinderAndHorsePower(engine.getSize(), 
				engine.getCylinder(), engine.getHorsePower()).ifPresent(engineEntity -> 
				buyerEntity.getCarPreferences().setEngine(engineEntity));
	}

	@Override
	public List<Car> getCarsByPreferences(Long buyerId) throws NotFoundException {
		
		Optional<BuyerEntity> buyer = buyerRepository.findById(buyerId);
		if(buyer.isPresent()) {
			
			return buyerConverter.carEntitiesToCars(buyer.get().getCarPreferences().getEngine().getCars().stream()
				.filter(car -> car.getColour().equals(buyer.get().getCarPreferences().getColour()) 
						&& car.getType() == buyer.get().getCarPreferences().
						getType()).collect(Collectors.toList()));
		}
		
		throw new NotFoundException("Buyer doesn't exist by id: " + buyerId);
		
	}
	
}
