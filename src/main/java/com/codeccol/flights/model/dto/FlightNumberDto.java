package com.codeccol.flights.model.dto;

import lombok.Getter;

@Getter
public class FlightNumberDto {

    private String iataNumber;
    private String icaoNumber;
    private String number;



    public FlightNumberDto() {
    }
}
