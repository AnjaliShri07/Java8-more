package com.java8.programs.interview.string.bracketBalance;

import java.util.*;
import java.util.Stack;

public class BracketMatcher1 {
    public static boolean isBalanced(String brackets) {
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : brackets.toCharArray()) {
            if (bracketPairs.containsValue(ch)) {
                // If it's an opening bracket, push it onto the stack
                stack.push(ch);
            } else if (bracketPairs.containsKey(ch)) {
                // If it's a closing bracket
                if (stack.isEmpty() || stack.peek() != bracketPairs.get(ch)) {
                    return false; // Mismatch found
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "{{[[(())]]}}";
        String test4 = "{def[abcd(123)xyz]4666}";


        System.out.println("Test 1 is balanced: " + isBalanced(test1)); // true
        System.out.println("Test 2 is balanced: " + isBalanced(test2)); // false
        System.out.println("Test 3 is balanced: " + isBalanced(test3)); // true
        System.out.println("Test 4 is balanced: " + isBalanced(test4)); //true
    }
}
