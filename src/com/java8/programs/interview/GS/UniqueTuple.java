package com.java8.programs.interview.GS;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueTuple {

    public static HashSet<String> uniqueTuplesStream(String input, int len) {
        if (input == null || len <= 0 || input.length() < len) {
            return new HashSet<>();
        }

        return IntStream.range(0, input.length() - len + 1)
                .mapToObj(i -> input.substring(i, i + len))
                .collect(Collectors.toCollection(HashSet::new));
    }
    /*IntStream.range(0, input.length() - len + 1):
    Generate a stream of integers from 0 to input.length() - len. This range represents the starting indices of the
    substrings.
    mapToObj(i -> input.substring(i, i + len)):
    For each integer i in the stream, create a substring starting at index i and of length len.
    input.substring(i, i + len) extracts the substring from the input string.*/

    // Returns all unique substrings (tuples) of length 'len' from input
    public static HashSet<String> uniqueTuples(String input, int len) {
        if (input == null || len <= 0 || input.length() < len) {
            return new HashSet<>();
        }

        HashSet<String> result = new HashSet<>();

        for (int i = 0; i <= input.length() - len; i++) {
            String tuple = input.substring(i, i + len);
            result.add(tuple); // Add to set for uniqueness
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "aab";
        HashSet<String> result = uniqueTuples(input, 2);

        if (result.contains("aa") && result.contains("ab") && result.size() == 2) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

        // Optional: print all unique tuples
        System.out.println("Unique tuples of length 2: " + result);

        System.out.println(uniqueTuplesStream(input, 2));
    }
}
