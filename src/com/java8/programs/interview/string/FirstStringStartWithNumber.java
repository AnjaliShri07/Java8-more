package com.java8.programs.interview.string;

import java.util.*;
import java.util.regex.Pattern;

public class FirstStringStartWithNumber {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "1st place", "42 is the answer", "cherry");

        // Find the first string that starts with a number
        Optional<String> firstStringWithNumber = strings.stream()
                .filter(s -> Pattern.matches("^[0-9].*", s))
                .findFirst();

        // Print the result
        if (firstStringWithNumber.isPresent()) {
            System.out.println("The first string that starts with a number is: " + firstStringWithNumber.get());
        } else {
            System.out.println("No string starts with a number.");
        }
    }
}
