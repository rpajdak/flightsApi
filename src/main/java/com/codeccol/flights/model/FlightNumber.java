package com.codeccol.flights.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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


    public FlightNumber(long id, String iataNumber, String icaoNumber, String number) {
        this.id = id;
        this.iataNumber = iataNumber;
        this.icaoNumber = icaoNumber;
        this.number = number;
    }

    public FlightNumber() {
    }
}
