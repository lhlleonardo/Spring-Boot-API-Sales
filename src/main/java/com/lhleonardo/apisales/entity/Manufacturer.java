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

	public Manufacturer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
