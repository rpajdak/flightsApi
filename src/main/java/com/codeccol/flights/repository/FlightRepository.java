package com.codeccol.flights.repository;

import com.codeccol.flights.model.FlightNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<FlightNumber, Long> {
    @Query("SELECT flight " +
            "from FlightNumber flight " +
            "WHERE flight.iataNumber = :iataNumber " +
            "OR flight.icaoNumber= :icaoNumber")
    Optional<FlightNumber> getFlightNumberByIataAndIcao(String iataNumber, String icaoNumber);
}