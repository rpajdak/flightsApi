package com.codeccol.flights.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "flight_number")
public class FlightNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "iata_number", unique = true)
    private String iataNumber;

    @Column(name = "icao_number")
    private String icaoNumber;

    @Column(name = "flight_number")
    private String number;


    public FlightNumber(String iataNumber, String icaoNumber, String number) {
        this.iataNumber = iataNumber;
        this.icaoNumber = icaoNumber;
        this.number = number;
    }

    public FlightNumber() {
    }
}
