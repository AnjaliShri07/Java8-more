package com.java8.programs.interview.GS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//The flatMap method is used to transform each element of the stream into a new stream and then flatten the
// resulting streams into a single stream.
public class LargestUniqueSubstring {
    public static String findLargestUniqueSubstringStream(String s) {
         return IntStream.range(0, s.length())
                 .boxed()
                 .flatMap(i -> IntStream.range(i + 1, s.length() + 1)
                         .mapToObj(j -> s.substring(i, j)))
                 .filter(sub -> sub.chars()
                         .mapToObj(c -> (char) c)
                         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                         .values()
                         .stream()
                         .allMatch(count -> count == 1))
                 .max(Comparator.comparingInt(String::length))
                 .orElse("");
   }

    /*Approach
     Track Characters and Their Indices:
     Use a LinkedHashMap to keep track of characters and their indices while maintaining the order of insertion.
     Iterate Through the String:
     As you iterate through the string, update the start index whenever a duplicate character is found.
     Calculate Substring Length:
     Calculate the length of the current substring and update the maximum length and start index accordingly.*/
    public static String findLargestUniqueSubstring(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int start = 0, maxLength = 0, maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, end);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static int[] findLargestUniqueSubstringIndex(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        int currentLength = 1;
        int currentStart = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                charCountMap.put(s.charAt(i - 1), currentLength);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = currentStart;
                }
                currentLength = 1;
                currentStart = i;
            }
        }
        // Check the last uniform substring
        charCountMap.put(s.charAt(s.length() - 1), currentLength);
        if (currentLength > maxLength) {
            maxLength = currentLength;
            startIndex = currentStart;
        }

        return new int[]{startIndex, maxLength};
    }

    public static void main(String[] args) {
        String input = "aaabcbdeaf";
        System.out.println("Largest unique substring: " + findLargestUniqueSubstring(input));
        System.out.println("Using Stream: "+findLargestUniqueSubstringStream(input));

        String input2 = "AABBBBCC";
        int[] result = findLargestUniqueSubstringIndex(input2);
        System.out.println("Start Index: " + result[0] + ", "+"Length: " + result[1]);
    }
}
/*Explanation
LinkedHashMap: Used to maintain the order of characters and their indices.
Start Index: Updated whenever a duplicate character is found to ensure the substring contains unique characters.
Max Length Calculation: The length of the current substring is calculated and compared with the maximum length found so far.

Explanation
Condition: if (end - start + 1 > maxLength)

This checks if the length of the current substring (from start to end) is greater than the previously recorded maximum length (maxLength).
end - start + 1 calculates the length of the current substring. end is the current position in the string, and start is the beginning position of the current substring.
Update Maximum Length: maxLength = end - start + 1

If the condition is true, it means the current substring is longer than any previously found substring with unique characters.
maxLength is updated to the length of the current substring.
Update Start Index of Maximum Substring: maxStart = start

maxStart is updated to the current start index, which marks the beginning of the longest substring found so far.
Example
Let's say the input string is "aaabcbdeaf" and we are at the position where end is 9 (character 'f') and start is 3 (character 'b'):

The length of the current substring is end - start + 1 = 9 - 3 + 1 = 7.
If maxLength was previously 6, the condition end - start + 1 > maxLength would be true.
Therefore, maxLength would be updated to 7, and maxStart would be updated to 3.
This ensures that we always keep track of the longest substring with unique characters found during the iteration.

Complexity:
Time Complexity: The algorithm runs in O(n) time, where n is the length of the string. This is because each character is processed once, and the map operations (insertions and deletions) are O(1) on average.
Space Complexity: The space complexity is O(min(n, m)), where n is the length of the string and m is the number of unique characters in the string. This is due to the storage of characters and their indices in the map.*/