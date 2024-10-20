package com.java8.programs.interview.string;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//coding find the occurance of character in string and modify string such that least occurring no should come first
//"stringofrepeatedcharacters"
public class CharacterFrequencySorter {
    public static void main(String[] args) {
        String input = "stringofrepeatedcharacters";

        // Step 1: Count occurrences of each character
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Sort characters by their frequency
        String sortedString = input.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.comparingLong(frequencyMap::get))
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Output the result
        System.out.println("Sorted String by frequency: " + sortedString);
    }
}
