package com.codeccol.flights.controller;

import com.codeccol.flights.model.dto.FlightInfoDTO;
import com.codeccol.flights.service.FlightNumberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/flights")
public class FlightNumberController {

    FlightNumberService flightNumberService;

    public FlightNumberController(FlightNumberService flightNumberService) {
        this.flightNumberService = flightNumberService;
    }

    @GetMapping(value = "/airport/arrival/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightInfoDTO[] getArrivalFlightByCity(@PathVariable String city) throws IOException {
TO
        return flightNumberService.getArrivalFlightByCity(city);
    }


}
