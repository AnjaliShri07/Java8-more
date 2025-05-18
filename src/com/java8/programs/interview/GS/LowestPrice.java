package com.java8.programs.interview.GS;

import java.util.*;

public class LowestPrice {
    // Define the structure to hold the result intervals and the associated lowest price
    static class Interval {
        int startTime;
        int endTime;
        int price;

        Interval(int startTime, int endTime, int price) {
            if (startTime >= endTime) {
                throw new IllegalArgumentException("startTime greater than or equal to endTime for an interval");
            } else if (startTime < 0 || endTime < 0 || price < 0) {
                throw new IllegalArgumentException("vendor information has negative values");
            }
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) o;
            return getStartTime() == interval.getStartTime() &&
                    getEndTime() == interval.getEndTime() &&
                    getPrice() == interval.getPrice();
        }

        @Override
        public int hashCode() {
            int result = getStartTime();
            result = 31 * result + getEndTime();
            result = 31 * result + getPrice();
            return result;
        }
    }

    public static List<Interval> getLowestPrices(List<Interval> deals) {
        if (deals == null || deals.isEmpty()) {
            return new ArrayList<>();
        }

        // Sort the deals based on startTime
        deals.sort(Comparator.comparingInt(a -> a.startTime));

        // The result list of merged intervals with lowest prices
        List<Interval> result = new ArrayList<>();

        // Start with the first deal
        Interval currentInterval = deals.get(0);

        for (int i = 1; i < deals.size(); i++) {
            Interval nextDeal = deals.get(i);

            // If current interval overlaps with the next one, merge them
            if (currentInterval.endTime >= nextDeal.startTime) {
                // Extend the current interval and update the minimum price
                currentInterval.endTime = Math.max(currentInterval.endTime, nextDeal.endTime);
                currentInterval.price = Math.min(currentInterval.price, nextDeal.price);
            } else {
                // No overlap, finalize the current interval and start a new one
                result.add(currentInterval);
                currentInterval = nextDeal;
            }
        }

        // Add the last interval
        result.add(currentInterval);

        return result;
    }

    // A helper method to print the intervals
    private static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.println("Start: " + interval.startTime + ", End: " + interval.endTime + ", Price: " + interval.price);
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Interval> deals = new ArrayList<>();
        deals.add(new Interval(1, 5, 100));
        deals.add(new Interval(3, 8, 90));
        deals.add(new Interval(6, 10, 80));
        deals.add(new Interval(2, 6, 95));

        List<Interval> lowestPrices = getLowestPrices(deals);
        printIntervals(lowestPrices);  // Output will show merged intervals with the lowest prices.
    }
}
