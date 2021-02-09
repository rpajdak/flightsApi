package com.codeccol.flights.controller;

import com.codeccol.flights.model.dto.FlightDto;
import com.codeccol.flights.exceptions.BadAircraftTypeException;
import com.codeccol.flights.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/a380s")
    @ResponseStatus(OK)
    public List<FlightDto> getAllA380Flights() {
        return flightService.getAllA380Flights();
    }

    @GetMapping("/current/a380s")
    @ResponseStatus(OK)
    public List<FlightDto> getAllCurrentA380Flights() {
        return flightService.getAllCurrentA380Flights();
    }


    @ResponseStatus(OK)
    @GetMapping(value = "/type/{type}")
    public List<FlightDto> getFlightsByType(@PathVariable String type) throws BadAircraftTypeException {
        return flightService.getCurrentFlightsByType(type);
    }

    @GetMapping("/test")
    @ResponseStatus(OK)
    public List<FlightDto> test() {
        return flightService.getAllCurrentA380Flights();
    }
}
