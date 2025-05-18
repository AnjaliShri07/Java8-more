package com.java8.programs.interview.GS;

import java.util.*;
import java.util.OptionalInt;
import java.util.stream.*;

public class MinimumDistanceBetweenWords {
    public static int findMinDistance(List<String> words, String word1, String word2) {
        // Step 1: Find indices of word1 and word2
        OptionalInt index1 = IntStream.range(0, words.size())
                .filter(i -> words.get(i).equals(word1))
                .findFirst();

        OptionalInt index2 = IntStream.range(0, words.size())
                .filter(i -> words.get(i).equals(word2))
                .findFirst();

        if (index1.isEmpty() || index2.isEmpty()) {
            throw new IllegalArgumentException("Both words must be in the list.");
        }

        // Step 2: Find the middle character index for both words
        int mid1 = getMiddleIndex(word1);
        int mid2 = getMiddleIndex(word2);

        // Step 3: Compute the absolute difference between the middle positions of the words
        return Math.abs(index1.getAsInt() - index2.getAsInt()) + Math.abs(mid1 - mid2);
    }

    // Helper method to get the middle index of a word
    public static int getMiddleIndex(String word) {
        int len = word.length();
        return len % 2 == 0 ? (len / 2) - 1 : len / 2;
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ABC", "XYZ", "LMN", "PQR");

        String word1 = "ABC";
        String word2 = "XYZ";

        int minDistance = findMinDistance(words, word1, word2);

        System.out.println("Minimum distance between words is: " + minDistance);
    }
}
