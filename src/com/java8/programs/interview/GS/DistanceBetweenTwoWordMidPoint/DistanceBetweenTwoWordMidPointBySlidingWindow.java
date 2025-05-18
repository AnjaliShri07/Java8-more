package com.java8.programs.interview.GS.DistanceBetweenTwoWordMidPoint;

public class DistanceBetweenTwoWordMidPointBySlidingWindow {
    public static double shortestDistance(String document, String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        String[] words = document.split("\\W+"); // Split by non-word characters

        //lastWord1Pos and lastWord2Pos will store the midpoint positions of the most recent match for word1 and word2.
        //shortest stores the minimum distance found between the two midpoints.
        int lastWord1Pos = -1;
        int lastWord2Pos = -1;
        double shortest = Double.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();

            //document.indexOf(words[i], i) searches for the starting position of the word in the original document.
            //endPos is the last character index of the word. If a word starts at position 6 and is 5 characters long,
            // it ends at 6 + 5 - 1 = 10.
            //midPoint is the average of the start and end — i.e., the center character of the word.
            int startPos = document.indexOf(words[i], i);
            int endPos = startPos + words[i].length() - 1;
            int midPoint = (startPos + endPos) / 2;

            //Update lastWord1Pos with the new midpoint.
            //If lastWord2Pos has already been seen, calculate the distance between the two and update shortest.
            if (word.equals(word1)) {
                lastWord1Pos = midPoint;
                if (lastWord2Pos != -1) {
                    shortest = Math.min(shortest, Math.abs(lastWord1Pos - lastWord2Pos));
                }
            } else if (word.equals(word2)) {
                lastWord2Pos = midPoint;
                if (lastWord1Pos != -1) {
                    shortest = Math.min(shortest, Math.abs(lastWord1Pos - lastWord2Pos));
                }
            }
        }
//If no valid pair was found (i.e., both words never occurred), return -1.
//Otherwise, return the shortest midpoint distance.
        return shortest == Double.MAX_VALUE ? -1 : shortest;
    }

    public static boolean pass() {
        return  shortestDistance(document, "and", "graphic") == 6d &&
                shortestDistance(document, "transfer", "it") == 14d &&
                shortestDistance(document, "Design", "filler") == 25d;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Some tests failed");
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
/*Alternative Approach 2: Using Sliding Window for Optimization
This approach uses the sliding window technique to minimize space complexity and avoid storing all midpoints.
By sliding through the document, we can update the minimum distance directly as we find both word1 and word2 in sequence.

Steps:
Slide through the document to find occurrences of word1 and word2.
Track the most recent position of word1 and word2.

Every time both are found, compute the distance between their midpoints and update the minimum distance.

Distance Calculation: Every time we find both words, we calculate the distance between their midpoints and update
the shortest distance if necessary.

Time Complexity:
Sliding through the document: O(n) where n is the length of the document.
Distance Calculation Complexity: O(1) for each pair of occurrences.

Space Complexity:
Space Complexity: O(1) as we only need a few variables to track the most recent occurrences of the words.

*/
