package com.java8.programs.interview.string.bracketBalance;

import java.util.*;

public class BracketMatcher {
    public static void main(String[] args) {
        String str = "{def[abcd(123)xyz]4666}";

        // Find and print matching brackets
        Map<Integer, Integer> matches = findMatchingBrackets(str);
        for (Map.Entry<Integer, Integer> entry : matches.entrySet()) {
            System.out.println("Open bracket at index " + entry.getKey() +
                    " matches with closing bracket at index " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> findMatchingBrackets(String str) {
        // Map to store matches between opening and closing bracket indices
        Map<Integer, Integer> matches = new HashMap<>();

        // Stack to store the indices of the opening brackets
        Stack<Integer> stack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check for opening brackets
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(i);
            }
            // Check for closing brackets
            else if (ch == '}' || ch == ']' || ch == ')') {
                if (!stack.isEmpty()) {
                    // Pop from stack to get the index of the last unmatched opening bracket
                    int openIndex = stack.pop();

                    // Ensure that the bracket types match
                    if (isMatchingPair(str.charAt(openIndex), ch)) {
                        matches.put(openIndex, i);
                    } else {
                        System.out.println("Mismatched brackets at indices: " + openIndex + " and " + i);
                    }
                } else {
                    System.out.println("Unmatched closing bracket at index: " + i);
                }
            }
        }

        // Check for any unmatched opening brackets
        while (!stack.isEmpty()) {
            System.out.println("Unmatched opening bracket at index: " + stack.pop());
        }

        return matches;
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '(' && close == ')');
    }
}
