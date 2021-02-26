package com.ebus.booking.service;

import com.ebus.booking.Exception.BookingException;
import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto) throws BookingException;
    public String cancelTicket(String ticketid,Integer userid);
}
