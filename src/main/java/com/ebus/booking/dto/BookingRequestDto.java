package com.ebus.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookingRequestDto {
    private String userName;
    private int userId;
    private String email;
    private String address;
    private int mobileNumber;
    private int age;
    List<TicketRequestDto> ticketRequestDtoList;
}
