package com.java8.programs.interview.realsenario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // Priority queue to store event end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 1;
        int i = 0;
        int attended = 0;
        int n = events.length;

        // Find the last day any event ends
        int lastDay = Arrays.stream(events).mapToInt(e -> e[1]).max().orElse(0);

        // Iterate day by day
        while (day <= lastDay) {
            // Add all events that start today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            day++;
        }

        return attended;
    }

    public static void main(String[] args) {
        int[][] events1 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maxEvents(events1)); // Output: 3

        int[][] events2 = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(maxEvents(events2)); // Output: 4
    }
}
