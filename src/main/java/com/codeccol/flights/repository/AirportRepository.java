package com.codeccol.flights.repository;

import com.codeccol.flights.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a FROM Airport a where a.iataCode= :iataCode")
    Optional<Airport> getAirportByIataCode(String iataCode);
}
