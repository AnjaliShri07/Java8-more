package com.java8.programs.interview.GS;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

//Longest sub-array having sum k. Given an array arr[] of size n containing integers find the length of the
// longest sub-array having sum equal to the given value k.
public class LongestSubarraySumK {

    public static int longestSubArrayWithKStream(int[] arr, int k){
        Map<Integer, Integer> prefixSumIndex = new HashMap<>();
        final int[] sum = {0};
        final int[] maxLength = {0};

        IntStream.range(0, arr.length).forEach(i -> {
            sum[0] += arr[i];

            if (sum[0] == k) {
                maxLength[0] = i + 1;
            }

            if (prefixSumIndex.containsKey(sum[0] - k)) {
                maxLength[0] = Math.max(maxLength[0], i - prefixSumIndex.get(sum[0] - k));
            }

            prefixSumIndex.putIfAbsent(sum[0], i);
        });

        return maxLength[0];
    }

    // Function to find the length of the longest sub-array with sum = k
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int current_sum = 0;
        int max_len = 0;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the running sum
            current_sum += arr[i];

            // Check if the running sum is equal to k
            if (current_sum == k) {
                max_len = i + 1;  // The entire array from 0 to i has sum = k
            }

            // If (current_sum - k) is already in the map, update max_len
            if (map.containsKey(current_sum - k)) {
                int previous_index = map.get(current_sum - k);
                max_len = Math.max(max_len, i - previous_index);
            }

            // Store the first occurrence of the current_sum
            if (!map.containsKey(current_sum)) {
                map.put(current_sum, i);
            }
        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 9;

        // Find the length of the longest subarray with sum = k
        int result = longestSubarrayWithSumK(arr, k);

        System.out.println("Length of the longest subarray with sum " + k + " is: " + result);
    }
}
