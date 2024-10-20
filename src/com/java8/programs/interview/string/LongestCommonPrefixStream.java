package com.java8.programs.interview.string;

import java.util.Arrays;

public class LongestCommonPrefixStream {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";  // No strings in the array, return empty string
        }

        // Use Arrays.stream() to reduce the array of strings to the longest common prefix
        return Arrays.stream(strs)
                // Reduce the array of strings to find the common prefix
                .reduce((prefix, current) -> {
                    // Gradually shorten the prefix until it matches the start of 'current'
                    while (current.indexOf(prefix) != 0) {
                        // Remove the last character from the prefix
                        prefix = prefix.substring(0, prefix.length() - 1);

                        // If the prefix becomes empty, return ""
                        if (prefix.isEmpty()) {
                            return "";
                        }
                    }
                    return prefix;  // Return the updated prefix
                })
                // If the array is empty, return an empty string
                .orElse("");
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));  // Output: "fl"
    }
}
