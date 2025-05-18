package com.java8.programs.interview.GS;

/*You are given a string s consisting of lowercase English letters, and an integer k (0 ≤ k < s.length()).
Your task is to rotate the string s to the right by k positions in-place.
The rotation should be done in such a way that the last k characters of the string come to the front,
and the remaining characters are shifted to the right.
For example, if the input string is "abcdefghi" and k = 5, the rotated string should be "fghiabcde".
*/
public class RotateString {
    public static void rotateString(char[] s, int k) {
        int n = s.length;
        k = k % n; // Ensure k is within the bounds of the string length

        // Reverse the entire string
        reverse(s, 0, n - 1);
        // Reverse the first k characters
        reverse(s, 0, k - 1);
        // Reverse the remaining characters
        reverse(s, k, n - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String input = "abcdefghi";
        int k = 5;
        char[] s = input.toCharArray();
        rotateString(s, k);
        System.out.println("Rotated String: " + new String(s));
    }
}
