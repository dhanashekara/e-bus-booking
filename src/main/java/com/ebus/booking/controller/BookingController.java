package com.ebus.booking.controller;

import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import com.ebus.booking.dto.UserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookingController {


    @RequestMapping("/book")
    public BookingResponseDto bookTicket(UserRequestDto userRequestDto, List<TicketRequestDto> ticketRequestDtoList) {

        return null;
    }


}
