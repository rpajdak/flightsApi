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
@Table(name = "airline")
public class Airline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "iata_code", unique = true)
    private String iataCode;
    @Column(name = "icao_code")
    private String icaoCode;

    public Airline() {

    }

    public Airline(Long id, String iataCode, String icaoCode) {
        this.id = id;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
    }

    public Airline(String iataCode, String icaoCode) {
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
    }
}


