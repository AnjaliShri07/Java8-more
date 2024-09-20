package com.java8.programs.interview.collections;

import java.util.*;

/*"Chennai" -> "Bangalore"
        "Bombay" -> "Delhi"
        "Goa"    -> "Chennai"
        "Delhi"  -> "Goa"*/

public class FindRoutes {
    // Find the starting point of the route
    public static String findStartPoint(Map<String, String> cityPairs) {
        // Reverse the map to find the end points
        Map<String, String> reversedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : cityPairs.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }

        // Find the start point (a city not present in the reversed map)
        for (String city : cityPairs.keySet()) {
            if (!reversedMap.containsKey(city)) {
                return city;
            }
        }
        return null;
    }

    // Find the end point starting from the start point
    public static String findEndPoint(Map<String, String> cityPairs, String startPoint) {
        String currentCity = startPoint;
        while (cityPairs.containsKey(currentCity)) {
            currentCity = cityPairs.get(currentCity);
        }
        return currentCity;
    }
    public static void main(String[] args) {
// Define the city pairs
        Map<String, String> cityPairs = new HashMap<>();
        cityPairs.put("Chennai", "Bangalore");
        cityPairs.put("Bombay", "Delhi");
        cityPairs.put("Goa", "Chennai");
        cityPairs.put("Delhi", "Goa");

        // Find the start and end points
        String startPoint = findStartPoint(cityPairs);
        String endPoint = findEndPoint(cityPairs, startPoint);

        System.out.println("Start Point: " + startPoint);
        System.out.println("End Point: " + endPoint);
    }
}
