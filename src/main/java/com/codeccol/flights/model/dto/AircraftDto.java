package com.codeccol.flights.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AircraftDto {
    private String iataCode;
    private String icaoCode;
    private String regNumber;

    public AircraftDto() {
    }
}