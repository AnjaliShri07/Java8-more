package com.java8.programs.interview.array;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedNumber {
    //not working
    public static Integer firstNonRepeatedNumberUsingSet(int[] numbersArray){

        Set<Integer> seen = new HashSet<>();
        Set<Integer> unique = new LinkedHashSet<>();

        for (int number : numbersArray) {
            if (!seen.add(number))
                unique.remove(number);
            else
                unique.add(number);
        }

        return unique.stream()
                .findFirst()
                .orElse(-1);
    }

    public static Integer firstNonRepeatedNumberUsingMap(int[] numbersArray){
        // Step 1: Convert the array to a stream and create a map to count occurrences
        Map<Integer, Long> countMap = Arrays.stream(numbersArray)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first non-repeated number
         return countMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(0);
    }

    public static void main(String[] args) {
        int[] numbersArray = {1, 2, 3, 1, 2, 4, 3, 5};


        /*// Step 1: Convert the array to a stream and create a map to count occurrences
        Map<Integer, Long> countMap = Arrays.stream(numbersArray)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first non-repeated number
        Optional<Integer> firstNonRepeated = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
*/

                // Print the result
        /*firstNonRepeated.ifPresentOrElse(
                number -> System.out.println("First non-repeated number: " + number),
                () -> System.out.println("No non-repeated number found"));*/

        System.out.println("Using Set : "+firstNonRepeatedNumberUsingSet(numbersArray));
        System.out.println("Using Map : "+firstNonRepeatedNumberUsingMap(numbersArray));
    }
}

/*
Explanation:
Array Initialization: An array of integers numbersArray is initialized with some values.
Counting Occurrences:
        Arrays.stream(numbersArray) creates a stream from the array.
        .boxed() converts the IntStream to a Stream<Integer>.
        Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()) collects the numbers
        into a LinkedHashMap with the numbers as keys and their counts as values.
Finding the First Non-Repeated Number:
        countMap.entrySet().stream() creates a stream of the map entries.
        .filter(entry -> entry.getValue() == 1) filters the entries to keep only those with a count of 1.
        .map(Map.Entry::getKey) maps the entries to their keys (the numbers).
        .findFirst() finds the first element in the stream, if any.
Printing the Result:
        firstNonRepeated.ifPresentOrElse(...) checks if an element is present, printing it if so, or printing
        a message if not.*/
