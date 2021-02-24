package com.ebus.booking.service;

import com.ebus.booking.dto.BookingRequestDto;
import com.ebus.booking.dto.BookingResponseDto;
import com.ebus.booking.dto.TicketRequestDto;
import com.ebus.booking.entity.Ticket;
import com.ebus.booking.entity.Transport;
import com.ebus.booking.entity.User;
import com.ebus.booking.repository.TransportRepository;
import com.ebus.booking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServicImpl implements BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServicImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    @Override
    public BookingResponseDto bookTicket(BookingRequestDto bookingRequestDtos) {

        if (null != bookingRequestDtos) {

            User user = new User();

            user.setUserId(bookingRequestDtos.getUserId());
            user.setUserName(bookingRequestDtos.getUserName());
            user.setAddress(bookingRequestDtos.getAddress());
            user.setEmail(bookingRequestDtos.getEmail());
            user.setAge(bookingRequestDtos.getAge());
            user.setMobileNumber(bookingRequestDtos.getMobileNumber());
            userRepository.save(user);

            bookingRequestDtos.getTicketRequestDtoList().forEach(ticketInfo -> {
                Ticket ticket = new Ticket();
                double totalFare=0.0;
                double finalFarePerTicket = calculateAmount(ticketInfo);
                totalFare+=finalFarePerTicket;
                ticket.setAmount(finalFarePerTicket);
               // ticket.setAge();

            });

        }

        return null;
    }

    public float calculateAmount(TicketRequestDto ticket) {

        Optional<Transport> transport = transportRepository.findPrice(ticket.getSource(), ticket.getDestination());

        float basicFare = (ticket.getTypeOfTicket().equalsIgnoreCase("n")) ? transport.get().getPrice_n() : transport.get().getPrice_v();
        float ageBasedFare = (ticket.getAge() < 5 || ticket.getAge() > 60) ? basicFare / 2 : basicFare;
        float finalFare = (ticket.getFood().equalsIgnoreCase("Y")) ? ageBasedFare + 50 : ageBasedFare;
        return finalFare;

    }
}
