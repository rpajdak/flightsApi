package com.codeccol.flights.service;

import com.codeccol.flights.model.dto.FlightInfoDTO;
import com.codeccol.flights.model.FlightNumber;
import com.codeccol.flights.repository.FlightRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class FlightNumberService {

    FlightRepository flightRepository;
//        URL url = new URL("https://aviation-edge.com/v2/public/flights?key=ae64ea-f17efc&limit=30000&aircraftIcao=a388");

    public FlightNumberService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public FlightInfoDTO[] getArrivalFlightByCity(String city) throws IOException {
        StringBuilder responseAsString = getResponseAsString(city);

        FlightInfoDTO[] flights = transformStringIntoFlightInfoDto(responseAsString);

        tryToSaveFlights(flights);
        
        return flights;
    }

    private void tryToSaveFlights(FlightInfoDTO[] flights) {
        for (FlightInfoDTO flight : flights) {
            FlightNumber flightNumber = new FlightNumber(flight.getFlight().getIataNumber(),
                    flight.getFlight().getIcaoNumber(),
                    flight.getFlight().getNumber());
            if (!flightRepository.getFlightNumberByIataAndIcao(flightNumber.getIataNumber(), flightNumber.getIcaoNumber()).isPresent()) {
                flightRepository.save(flightNumber);
            }
        }

    }

    private StringBuilder getResponseAsString(String city) throws IOException {
        StringBuilder inline = new StringBuilder();
        String apiUrl = String.format("https://aviation-edge.com/v2/public/flights?key=ae64ea-f17efc&limit=30000&arrIata=%s", city);
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();
        }
        return inline;
    }

    private FlightInfoDTO[] transformStringIntoFlightInfoDto(StringBuilder response) {
        Gson gson = new Gson();
        return gson.fromJson(response.toString(), FlightInfoDTO[].class);
    }


    private boolean checkIfFlightIsDataBase(FlightInfoDTO FlightInfoDTO) {
        String icaoNumber = FlightInfoDTO.getFlight().getIcaoNumber();
        String iataNumber = FlightInfoDTO.getFlight().getIataNumber();

        return flightRepository.getFlightNumberByIataAndIcao(iataNumber, icaoNumber).isEmpty();
    }

    private void saveFlight(FlightNumber FlightNumber) {
        flightRepository.save(FlightNumber);
    }
}
