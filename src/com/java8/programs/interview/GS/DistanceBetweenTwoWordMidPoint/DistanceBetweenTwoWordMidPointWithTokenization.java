package com.java8.programs.interview.GS.DistanceBetweenTwoWordMidPoint;

import java.util.*;

public class DistanceBetweenTwoWordMidPointWithTokenization {
    public static double shortestDistance(String document, String word1, String word2) {
        // Make the document case-insensitive.
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        String[] words = document.split("\\W+");  // Split by non-word characters
        List<Integer> word1MidPoints = new ArrayList<>();
        List<Integer> word2MidPoints = new ArrayList<>();
        int currentPos = 0;  // Tracks the current position in the document

        // Iterate through the words and find positions of word1 and word2
        for (String word : words) {
            int startPos = currentPos;
            int endPos = currentPos + word.length() - 1;
            int midPoint = (startPos + endPos) / 2;

            if (word.equalsIgnoreCase(word1)) {
                word1MidPoints.add(midPoint);
            } else if (word.equalsIgnoreCase(word2)) {
                word2MidPoints.add(midPoint);
            }

            currentPos += word.length() + 1;  // Move the current position past this word and a space
        }

        // Now calculate the shortest distance between midpoints of word1 and word2
        double shortest = Double.MAX_VALUE;
        for (int i : word1MidPoints) {
            for (int j : word2MidPoints) {
                shortest = Math.min(shortest, Math.abs(i - j));
            }
        }

        return shortest == Double.MAX_VALUE ? -1 : shortest;
    }

    public static boolean pass() {
        return  shortestDistance(document, "and", "graphic") == 6d &&
                shortestDistance(document, "transfer", "it") == 14d &&
                shortestDistance(document, "Design", "filler") == 25d;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("✅ All tests passed");
        } else {
            System.out.println("❌ Some tests failed");
        }
    }

    private static final String document;
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements ");
        sb.append("lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements ");
        sb.append("for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which ");
        document = sb.toString();
    }
}
/*Approach 1: Using Tokenization with a Map of Word Positions
In this approach, instead of traversing the document multiple times, we can tokenize the string first, then use a map to keep track of the positions of word1 and word2. This can simplify the logic and reduce unnecessary processing.

Steps:
Tokenize the document by splitting it into words, and also track their starting positions.
For each word, calculate the midpoint as you store it.
Use two separate lists (or a map) to store midpoints of word1 and word2.
After collecting all the positions, calculate the shortest distance between each midpoint.
Explanation of the Alternative Approach 1:
Tokenization: We use a regular expression (\\W+) to split the document into words while ignoring punctuation.
Word Positioning: Each word’s position in the document is calculated based on its start and end positions, and the midpoint is derived from that.
Efficiency: Instead of scanning the document multiple times or using additional regex parsing, we tokenize once and find midpoints in one pass.

Time Complexity:
Tokenization Complexity: O(n), where n is the length of the document.
Distance Calculation Complexity: O(w1 * w2) where w1 and w2 are the numbers of occurrences of word1 and word2 respectively.
Total Complexity: In the worst case, this can be O(n + w1 * w2).
Space Complexity:
Space Complexity: O(w1 + w2) for storing positions of the two words.*/