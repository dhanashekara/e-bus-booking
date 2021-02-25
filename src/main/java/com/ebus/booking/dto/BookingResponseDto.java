package com.ebus.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookingResponseDto {
  private double totalAmount;
  private String userName;
  private String status;
  private double foodTotalAmount;
  private double amount;
  private List<TicketResponseDto> ticketResponseDtoList;
}
