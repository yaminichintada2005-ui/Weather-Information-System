package com.yamini;

import java.util.Scanner;

import com.yamini.model.Location;
import com.yamini.model.Weather;
import com.yamini.service.GeoCodingService;
import com.yamini.service.WeatherService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GeoCodingService geoCodingService = new GeoCodingService();
        WeatherService weatherService = new WeatherService();

        try {

            System.out.println("=======================================");
            System.out.println("      WEATHER INFORMATION SYSTEM");
            System.out.println("=======================================");

            System.out.print("Enter City Name: ");
            String city = scanner.nextLine();

            // Get Location Details
            Location location = geoCodingService.getLocation(city);

            System.out.println("\nCity Found!");
            System.out.println("City      : " + location.getName());
            System.out.println("Country   : " + location.getCountry());
            System.out.println("Latitude  : " + location.getLatitude());
            System.out.println("Longitude : " + location.getLongitude());

            // Get Weather Details
            Weather weather = weatherService.getWeather(
                    location.getLatitude(),
                    location.getLongitude());

            System.out.println("\n=======================================");
            System.out.println("          WEATHER REPORT");
            System.out.println("=======================================");

            System.out.println("Temperature : "
                    + weather.getCurrent().getTemperature2m() + " °C");

            System.out.println("Humidity    : "
                    + weather.getCurrent().getRelativeHumidity2m() + " %");

            System.out.println("Wind Speed  : "
                    + weather.getCurrent().getWindSpeed10m() + " km/h");

            System.out.println("=======================================");

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        } finally {

            scanner.close();

        }
    }
}