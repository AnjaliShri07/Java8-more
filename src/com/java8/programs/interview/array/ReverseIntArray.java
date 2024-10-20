package com.java8.programs.interview.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseIntArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        // Reverse the array using Streams
        int[] reversedArray = Arrays.stream(numbers)
                .boxed() // Convert int to Integer
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                    Collections.reverse(lst);
                    return lst.stream();
                }))
                .mapToInt(Integer::intValue) // Convert Integer back to int
                .toArray();

        int[] reversed = IntStream.range(0, numbers.length)
                .map(i -> numbers[numbers.length - 1 - i])
                .toArray();

        int[] reverseSort = Arrays.stream(numbers)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer :: intValue)
                .toArray();

        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
        System.out.println("Using IntStream : "+ Arrays.toString(reversed));
        System.out.println("Reverse using Sort: "+ Arrays.toString(reverseSort));
    }
}
