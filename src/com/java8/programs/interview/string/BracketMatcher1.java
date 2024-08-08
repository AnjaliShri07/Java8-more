package com.java8.programs.interview.string;

import java.util.Stack;

public class BracketMatcher1 {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                // If the character is an opening bracket, push it onto the stack
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If the character is a closing bracket, check if the stack is empty
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }

                char openBracket = stack.pop();
                if (!isMatchingPair(openBracket, ch)) {
                    return false; // Mismatched brackets
                }
            }
        }

        // If the stack is not empty, there are unmatched opening brackets
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "{{[[(())]]}}";
        String test4 = "{def[abcd(123)xyz]4666}";


        System.out.println("Test 1 is balanced: " + isBalanced(test1)); // true
        System.out.println("Test 2 is balanced: " + isBalanced(test2)); // false
        System.out.println("Test 3 is balanced: " + isBalanced(test3)); // true
        System.out.println("Test 4 is balanced: " + isBalanced(test4));
    }
}
