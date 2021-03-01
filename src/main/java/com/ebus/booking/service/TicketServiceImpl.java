package com.ebus.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebus.booking.entity.Ticket;
import com.ebus.booking.repository.TicketRepository;

@Service
public class TicketServiceImpl {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	
	public List<Ticket> getTicketDetails(int userId){
		List<Ticket> list =  ticketRepository.findByUserId(userId);
		return list;
		
	}

}
