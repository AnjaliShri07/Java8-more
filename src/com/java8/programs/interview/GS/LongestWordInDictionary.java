package com.java8.programs.interview.GS;

import java.util.*;
// Given a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}
class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }

    public String[] getEntries() {
        return entries;
    }
}

public class LongestWordInDictionary {

    public static Set<String> longestWord(String letters, Dictionary dict) {
        Set<String> result = new HashSet<>();
        int maxLength = 0;

        // Build frequency map of the input letters.
        // This helps us know how many times each character appears in the input.
        Map<Character, Integer> letterCounts = buildLetterMap(letters);

        // Check if the word can be made from the given letters using canForm(...).
        //Keep track of the longest word(s).
        for (String word : dict.getEntries()) {
            if (canForm(word, new HashMap<>(letterCounts))) {
                if (word.length() > maxLength) {
                    result.clear(); // Found longer word(s), reset
                    result.add(word);
                    maxLength = word.length();
                } else if (word.length() == maxLength) {
                    result.add(word); // Same length, add to result
                }
            }
        }
        System.out.println("result ==> "+ result);
        return result;
    }

    private static Map<Character, Integer> buildLetterMap(String letters) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : letters.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    // For each character in the word:
    // See if it’s available in the letter map with a count > 0.
    // Decrement count after use.
    private static boolean canForm(String word, Map<Character, Integer> letterCounts) {
        for (char c : word.toCharArray()) {
            if (!letterCounts.containsKey(c) || letterCounts.get(c) == 0) {
                return false;
            }
            letterCounts.put(c, letterCounts.get(c) - 1);
        }
        return true;
    }

    public static boolean pass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
        return new HashSet<>(Arrays.asList("toe")).equals(longestWord("toe", dict)) &&
                new HashSet<>(Arrays.asList("toes")).equals(longestWord("oetss", dict)) &&
                new HashSet<>(Arrays.asList("dog", "god")).equals(longestWord("odg", dict));
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }
}
/*⏱ Time and Space Complexity
Time: O(n * m), where:

n = number of dictionary words

m = average word length

Space: O(k), where k = number of letters in input*/