package com.codeccol.flights.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class FlightDto {

    AircraftDto aircraft;
    String airline;
    String departure;
    String arrival;
    String flightNumber;
    Date flightDate;

}
