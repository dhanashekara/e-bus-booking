package com.ebus.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Transport {
	
	@Id
	private int transportId;
	private String transportType;
	private String source;
	private String destination;
	private float price_v;
	private float price_n;
}
