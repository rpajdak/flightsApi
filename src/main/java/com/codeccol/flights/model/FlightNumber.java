package com.codeccol.flights.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="flight_number")
public class FlightNumber {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "iata_number")
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
}
