package com.java8.programs.interview.GS;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseIndividualWords {

    public static void main(String[] args) {
        String input = "Hello World";
        String reversedWords = reverseWords(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed Words: " + reversedWords);
    }

    private static String reverseWords(String input) {
        return Arrays.stream(input.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

}
