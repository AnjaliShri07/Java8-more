package com.java8.programs.interview.array;
import java.util.*;

public class FirstRepeatedNumber {
    public static void main(String[] args) {
        int[] numbersArray = {1, 2, 3, 1, 2, 4, 3, 5};

        // Step 1: Create a map to count occurrences
        Map<Integer, Long> countMap = new HashMap<>();

        // Step 2: Stream through the array to find the first repeated number
        Optional<Integer> firstRepeated = Arrays.stream(numbersArray)
                .boxed()
                .filter(n -> {
                    countMap.put(n, countMap.getOrDefault(n, 0L) + 1);
                    return countMap.get(n) > 1;
                })
                .findFirst();

        // Print the result
        firstRepeated.ifPresentOrElse(
                number -> System.out.println("First repeated number: " + number),
                () -> System.out.println("No repeated number found"));

        //********* Using Set *****************

        /* int[] numbersArray = {1, 2, 3, 1, 2, 4, 3, 5};

        // Step 1: Use a HashSet to keep track of seen numbers
        Set<Integer> seen = new HashSet<>();

        // Step 2: Stream through the array to find the first repeated number
        Optional<Integer> firstRepeated = Arrays.stream(numbersArray)
                .boxed()
                .filter(n -> !seen.add(n))
                .findFirst();

        // Print the result
        firstRepeated.ifPresentOrElse(
                number -> System.out.println("First repeated number: " + number),
                () -> System.out.println("No repeated number found"));*/
    }
}

/*
Explanation:
Array Initialization: An array of integers numbersArray is initialized with some values.
Counting Occurrences:
A HashMap named countMap is created to keep track of the occurrences of each number.
Streaming and Filtering:
        Arrays.stream(numbersArray) creates a stream from the array.
        .boxed() converts the IntStream to a Stream<Integer>.
        .filter(n -> { ... }) processes each number:
        countMap.put(n, countMap.getOrDefault(n, 0L) + 1) increments the count of the number in the map.
return countMap.get(n) > 1 checks if the count of the number is greater than 1 (i.e., it's repeated).
        .findFirst() finds the first element in the stream that matches the filter criteria.
Printing the Result:
        firstRepeated.ifPresentOrElse(...) checks if an element is present, printing it if so, or printing a message if not.
This code efficiently finds and prints the first repeated number from the given array.*/
