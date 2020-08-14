package com.emil.frey.digital.carpreferences.data.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emil.frey.digital.carpreferences.data.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {


}
