package com.java8.programs.interview.GS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    // Function to convert the input string into the required format
    public static String convertToCharacterCountFormat(String input) {
        // Edge case: if input is empty, return an empty string
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Step 1: Convert the string to a stream of characters
        Map<Character, Long> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 2: Build the output string from the grouped and counted characters
        StringBuilder output = new StringBuilder();
        charCountMap.forEach((character, count) -> output.append(count).append(character));

        return output.toString();
    }

    public static void main(String[] args) {
        String input = "SSSSSTTPPQ";
        String output = convertToCharacterCountFormat(input);
        System.out.println("Output: " + output); // Output should be "5S2T2P1Q"
    }
}
