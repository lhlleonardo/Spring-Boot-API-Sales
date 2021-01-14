package com.lhleonardo.apisales.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY")
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deliveryId;
	
	private String mode;

	public Delivery() {
		super();
	}

	public Delivery(Long deliveryId, String mode) {
		super();
		this.deliveryId = deliveryId;
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
