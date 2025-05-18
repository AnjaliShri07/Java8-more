package com.java8.programs.interview.GS.TrainMap;

import java.util.*;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */
/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */
public class TrainMap {
    private final Map<String, List<String>> stationGraph;

    public TrainMap() {
        stationGraph = new HashMap<>();
    }

    public void addStation(String stationName) {
        stationGraph.putIfAbsent(stationName, new ArrayList<>());
    }

    public void connectStations(String fromStation, String toStation) {
        stationGraph.get(fromStation).add(toStation);
        stationGraph.get(toStation).add(fromStation); // undirected graph
    }

    public List<String> shortestPath(String fromStation, String toStation) {
        if (!stationGraph.containsKey(fromStation) || !stationGraph.containsKey(toStation)) {
            return Collections.emptyList();
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.offer(fromStation);
        visited.add(fromStation);
        parent.put(fromStation, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(toStation)) break;

            for (String neighbor : stationGraph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        // Reconstruct path from 'toStation' to 'fromStation'
        LinkedList<String> path = new LinkedList<>();
        String current = toStation;
        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }

        // If start station isn't at the start of path, no path was found
        return path.getFirst().equals(fromStation) ? path : Collections.emptyList();
    }

    public static void main(String[] args) {
        TrainMap map = new TrainMap();

        // Add stations
        String[] stations = {
                "King's Cross St Pancras", "Angel", "Old Street", "Russell Square",
                "Farringdon", "Barbican", "Moorgate", "Holborn",
                "Chancery Lane", "St Paul's", "Bank"
        };
        for (String station : stations) {
            map.addStation(station);
        }

        // Connect stations
        map.connectStations("King's Cross St Pancras", "Angel");
        map.connectStations("Angel", "Old Street");
        map.connectStations("Old Street", "Moorgate");
        map.connectStations("Moorgate", "Barbican");
        map.connectStations("Barbican", "Farringdon");
        map.connectStations("Farringdon", "King's Cross St Pancras");
        map.connectStations("King's Cross St Pancras", "Russell Square");
        map.connectStations("Russell Square", "Holborn");
        map.connectStations("Holborn", "Chancery Lane");
        map.connectStations("Chancery Lane", "St Paul's");
        map.connectStations("St Paul's", "Bank");
        map.connectStations("Moorgate", "Bank");

        // Test shortest path
        List<String> path = map.shortestPath("Holborn", "Moorgate");
        System.out.println("Shortest path from Holborn to Moorgate ==>");
        path.forEach(System.out::println);
    }
}
/*🔍 HOW THIS WORKS
The graph is built with a Map<String, List<String>>.
addStation adds a station to the map.
connectStations creates a bidirectional connection (undirected).
shortestPath() uses BFS to traverse and track parent links.
Once toStation is found, the path is reconstructed backwards using the parent map.

🧠 COMPLEXITY
Time Complexity:
BFS visits each node and edge once → O(V + E)
Space Complexity:
O(V) for visited, parent map, and queue.*/