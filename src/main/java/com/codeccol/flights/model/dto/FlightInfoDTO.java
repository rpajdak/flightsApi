package com.codeccol.flights.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FlightInfoDTO {

    AircraftDto aircraft;
    AirlineDto airline;
    AirportDto arrival;
    AirportDto departure;
    FlightNumberDto flight;

}
