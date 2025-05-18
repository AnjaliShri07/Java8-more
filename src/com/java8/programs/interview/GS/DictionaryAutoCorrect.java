package com.java8.programs.interview.GS;

import java.util.*;

/*List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
String[] input = {"i", "lvie", "ni", "mumbai"};
 o/p -> Auto-corrected sentence: i live in mumbai.*/
public class DictionaryAutoCorrect {
    public static String autoCorrectSentence(List<String> wordList, String[] input) {
        StringBuilder correctedSentence = new StringBuilder();

        for (String word : input) {
            String correctedWord = findClosestMatch(wordList, word);
            correctedSentence.append(correctedWord).append(" ");
        }

        return correctedSentence.toString().trim();
    }

    public static String findClosestMatch(List<String> wordList, String word) {
        String closestMatch = word;
        int minDistance = Integer.MAX_VALUE;

        for (String candidate : wordList) {
            int distance = calculateLevenshteinDistance(word, candidate);
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = candidate;
            }
        }

        return closestMatch;
    }

    public static int calculateLevenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }

        return dp[a.length()][b.length()];
    }
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
        String[] input = {"i", "lvie", "ni", "mumbai"};

        String correctedSentence = autoCorrectSentence(wordList, input);
        System.out.println("Auto-corrected sentence: " + correctedSentence);
    }
}
