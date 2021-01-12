package com.lhleonardo.apisales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long manufacturerId;
	
	@Column(nullable = false)
	private String name;

	public Manufacturer() {
		super();
	}

	public Manufacturer(Long manufacturerId, String name) {
		super();
		this.manufacturerId = manufacturerId;
		this.name = name;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
