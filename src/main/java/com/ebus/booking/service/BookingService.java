package com.ebus.booking.service;

import org.springframework.stereotype.Service;

import com.ebus.booking.Exception.BookingException;
import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketStatusResponseDto;

@Service
public interface BookingService {
    BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto) throws BookingException;
    public TicketStatusResponseDto cancelTicket(String ticketid,Integer userid);
}
