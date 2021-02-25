package com.ebus.booking.repository;

import com.ebus.booking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, String> {
}
