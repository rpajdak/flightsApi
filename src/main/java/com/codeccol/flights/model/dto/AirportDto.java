package com.codeccol.flights.model.dto;

import lombok.Getter;

@Getter
public class AirportDto {
    private String iataCode;
    private String icaoCode;


    public AirportDto() {
    }
}
