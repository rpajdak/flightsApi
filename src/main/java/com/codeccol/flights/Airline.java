package com.codeccol.flights;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "airline")
@NoArgsConstructor

public class Airline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "icao_code")
    private String icaoCode;
}
