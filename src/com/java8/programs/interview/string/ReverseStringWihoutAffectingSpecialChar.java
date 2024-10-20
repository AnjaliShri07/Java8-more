package com.java8.programs.interview.string;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringWihoutAffectingSpecialChar {
    public static String reverseWithoutAffectingSpecialChars(String input) {
        // Create a list of only the alphabetic characters in the input string
        List<Character> lettersOnly = input.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // Reverse the alphabetic characters
        Collections.reverse(lettersOnly);
        List<Character> reversedLetters = lettersOnly;

        // Initialize a StringBuilder to construct the final result
        StringBuilder result = new StringBuilder();
        final int[] index = {0}; // To track the position in the reversed letters string

        // Iterate over the original string and construct the result
        IntStream.range(0, input.length()).forEach(i -> {
            if (Character.isLetter(input.charAt(i))) {
                result.append(reversedLetters.get(index[0]++)); // If the character is a letter, place the reversed letter
            } else {
                result.append(input.charAt(i)); // If it's a special character, keep it as is
            }
        });

        return result.toString();
    }
    public static void main(String[] args) {
        String str = "a,b$c";
        System.out.println(reverseWithoutAffectingSpecialChars(str));
        String input = "Hello, World! 123";
        System.out.println(reverseWithoutAffectingSpecialChars(input));
    }
}
