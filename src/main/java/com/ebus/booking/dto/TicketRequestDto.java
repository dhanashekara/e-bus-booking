package com.ebus.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketRequestDto {

    private String source;
    private String destination;
    private int age;
    private int seatNo;
    private Date date;
    private String typeOfTicket;
    private double amount;

}
