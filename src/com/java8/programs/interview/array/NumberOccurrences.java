package com.java8.programs.interview.array;
import java.util.*;
import java.util.stream.*;

public class NumberOccurrences {
    public static void main(String[] args) {
        int[] numbersArray = {1, 2, 3, 1, 2, 4, 3, 5};

        // Create a map to count occurrences of each number
        Map<Integer, Long> occurrencesMap = Arrays.stream(numbersArray)
                .boxed() // Convert int stream to Integer stream
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(occurrencesMap);

        // Print the occurrences map
        occurrencesMap.forEach((number, count) -> System.out.println(number + " occurs " + count + " times"));
    }
}
