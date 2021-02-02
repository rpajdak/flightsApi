package com.codeccol.flights.model.dto;

import lombok.Getter;

@Getter
public class AircraftDto {
    private String iataCode;
    private String icaoCode;
    private String regNumber;

    public AircraftDto() {
    }
}