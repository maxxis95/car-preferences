package com.emil.frey.digital.carpreferences.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emil.frey.digital.carpreferences.dto.ECarType;

import lombok.Data;

@Data
@Entity
@Table(name = "car_preferences")
public class CarPreferencesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private EngineEntity engine;
	
	private ECarType type;
	
	private String colour;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carPreferences")
    private List<BuyerEntity> buyers;

}
