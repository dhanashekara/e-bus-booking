package com.ebus.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebus.booking.entity.Ticket;
import com.ebus.booking.service.TicketServiceImpl;

@RestController
public class TicketController {
	
	@Autowired
	private TicketServiceImpl tickerService;
	
	@GetMapping("/tickets/{​​​​​​​userId}​​​​​​​")
	public ResponseEntity<List<Ticket>> bookTicket(int userId){
		return new ResponseEntity<List<Ticket>>(tickerService.getTicketDetails(userId),HttpStatus.OK);
		
	}

}
