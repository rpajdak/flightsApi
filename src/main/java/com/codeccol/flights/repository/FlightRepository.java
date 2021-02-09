package com.codeccol.flights.repository;

import com.codeccol.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT flight from Flight flight JOIN flight.aircraft f JOIN flight.airline a " +
            "WHERE flight.airline.iataCode= :iataCode")
    List<Flight> getFlightByAirline(String iataCode);

    @Query("SELECT flight FROM Flight flight JOIN flight.aircraft aircraft WHERE aircraft.iataCode = 'A388'")
    List<Flight> getAllA380Flights();

    @Query("SELECT flight FROM Flight flight JOIN flight.flight flightumber WHERE flightumber.icaoNumber = :icaoNumber and flight.date= :date")
    Optional<Flight> getFlightByDateAndIcaoFlightNumber(String icaoNumber, LocalDate date);


}
