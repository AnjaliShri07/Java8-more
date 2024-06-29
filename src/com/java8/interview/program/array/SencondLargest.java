package com.java8.interview.program.array;

import java.util.Arrays;
import java.util.Comparator;

public class SencondLargest {
    public static void main(String[] args) {
        Integer[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int secondlargest = Arrays.stream(numbers)
                .sorted(Comparator.reverseOrder())
                .distinct() // Remove duplicates
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Array must contain at least two distinct elements"));;
        System.out.println("The second largest element is: " +secondlargest);
    }
}
