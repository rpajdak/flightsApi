package com.codeccol.flights.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "aircraft")
public class Aircraft {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "icao_code")
    private String icaoCode;
    @Column(name = "reg_number", unique = true)
    private String regNumber;

    public Aircraft() {

    }

    public Aircraft(String iataCode, String icaoCode, String regNumber) {
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.regNumber = regNumber;
    }
}
