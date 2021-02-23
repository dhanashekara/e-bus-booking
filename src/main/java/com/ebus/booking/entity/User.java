package com.ebus.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class User {
	
	@Id
	private int userId;
	private String userName;
	private String address;
	private int age;
	private int mobileNumber;
	private String email;

}
