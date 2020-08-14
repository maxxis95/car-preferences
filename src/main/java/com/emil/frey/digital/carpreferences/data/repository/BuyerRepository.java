package com.emil.frey.digital.carpreferences.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emil.frey.digital.carpreferences.data.entity.BuyerEntity;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {

	List<BuyerEntity> findByNameOrLastName(String name, String lastName);
	List<BuyerEntity> findByName(String name);
	List<BuyerEntity> findByLastName(String lastName);
}
