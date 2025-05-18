package com.java8.programs.interview.GS.TrainMap;

import java.util.*;
import java.util.stream.Collectors;

public class TrainNetwork {
    static class Station {
        private final String name;
        private final List<Edge> neighbours = new ArrayList<>();

        public Station(String name) {
            this.name = name;
        }

        public void addNeighbour(Station station, int travelTime) {
            neighbours.add(new Edge(station, travelTime));
        }

        public List<Edge> getNeighbours() {
            return neighbours;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Station && this.name.equals(((Station) o).name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Edge {
        Station destination;
        int weight;

        public Edge(Station destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class StationDistance {
        Station station;
        int distance;

        public StationDistance(Station station, int distance) {
            this.station = station;
            this.distance = distance;
        }
    }

    // --- Dijkstra's algorithm for weighted shortest path
    public static List<Station> shortestWeightedPath(Station from, Station to, List<Station> allStations) {
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> previous = new HashMap<>();
        PriorityQueue<StationDistance> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(sd -> sd.distance));

        for (Station s : allStations) distances.put(s, Integer.MAX_VALUE);
        distances.put(from, 0);
        minHeap.offer(new StationDistance(from, 0));

        while (!minHeap.isEmpty()) {
            StationDistance current = minHeap.poll();
            for (Edge edge : current.station.getNeighbours()) {
                int newDist = distances.get(current.station) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current.station);
                    minHeap.offer(new StationDistance(edge.destination, newDist));
                }
            }
        }

        List<Station> path = new LinkedList<>();
        for (Station at = to; at != null; at = previous.get(at)) path.add(0, at);
        return path.get(0).equals(from) ? path : Collections.emptyList();
    }

    // --- BFS + DFS for all unweighted shortest paths
    public static List<List<Station>> allShortestPaths(Station start, Station end) {
        Map<Station, List<Station>> parentMap = new HashMap<>();
        Map<Station, Integer> distanceMap = new HashMap<>();
        Queue<Station> queue = new LinkedList<>();

        queue.add(start);
        distanceMap.put(start, 0);

        while (!queue.isEmpty()) {
            Station current = queue.poll();
            int currentDist = distanceMap.get(current);

            for (Edge edge : current.getNeighbours()) {
                Station neighbor = edge.destination;
                int newDist = currentDist + 1;

                if (!distanceMap.containsKey(neighbor)) {
                    distanceMap.put(neighbor, newDist);
                    parentMap.put(neighbor, new ArrayList<>(List.of(current)));
                    queue.add(neighbor);
                } else if (distanceMap.get(neighbor) == newDist) {
                    parentMap.get(neighbor).add(current);
                }
            }
        }

        List<List<Station>> results = new ArrayList<>();
        LinkedList<Station> currentPath = new LinkedList<>();
        buildPaths(end, start, parentMap, currentPath, results);
        return results;
    }

    private static void buildPaths(Station current, Station start,
                                   Map<Station, List<Station>> parentMap,
                                   LinkedList<Station> currentPath,
                                   List<List<Station>> results) {
        currentPath.addFirst(current);
        if (current.equals(start)) {
            results.add(new ArrayList<>(currentPath));
        } else if (parentMap.containsKey(current)) {
            for (Station parent : parentMap.get(current)) {
                buildPaths(parent, start, parentMap, currentPath, results);
            }
        }
        currentPath.removeFirst();
    }

    public static void main(String[] args) {
        // Create station objects
        Station kc = new Station("King's Cross");
        Station angel = new Station("Angel");
        Station oldStreet = new Station("Old Street");
        Station moorgate = new Station("Moorgate");
        Station bank = new Station("Bank");
        Station russell = new Station("Russell Square");
        Station holborn = new Station("Holborn");

        // Build graph
        kc.addNeighbour(angel, 5);
        angel.addNeighbour(kc, 5);
        angel.addNeighbour(oldStreet, 3);
        oldStreet.addNeighbour(angel, 3);
        oldStreet.addNeighbour(moorgate, 4);
        moorgate.addNeighbour(oldStreet, 4);
        moorgate.addNeighbour(bank, 6);
        bank.addNeighbour(moorgate, 6);
        kc.addNeighbour(russell, 4);
        russell.addNeighbour(kc, 4);
        russell.addNeighbour(holborn, 3);
        holborn.addNeighbour(russell, 3);
        holborn.addNeighbour(bank, 7);
        bank.addNeighbour(holborn, 7);

        List<Station> allStations = List.of(kc, angel, oldStreet, moorgate, bank, russell, holborn);

        // --- Shortest weighted path (Dijkstra)
        System.out.println("Shortest Weighted Path (Travel Time):");
        List<Station> shortestTimePath = shortestWeightedPath(kc, bank, allStations);
        System.out.println(shortestTimePath.stream().map(Station::getName).collect(Collectors.joining(" -> ")));

        // --- All shortest unweighted paths (equal hops)
        System.out.println("\nAll Shortest Paths (Unweighted):");
        List<List<Station>> allPaths = allShortestPaths(kc, bank);
        for (List<Station> path : allPaths) {
            System.out.println(path.stream().map(Station::getName).collect(Collectors.joining(" -> ")));
        }
    }
}
