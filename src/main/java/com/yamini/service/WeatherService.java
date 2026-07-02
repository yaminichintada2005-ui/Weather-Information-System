package com.yamini.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yamini.model.Weather;

public class WeatherService {

    public Weather getWeather(double latitude, double longitude) throws Exception {

        // Build Weather API URL dynamically
        String url = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + latitude
                + "&longitude=" + longitude
                + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send Request
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Convert JSON to Java Object
        ObjectMapper objectMapper = new ObjectMapper();

        Weather weather = objectMapper.readValue(response.body(), Weather.class);

        return weather;
    }
}