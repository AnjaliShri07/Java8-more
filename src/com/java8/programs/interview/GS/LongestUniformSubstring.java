package com.java8.programs.interview.GS;

import java.util.*;

/**
 * for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */
public class LongestUniformSubstring {
    // Method to find the longest uniform substring
    static int[] longestUniformSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return new int[]{-1, 0}; // No substring, return -1, 0
        }

        // Initialize variables to track the longest uniform substring
        int maxLength = 0;
        int maxStartIndex = -1;
        int currentLength = 1;
        int currentStartIndex = 0;

        // Iterate through the string and compare adjacent characters
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                // Same character, increase the length of current uniform substring
                currentLength++;
            } else {
                // Different character, check if the previous substring was the longest
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStartIndex = currentStartIndex;
                }
                // Reset for the new substring
                currentStartIndex = i;
                currentLength = 1;
            }
        }

        // Check the last substring
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStartIndex = currentStartIndex;
        }

        // Return the starting index and length of the longest uniform substring
        return new int[]{maxStartIndex, maxLength};
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(Arrays.toString(longestUniformSubstring("abbbccda"))); // Should return [1, 3]
        System.out.println(Arrays.toString(longestUniformSubstring("aabbbbbCdAA"))); // Should return [2, 5]
        System.out.println(Arrays.toString(longestUniformSubstring(""))); // Should return [-1, 0]
    }
}
