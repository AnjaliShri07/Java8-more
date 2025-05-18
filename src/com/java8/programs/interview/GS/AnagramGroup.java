package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGroup {
    public static void setOfAnagrams(String inputString) {
        // Step 1: Split words and stream
        String[] words = inputString.split(" ");

        // Step 2: Group by sorted characters of word (i.e., its anagram key)
        Map<String, List<String>> grouped = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars); // this is the anagram key
                }));

        // Step 3: Print the grouped anagrams
        grouped.values().forEach(System.out::println);

        // Optional: Print newline at the end
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);
    }
}
