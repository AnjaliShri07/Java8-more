package com.java8.programs.interview.GS;

/*To find the largest palindrome in a given string, we need to look for substrings that are palindromes and identify the largest one.

Approach:
A palindrome is a string that reads the same forward and backward.
The challenge is to find the longest substring of the input string that is a palindrome.
The brute force approach would involve checking all possible substrings, but we can use a more efficient approach
with dynamic programming or center expansion.
Center Expansion Method is more optimal and simple to implement. Here's the plan:
Center Expansion: A palindrome mirrors around its center. Therefore, we can consider each character
and each pair of adjacent characters as potential centers and expand outwards while checking for a palindrome.
For each center, expand as long as the characters on both sides are the same.
Track the longest palindrome found during the expansion.

Steps for the Solution:
Loop through each character in the string: Treat each character (and pair of characters) as the center of a potential palindrome.
Expand outwards: For each center, try expanding outwards and compare characters on both sides.
Stop when characters no longer match.
Track the longest palindrome: During the expansion, keep track of the longest palindrome found. Return the longest palindrome.*/
public class LongestPalindrome {
    // Function to expand from the center and return the longest palindrome substring
    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the substring that is the palindrome
        return s.substring(left + 1, right);
    }

    // Function to find the largest palindrome in a string
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";

        String longestPal = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes (single character center)
            String palindrome1 = expandFromCenter(s, i, i);
            // Even-length palindromes (pair of characters center)
            String palindrome2 = expandFromCenter(s, i, i + 1);

            // Update the longest palindrome if necessary
            if (palindrome1.length() > longestPal.length()) {
                longestPal = palindrome1;
            }
            if (palindrome2.length() > longestPal.length()) {
                longestPal = palindrome2;
            }
        }

        return longestPal;
    }

    public static void main(String[] args) {
        String input = "babad";
        String result = longestPalindrome(input);
        System.out.println("The longest palindrome substring is: " + result);
    }
}
