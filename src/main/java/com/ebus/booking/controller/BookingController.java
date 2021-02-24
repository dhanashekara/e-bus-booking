package com.ebus.booking.controller;

import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import com.ebus.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponseDto> bookTicket(@RequestBody BookingRequestDto bookingRequestDto) {
        System.out.println("inside controller");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingService.bookTicket(bookingRequestDto));
    }


}
