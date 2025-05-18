package com.java8.programs.interview.GS;

import java.util.Arrays;
import java.util.List;

public class PowerEquality {
    // Function to find pairs such that a^b = b^a
    public static void findPowerPairs(List<Integer> numbers) {
        // Iterate through all pairs (a, b)
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int a = numbers.get(i);
                int b = numbers.get(j);

                // Check if a^b == b^a
                if (Math.pow(a, b) == Math.pow(b, a)) {
                    System.out.println("Pair found: (" + a + ", " + b + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example input
        List<Integer> numbers = Arrays.asList(2, 4, 1, 3, 5);

        // Find pairs where a^b = b^a
        findPowerPairs(numbers);
    }
}
