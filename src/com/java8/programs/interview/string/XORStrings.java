package com.java8.programs.interview.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XORStrings {
    public static String xorStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("Strings must be of the same length");
        }

        return IntStream.range(0, str1.length())
                .map(i -> (str1.charAt(i) - '0') ^ (str2.charAt(i) - '0'))
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String str1 = "10101";
        String str2 = "00101";
        String result = xorStrings(str1, str2);
        System.out.println("XOR Result: " + result);
    }
}

/*
Explanation:
Input Validation:

Check if the two strings have the same length. If not, throw an IllegalArgumentException.
Stream Operations:

IntStream.range(0, str1.length()): Create a range of indices from 0 to the length of the strings.
map(i -> (str1.charAt(i) - '0') ^ (str2.charAt(i) - '0')): Convert each character to an integer (0 or 1) and apply the XOR operation.
mapToObj(Integer::toString): Convert the resulting integers back to strings.
collect(Collectors.joining()): Join the strings to form the final result.*/
