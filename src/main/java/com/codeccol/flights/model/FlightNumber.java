package com.codeccol.flights.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "flightNumbers")
public class FlightNumber {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "iataNumber")
    private String iataNumber;
    @Column(name = "icaonumber")
    private String icaoNumber;
    @Column(name = "number")
    private int number;

    public FlightNumber() {
    }

}
