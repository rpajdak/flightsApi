package com.codeccol.flights.converter;

import com.codeccol.flights.model.Flight;
import com.codeccol.flights.model.dto.AircraftDto;
import com.codeccol.flights.model.dto.FlightDto;

import java.util.ArrayList;
import java.util.List;

public class FlightConverter {


    public static List<FlightDto> entityToDto(List<Flight> flights) {
        List<FlightDto> flightsDto = new ArrayList<>();
        for (Flight flight : flights) {
            AircraftDto aircraftDto = new AircraftDto(flight.getAircraft().getIataCode(),
                    flight.getAircraft().getIcaoCode(),
                    flight.getAircraft().getRegNumber());
            FlightDto flightDto = FlightDto
                    .builder()
                    .aircraft(aircraftDto)
                    .airline(flight.getAirline().getIcaoCode())
                    .departure(flight.getDeparture().getIataCode())
                    .arrival(flight.getArrival().getIataCode())
                    .flightNumber(flight.getFlight().getNumber())
                    .build();
            flightsDto.add(flightDto);
        }

        return flightsDto;
    }
}
