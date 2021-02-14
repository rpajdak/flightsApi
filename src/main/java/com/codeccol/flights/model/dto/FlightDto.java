package com.codeccol.flights.model.dto;

import lombok.*;

import java.time.LocalDate;

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
    LocalDate flightDate;

}
