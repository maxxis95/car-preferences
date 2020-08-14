package com.emil.frey.digital.carpreferences.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emil.frey.digital.carpreferences.data.entity.EngineEntity;

@Repository
public interface EngineRepository extends JpaRepository<EngineEntity, Long> {

	Optional<EngineEntity> findBySizeAndCylinderAndHorsePower(
			Double size, Integer cylinder, Integer horsePower);

}
