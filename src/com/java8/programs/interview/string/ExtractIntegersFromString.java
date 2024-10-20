package com.java8.programs.interview.string;

import java.util.*;
import java.util.stream.*;

public class ExtractIntegersFromString {
    public static List<Integer> extractIntegers(String str) {
        // Split the string into an array of substrings where digits are grouped together
        String[] digitGroups = str.split("[^0-9]+");

        // Use a stream to filter out empty strings and parse the remaining strings as integers
        return Stream.of(digitGroups)
                .filter(s -> !s.isEmpty())  // Filter out empty strings
                .map(Integer::parseInt)     // Convert to integers
                .collect(Collectors.toList()); // Collect the integers into a list
    }
    public static void main(String[] args) {
        String str = "avbkjd1122klj4 543 af";  // Example input string

        List<Integer> integers = extractIntegers(str);

        System.out.println("Extracted integers: " + integers);
    }
}
