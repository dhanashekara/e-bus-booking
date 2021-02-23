package com.ebus.booking.service;

import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import com.ebus.booking.dto.UserRequestDto;

public interface BookingService {
    public BookingResponseDto bookTicket(UserRequestDto userRequestDto, TicketRequestDto ticketRequestDto);
}
