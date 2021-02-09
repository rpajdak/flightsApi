package com.codeccol.flights.repository;

import com.codeccol.flights.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Optional<Airline> getAirlineByIataCode(String iataCode);
}
