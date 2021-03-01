package com.ebus.booking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebus.booking.entity.Ticket;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, String> {
	
	@Modifying
	@Query("update Ticket t set t.status ='canceled' where t.userId=?1")
	public void cancelTicketByUserId(Integer userid);
	
	@Modifying
	@Query("update Ticket t set t.status ='canceled' where t.ticketId=?1")
	public void cancelTicketByTicketId(String ticketid);
	
	List<Ticket> findByUserId(int userId);
}
