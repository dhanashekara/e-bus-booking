package com.ebus.booking.service;

import com.ebus.booking.Exception.BookingException;
import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import com.ebus.booking.dto.TicketResponseDto;
import com.ebus.booking.dto.TicketStatusResponseDto;
import com.ebus.booking.entity.Ticket;
import com.ebus.booking.entity.Transport;
import com.ebus.booking.entity.User;
import com.ebus.booking.repository.TicketRepository;
import com.ebus.booking.repository.TransportRepository;
import com.ebus.booking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class BookingServicImpl implements BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServicImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    TicketRepository ticketRepository;

    double foodTotalAmount;
    double grandTotal;

    @Override
    public BookingResponseDto bookTicket(BookingRequestDto bookingRequestDtos) throws BookingException {

        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();

        if (null != bookingRequestDtos) {

            User user = new User();
            Ticket ticket = new Ticket();
            foodTotalAmount = 0;grandTotal=0;

            user.setUserId(bookingRequestDtos.getUserId());
            user.setUserName(bookingRequestDtos.getUserName());
            user.setAddress(bookingRequestDtos.getAddress());
            user.setEmail(bookingRequestDtos.getEmail());
            user.setAge(bookingRequestDtos.getAge());
            user.setMobileNumber(bookingRequestDtos.getMobileNumber());
            userRepository.save(user);

            bookingRequestDtos.getTicketRequestDtoList().forEach(ticketInfo -> {

                double finalFarePerTicket = calculateAmount(bookingRequestDtos, ticketInfo);
                TicketResponseDto ticketResponseDto = new TicketResponseDto();
                ticketResponseDto.setAmount(finalFarePerTicket);
                ticketResponseDto.setTicketId(generateRandomTicketId());
                ticketResponseDto.setAge(ticketInfo.getAge());
                ticketResponseDto.setSeatNo(ticketInfo.getSeatNo());
                ticketResponseDto.setTypeOfTicket(ticketInfo.getTypeOfTicket());
                ticketResponseDtoList.add(ticketResponseDto);

                ticket.setTicketId(ticketResponseDto.getTicketId());
                ticket.setAge(ticketInfo.getAge());
                ticket.setAmount(finalFarePerTicket);
                ticket.setTypeOfTicket(ticketInfo.getTypeOfTicket());
                ticket.setFood(ticketInfo.getFood());
                ticket.setSeatNo(ticketInfo.getSeatNo());
                ticket.setSource(bookingRequestDtos.getSource());
                ticket.setDestination(bookingRequestDtos.getDestination());
                ticket.setDateOfJourney(ticketInfo.getDateOfJourney());
                ticket.setStatus("Booked");
                ticket.setUserId(bookingRequestDtos.getUserId());
                ticketRepository.save(ticket);

            });

            bookingResponseDto.setTicketResponseDtoList(ticketResponseDtoList);
            bookingResponseDto.setTotalAmount(grandTotal);
            bookingResponseDto.setFoodTotalAmount(foodTotalAmount);
            bookingResponseDto.setUserName(bookingRequestDtos.getUserName());
            bookingResponseDto.setAmount(grandTotal-foodTotalAmount);
            bookingResponseDto.setStatus("Booked");

            LOGGER.info("Successfully booked {} {} {}",grandTotal,foodTotalAmount,bookingRequestDtos.getUserName());
        } else {
            throw new BookingException("User not available");
        }
        return bookingResponseDto;
    }

    public double calculateAmount(BookingRequestDto bookingRequestDto, TicketRequestDto ticket) {

        Optional<Transport> transport = transportRepository.findPrice(bookingRequestDto.getSource(), bookingRequestDto.getDestination());
        double basicFare = (ticket.getTypeOfTicket().equalsIgnoreCase("n")) ? transport.get().getPrice_n() : transport.get().getPrice_v();
        double ageBasedFare = (ticket.getAge() < 5 || ticket.getAge() > 60) ? basicFare / 2 : basicFare;
        double finalFare = (ticket.getFood().equalsIgnoreCase("Yes")) ? ageBasedFare + 50 : ageBasedFare;
        foodTotalAmount += (ticket.getFood().equalsIgnoreCase("Yes")) ? 50 : 0;
        grandTotal += finalFare;
        return finalFare;
    }

    public static String generateRandomTicketId() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = 6;
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    
    public TicketStatusResponseDto cancelTicket(String ticketid,Integer userId) {
    	
		if(ticketid==null) {
			ticketRepository.cancelTicketByUserId(userId);
		}
		else {
			ticketRepository.cancelTicketByTicketId(ticketid);
		}
		TicketStatusResponseDto ticketStatusResponseDto = new TicketStatusResponseDto();
				ticketStatusResponseDto.setTicketStatus("Successfully canceled");
		return ticketStatusResponseDto;
	}
    
    
}
