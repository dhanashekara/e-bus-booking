package com.ebus.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketRequestDto {

    private int age;
    private String personName;
    private int seatNo;
    private Date dateOfJourney;
    private String typeOfTicket;
    private String food;

}
