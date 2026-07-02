package com.yamini.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yamini.model.Location;
import com.yamini.model.LocationResponse;

public class GeoCodingService {

    public Location getLocation(String city) throws Exception {

        // Convert city name into URL-safe format
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);

        // Create Geocoding API URL
        String url = "https://geocoding-api.open-meteo.com/v1/search?name="
                + encodedCity
                + "&count=1";

        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send Request
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Convert JSON into Java Object
        ObjectMapper objectMapper = new ObjectMapper();

        LocationResponse locationResponse =
                objectMapper.readValue(response.body(), LocationResponse.class);

        // Check whether city is found
        if (locationResponse.getResults() == null
                || locationResponse.getResults().isEmpty()) {

            return null;
        }

        // Return the first matching location
        return locationResponse.getResults().get(0);
    }
}