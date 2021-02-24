package com.ebus.booking.repository;

import com.ebus.booking.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransportRepository extends JpaRepository<Transport,Integer> {

    @Query("select t from Transport t where t.source = :source and t.destination = :destination")
    Optional<Transport> findPrice(String source, String destination);
}
