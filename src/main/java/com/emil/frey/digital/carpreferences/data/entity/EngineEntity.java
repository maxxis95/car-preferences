package com.emil.frey.digital.carpreferences.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "engine", uniqueConstraints = @UniqueConstraint(
		columnNames={"size", "cylinder", "horsePower"}))
public class EngineEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Double size;
	
	private Integer cylinder;
	
	private Integer horsePower;
     
	@JsonManagedReference
    @OneToMany(mappedBy = "engine", cascade = CascadeType.ALL)
	private List<CarEntity> cars;

}
