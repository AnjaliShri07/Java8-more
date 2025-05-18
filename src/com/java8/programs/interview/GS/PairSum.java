package com.java8.programs.interview.GS;

import java.util.HashMap;

public class PairSum {
    // Function to count the number of pairs with a given sum
    public static int countPairsWithSum(int[] nums, int target) {
        // HashMap to store the frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Iterate through the array
        for (int num : nums) {
            // Calculate the complement that would sum up to the target
            int complement = target - num;

            // If the complement exists in the map, it means we found a valid pair
            if (map.containsKey(complement)) {
                count += map.get(complement); // Add the frequency of the complement
            }

            // Update the frequency of the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;

        int result = countPairsWithSum(nums, target);
        System.out.println("Number of pairs with sum " + target + " is: " + result);
    }
}
