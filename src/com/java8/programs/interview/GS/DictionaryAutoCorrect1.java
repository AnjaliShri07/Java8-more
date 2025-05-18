package com.java8.programs.interview.GS;

import java.util.*;

public class DictionaryAutoCorrect1 {

    public static String autoCorrectSentence(List<String> wordList, String[] input) {
        StringBuilder correctedSentence = new StringBuilder();

        for (String word : input) {
            String correctedWord = autoCorrectWord(wordList, word);
            correctedSentence.append(correctedWord).append(" ");
        }

        return correctedSentence.toString().trim();
    }

    public static String autoCorrectWord(List<String> wordList, String word) {
        for (String correctWord : wordList) {
            if (isSimilar(correctWord, word)) {
                return correctWord;
            }
        }
        return word; // Return the original word if no correction is found
    }

    public static boolean isSimilar(String correctWord, String word) {
        // Simple similarity check: words with same length and similar characters
        if (correctWord.length() != word.length()) {
            return false;
        }

        int mismatchCount = 0;
        for (int i = 0; i < correctWord.length(); i++) {
            if (correctWord.charAt(i) != word.charAt(i)) {
                mismatchCount++;
            }
        }

        // Allow up to 2 mismatched characters for simplicity
        return mismatchCount <= 2;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
        String[] input = {"i", "lvie", "ni", "mumbai"};

        String correctedSentence = autoCorrectSentence(wordList, input);
        System.out.println("Auto-corrected sentence: " + correctedSentence);
    }
}
