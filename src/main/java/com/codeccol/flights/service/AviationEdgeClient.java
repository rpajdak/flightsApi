package com.codeccol.flights.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AviationEdgeClient {

    private final String AVIATION_EDGE_BASE_URL = "https://aviation-edge.com/v2/public/flights?key=%sc&limit=100%s%s";
    private final String API_KEY = "ae64ea-f17ef";
    private String aircraftEndPoint = "&aircraftIcao=";

    private HttpClient httpClient;

    public AviationEdgeClient() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public String getAllCurrentA380Flights() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format(AVIATION_EDGE_BASE_URL, API_KEY, aircraftEndPoint, "a388")))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
