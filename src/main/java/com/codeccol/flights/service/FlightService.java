package com.codeccol.flights.service;

import com.codeccol.flights.converter.FlightConverter;
import com.codeccol.flights.exceptions.BadRequestException;
import com.codeccol.flights.model.*;
import com.codeccol.flights.model.dto.FlightDto;
import com.codeccol.flights.repository.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    FlightRepository flightRepository;
    AircraftRepository aircraftRepository;
    AirlineRepository airlineRepository;
    AirportRepository airportRepository;
    FlightNumberRepository flightNumberRepository;
    AviationEdgeClient aviationEdgeClient;

    public FlightService(FlightRepository flightRepository,
                         AircraftRepository aircraftRepository,
                         AirlineRepository airlineRepository,
                         AirportRepository airportRepository,
                         FlightNumberRepository flightNumberRepository,
                         AviationEdgeClient aviationEdgeClient) {
        this.flightRepository = flightRepository;
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
        this.flightNumberRepository = flightNumberRepository;
        this.aviationEdgeClient = aviationEdgeClient;
    }

    public List<FlightDto> getCurrentFlightsByType(String type) {
        List<FlightDto> currentFlights = getFlightDtos(type);
        if (currentFlights != null) return currentFlights;
        return null;
    }

    public List<FlightDto> getAllCurrentA380Flights() {
        String type = "a388";
        List<FlightDto> flightDs = new ArrayList<>();
        List<FlightDto> currentFlights = getFlightDtos(type);
        if (currentFlights != null) return currentFlights;
        return flightDs;
    }

    private List<FlightDto> getFlightDtos(String type) {
        try {
            List<Flight> currentFlights = removeFlightsWithNullAirports(retrieveFlightsFromJson(aviationEdgeClient.getAllCurrentByType(type)));
            for (Flight currentFlight : currentFlights) {
                tryToAddFlight(currentFlight);
            }
            return FlightConverter.entityToDto(currentFlights);
        } catch (BadRequestException e) {
            e.printStackTrace();
        }
        return null;
    }


    private List<Flight> removeFlightsWithNullAirports(Flight[] flightsFromApi) {
        return Arrays.stream(flightsFromApi)
                .filter(f -> !f.getArrival().getIcaoCode().equals(""))
                .filter(f -> !f.getDeparture().getIcaoCode().equals(""))
                .collect(Collectors.toList());
    }

    private Flight[] retrieveFlightsFromJson(String response) {
        Gson gson = new Gson();
        return gson.fromJson(response, Flight[].class);
    }


    public List<FlightDto> getAllA380Flights() {
        return FlightConverter.entityToDto(flightRepository.getAllA380Flights());
    }


    private void tryToAddFlight(Flight flight) {
        flight.setDate(LocalDate.now());
        Aircraft aircraft = flight.getAircraft();
        Airline airline = flight.getAirline();
        Airport depAirport = flight.getDeparture();
        Airport arrAirport = flight.getArrival();
        FlightNumber flightNumber = flight.getFlight();

        if (aircraftRepository.getAircraftByRegNumber(aircraft.getRegNumber()).isEmpty()) {
            aircraftRepository.save(aircraft);
        } else {
            flight.setAircraft(aircraftRepository.getAircraftByRegNumber(aircraft.getRegNumber()).get());
        }

        if (airlineRepository.getAirlineByIataCode(airline.getIataCode()).isEmpty()) {
            airlineRepository.save(airline);
        } else {
            flight.setAirline(airlineRepository.getAirlineByIataCode(airline.getIataCode()).get());
        }

        if (airportRepository.getAirportByIataCode(depAirport.getIataCode()).isEmpty()) {
            airportRepository.save(depAirport);
        } else {
            flight.setDeparture(airportRepository.getAirportByIataCode(depAirport.getIataCode()).get());
        }

        if (airportRepository.getAirportByIataCode(arrAirport.getIataCode()).isEmpty()) {
            airportRepository.save(arrAirport);
        } else {
            flight.setArrival(airportRepository.getAirportByIataCode(arrAirport.getIataCode()).get());
        }

        if (flightNumberRepository.getFlightNumberByIataAndIcao(flightNumber.getIataNumber(), flightNumber.getIcaoNumber()).isEmpty()) {
            flightNumberRepository.save(flightNumber);
        } else {
            flight.setFlight(flightNumberRepository.getFlightNumberByIataAndIcao(flightNumber.getIataNumber(), flightNumber.getIcaoNumber()).get());
        }

        if (flightRepository.getFlightByDateAndIcaoFlightNumber(flight.getFlight().getIcaoNumber(), flight.getDate()).isEmpty()) {
            flightRepository.save(flight);
        }
    }
}
