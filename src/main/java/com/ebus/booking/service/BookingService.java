package com.ebus.booking.service;

import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto);
}
