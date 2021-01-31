package com.codeccol.flights.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "aircrafts")
public class Aircraft {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "icao_code")
    private String icaoCode;
    @Column(name = "reg_number")
    private String regNumber;

    public Aircraft() {

    }
}
