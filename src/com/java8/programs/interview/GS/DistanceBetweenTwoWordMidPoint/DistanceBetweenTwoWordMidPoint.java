package com.java8.programs.interview.GS.DistanceBetweenTwoWordMidPoint;

import java.util.*;

// Input two words returns the shortest distance between their two midpoints in number of characters
// Words can appear multiple times in any order and should be case in-sensitive.
// E.g. for the document="Example we just made up"
//   shortestDistance( document, "we", "just" ) == 4
public class DistanceBetweenTwoWordMidPoint {
    public static double shortestDistance(String document, String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        String lowerDoc = document.toLowerCase();

        List<Integer> word1MidPoints = new ArrayList<>();
        List<Integer> word2MidPoints = new ArrayList<>();

        int index = 0;
        while (index < lowerDoc.length()) {
            while (index < lowerDoc.length() && !Character.isLetter(lowerDoc.charAt(index))) {
                index++; // Skip non-letter characters
            }

            int start = index;
            while (index < lowerDoc.length() && Character.isLetter(lowerDoc.charAt(index))) {
                index++; // Traverse the word
                System.out.println("index ==> "+index);
            }

            if (start < index) {
                String word = lowerDoc.substring(start, index);
                int midpoint = (start + index - 1) / 2;

                if (word.equals(word1)) {
                    word1MidPoints.add(midpoint);
                } else if (word.equals(word2)) {
                    word2MidPoints.add(midpoint);
                }
            }
        }

        // Now compare all pairs to find the smallest distance
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
/*✅ Problem Summary:
Input: A string document, and two words: word1, word2.
Output: The shortest distance between the midpoints of any two occurrences (case-insensitive) of word1 and word2 in the text.

🧠 How to Solve:
Normalize the document to lowercase.
Use a regex or tokenization to find word positions and their character indices.
Track every occurrence of word1 and word2:
Store the midpoint character index of each word.
For every word1-midpoint and word2-midpoint pair, compute the absolute distance.
Return the minimum such distance.
🧠 Complexity:
Time Complexity: O(n * m) in worst case, where n = number of word1 matches, m = number of word2 matches.
Space Complexity: O(n + m) for storing midpoints.*/