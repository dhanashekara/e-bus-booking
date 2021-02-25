package com.ebus.booking.controller;

import com.ebus.booking.Exception.BookingException;
import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.service.BookingServicImpl;
import com.ebus.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponseDto> bookTicket(@RequestBody BookingRequestDto bookingRequestDto) throws BookingException {
        LOGGER.info("Inside controller");
        return new ResponseEntity<>(bookingService.bookTicket(bookingRequestDto),HttpStatus.OK);
    }
}
