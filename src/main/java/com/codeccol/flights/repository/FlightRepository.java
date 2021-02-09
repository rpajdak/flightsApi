package com.codeccol.flights.repository;

import com.codeccol.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f.regNumber, a.iataCode from Flight flight JOIN flight.aircraft f JOIN flight.airline a " +
            "WHERE flight.airline.iataCode= :iataCode")
    List<String> getFlightByRegistration(String iataCode);

    @Query("SELECT flight FROM Flight flight JOIN flight.aircraft aircraft WHERE flight.aircraft.iataCode = 'A388'")
    List<Flight> getAllA380Flights();

}
