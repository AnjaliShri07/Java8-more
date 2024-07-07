package com.java8.programs.interview.string;

import java.util.stream.IntStream;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        // Remove any non-alphanumeric characters and convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the cleaned string is a palindrome using IntStream
        return IntStream.range(0, cleanedStr.length() / 2)
                .allMatch(i -> cleanedStr.charAt(i) == cleanedStr.charAt(cleanedStr.length() - 1 - i));
    }
    public static void main(String[] args) {
        String original = "A man, a plan, a canal, Panama"; // Example input

        // Check if the string is a palindrome
        boolean isPalindrome = isPalindrome(original);

        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a palindrome.");
        } else {
            System.out.println("\"" + original + "\" is not a palindrome.");
        }
    }
}

/*Explanation
replaceAll("[^a-zA-Z0-9]", ""): Removes any non-alphanumeric characters from the string.
toLowerCase(): Converts the string to lowercase to ensure the comparison is case-insensitive.
        IntStream.range(0, cleanedStr.length() / 2): Creates a stream of integers from 0 to cleanedStr.length() / 2 - 1.
allMatch(i -> cleanedStr.charAt(i) == cleanedStr.charAt(cleanedStr.length() - 1 - i)): */
