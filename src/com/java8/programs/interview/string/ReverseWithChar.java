package com.java8.programs.interview.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseWithChar {
    public static void main(String[] args) {
        // Input character array
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Reverse the array using streams
        char[] reversed = reverseArray(s);

        // Print the reversed array
        System.out.println(Arrays.toString(reversed));
    }

    public static char[] reverseArray(char[] s) {
        return IntStream.range(0, s.length)
                .mapToObj(i -> s[s.length - 1 - i]) // Map each index to its corresponding reverse index
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append) // Collect to a StringBuilder
                .toString().toCharArray(); // Convert to char array
    }
}
