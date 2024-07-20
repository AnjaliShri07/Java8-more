package com.java8.programs.interview.realsenario;

import java.util.*;

public class MaximumEarningJava7 {
    public static void main(String[] args) {
        List<Long> pickup = List.of(0L, 2L, 9L, 10L, 11L, 19L);
        List<Long> drop = List.of(5L, 9L, 11L, 11L, 14L, 17L);
        List<Long> tip = List.of(1L, 2L, 3L, 2L, 2L, 1L);

        long maxEarning = findMaxEarning(pickup, drop, tip);
        System.out.println("Maximum Earning: " + maxEarning);
    }

    public static long findMaxEarning(List<Long> pickup, List<Long> drop, List<Long> tip) {
        int n = pickup.size();

        // Calculate earnings for each trip
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long earning = drop.get(i) - pickup.get(i) + tip.get(i);
            trips.add(new Trip(pickup.get(i), drop.get(i), earning));
        }

        // Sort trips by end time (drop time)
        Collections.sort(trips, Comparator.comparingLong(trip -> trip.drop));

        // Initialize DP array
        long[] dp = new long[n];
        dp[0] = trips.get(0).earning;

        for (int i = 1; i < n; i++) {
            // Earnings if we include the current trip
            long includeEarnings = trips.get(i).earning;

            // Find the latest trip that doesn't overlap with the current trip
            for (int j = i - 1; j >= 0; j--) {
                if (trips.get(j).drop <= trips.get(i).pickup) {
                    includeEarnings += dp[j];
                    break;
                }
            }

            // Maximum earnings by including or excluding the current trip
            dp[i] = Math.max(dp[i - 1], includeEarnings);
        }

        // The maximum earnings will be in the last element of dp array
        return dp[n - 1];
    }

    static class Trip {
        long pickup;
        long drop;
        long earning;

        Trip(long pickup, long drop, long earning) {
            this.pickup = pickup;
            this.drop = drop;
            this.earning = earning;
        }
    }
}
