package com.java8.programs.interview.GS;

import java.util.Arrays;

public class MeanMedianCalculator {
    public static double calculateMean(int[] arr) {
        return Arrays.stream(arr).average().orElse(Double.NaN);
    }

    public static double calculateMedian(int[] arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int n = sorted.length;

        if (n % 2 == 1) {
            return sorted[n / 2];
        } else {
            return (sorted[(n - 1) / 2] + sorted[n / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 4, 5, 2, 6};

        double mean = calculateMean(arr);
        double median = calculateMedian(arr);

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
    }
}
