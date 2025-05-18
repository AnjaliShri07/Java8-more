package com.java8.programs.interview.GS;

import java.util.Set;
import java.util.stream.Collectors;
 /* Pangram FInder
 *
         * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String sentence,
 * and returns all the letters it is missing
 *
         */

/*To solve the problem of finding missing letters in a sentence using Java 8 streams, we can follow these steps:
Normalize the sentence: Convert the sentence to lowercase to handle both uppercase and lowercase letters uniformly.
Use a stream to process each character in the sentence and remove duplicates.
Subtract the characters present in the sentence from the complete alphabet to get the missing letters.
Return the missing letters as a string.

Key steps:
We'll use the stream to filter the characters in the alphabet that are missing from the sentence.
A Set can be used to easily identify which letters are present in the sentence.
We can then subtract these present characters from the full alphabet.*/
public class Pangram {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String findMissingLetters(String sentence) {
        // Convert the sentence to lowercase and filter only alphabetic characters
        Set<Character> presentLetters = sentence.toLowerCase().chars()
                .filter(Character::isAlphabetic)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        // Use Streams to find the missing letters by checking which alphabet characters are not in presentLetters
        return ALPHABET.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !presentLetters.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(Pangram.findMissingLetters("The quick brown fox jumps over the lazy dog"));

        boolean success = true;

        // Test cases
        success = success && "".equals(Pangram.findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(Pangram.findMissingLetters(""));

        if (success) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }
    }
}
/*Explanation:
Normalization:
sentence.toLowerCase() converts the sentence to lowercase, making the comparison case-insensitive.

Stream Processing:
sentence.toLowerCase().chars() converts the sentence into a stream of characters (as primitive ints), where filter(Character::isAlphabetic) ensures that only alphabetic characters are considered.
mapToObj(c -> (char) c) converts these primitive ints back to Character objects.
.collect(Collectors.toSet()) gathers these characters into a Set to avoid duplicates.

Finding Missing Letters:
ALPHABET.chars() generates a stream of integer values corresponding to the characters of the alphabet.
We use filter(c -> !presentLetters.contains(c)) to filter out characters that are already present in the sentence.
map(String::valueOf) converts the characters back to their string representation.
Finally, .collect(Collectors.joining()) joins these missing letters into a single string.*/