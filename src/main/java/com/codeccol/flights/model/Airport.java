package com.codeccol.flights.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "airports")
public class Airport {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "icao_code")
    private String icaoCode;


    public Airport() {
    }
}
