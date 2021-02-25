package com.ebus.booking.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TicketResponseDto {

    private String ticketId;
    private int age;
    private int seatNo;
    private double amount;
    private String typeOfTicket;
}
