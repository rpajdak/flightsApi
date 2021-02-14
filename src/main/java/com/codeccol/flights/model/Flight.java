package com.codeccol.flights.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@Entity
@ToString
@Table(name = "flight")
public class Flight {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "date")
    private LocalDate date;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name = "aircraft_id"
    )
    private Aircraft aircraft;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name = "airline_id"
    )
    private Airline airline;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name = "dep_airport_id"
    )
    private Airport departure;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name = "arr_airport_id"
    )
    private Airport arrival;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name = "flight_number_id"
    )
    private FlightNumber flight;


    public Flight(Aircraft aircraft, Airline airline, Airport departure, Airport arrival, FlightNumber flight_number_id) {
        this.aircraft = aircraft;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.flight = flight_number_id;
    }

    public Flight() {
    }
}

