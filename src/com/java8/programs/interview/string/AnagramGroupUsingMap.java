package com.java8.programs.interview.string;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGroupUsingMap {
    public static void main(String[] args) {
        // Example input
        String[] input = {"bat", "tab", "eat", "tea", "tan", "ate", "nat", "bat"};

        // Group anagrams using streams
        Map<String, List<String>> anagramGroups = Arrays.stream(input)
                .collect(Collectors.groupingBy(
                        str -> {
                            // Sort the characters of the string and return as key
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ));

        // Print the result
        anagramGroups.values().forEach(System.out::println);
    }
}
