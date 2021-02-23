package com.ebus.booking.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Ticket {
	
	@Id
	@GeneratedValue
	private int ticketId;
	private String source;
	private String destination;
	private int age;
	private int seatNo;
	private int userId;
	private Date dateOfJourney;
	private String typeOfTicket;
	private float amount;
	private String food;
	private float totalAmount;
	private String status;
}
