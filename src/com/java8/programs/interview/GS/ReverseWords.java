package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Print words of a string in reverse order. Let there be a string say “I AM A TESTER So, the output should be TESTER A AM I”
public class ReverseWords {
    public static void main(String[] args) {
        String input = "I AM A TESTER";
        String reversed = reverseWords(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed Words: " + reversed);
    }


    private static String reverseWords(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        return words.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                }))
                .collect(Collectors.joining(" "));
    }
}
