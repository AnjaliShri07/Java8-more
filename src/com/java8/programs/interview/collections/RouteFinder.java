package com.java8.programs.interview.collections;

import java.util.*;

public class RouteFinder {
    private Map<String, String> routes;

    public RouteFinder() {
        routes = new HashMap<>();
        routes.put("Chennai", "Bangalore");
        routes.put("Bombay", "Delhi");
        routes.put("Goa", "Chennai");
        routes.put("Delhi", "Goa");
    }

    public String findRoute(String start, String end) {
        String current = start;
        StringBuilder route = new StringBuilder(start);

        while (!current.equals(end)) {
            String next = routes.get(current);
            if (next == null) {
                return "No route found";
            }
            route.append(" -> ").append(next);
            current = next;
        }

        return route.toString();
    }

    public static void main(String[] args) {
        RouteFinder routeFinder = new RouteFinder();
        System.out.println(routeFinder.findRoute("Bombay", "Goa"));
        System.out.println(routeFinder.findRoute("Goa", "Bangalore"));
        System.out.println(routeFinder.findRoute("Chennai", "Delhi"));

    }
}
