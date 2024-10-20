package com.java8.programs.interview.string;

import java.util.*;

public class MinSwapsForBracketBalance {
    public static int minimumSwaps(String brackets) {
        if(brackets.length() % 2 !=0){
            return -1;
        }
        // Map to track matching pairs
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        Stack<Character> stack = new Stack<>();
        int mismatches = 0;

        for (char ch : brackets.toCharArray()) {
            if (bracketPairs.containsValue(ch)) {
                stack.push(ch); // If it's an opening bracket
            } else if (bracketPairs.containsKey(ch)) {
                if (!stack.isEmpty() && stack.peek() == bracketPairs.get(ch)) {
                    stack.pop(); // If it's a closing bracket
                }else {
                    mismatches++;
                }
            }
        }

        // The number of swaps needed is half the number of mismatches
        return (mismatches + stack.size()) / 2;
    }
    public static void main(String[] args) {
        String s = ")(())(";
        String s1 = "(()))(";
        String s2 = "((())";
        String s3 = "(()())";
        String s4 = "[]][][";
        String s5 = "({[)}]";
        String s6 = "((()))[{";
        String s7 = "({[((())]})";
        String s8 =  "{[({[}]})](";
        String s9 = "{def[abcd(123)xyz]4666}";

        System.out.println(s +" : "+minimumSwaps(s));
        System.out.println(s1 +": "+"s1 = "+minimumSwaps(s1));
        System.out.println(s2 +": "+"s2 = "+minimumSwaps(s2));
        System.out.println(s3 +": "+"s3 = "+minimumSwaps(s3));
        System.out.println(s4 +": "+"s4 = "+minimumSwaps(s4));
        System.out.println(s5 +": "+"s5 = "+minimumSwaps(s5));
        System.out.println(s6 +": "+"s6 = "+minimumSwaps(s6));
        System.out.println(s7 +": "+"s7 = "+minimumSwaps(s7));
        System.out.println(s8 +": "+"s8 = "+minimumSwaps(s8));
        System.out.println(s9 +": "+"s9 = "+minimumSwaps(s9));
    }
}
/*
Explanation
Bracket Matching:

Use a Map to define matching pairs of brackets.
Processing:

Use a Stack to keep track of unmatched opening brackets.
Increment the mismatches counter for unmatched closing brackets.

Check for Impossibility:

If the stack is not empty after processing the string, or if there is an odd number of mismatches, it's impossible to balance the brackets.
Return -1 in these cases.
Swaps Calculation:
Sum all unmatched counts and add the mismatches.
The result divided by 2 gives the minimum number of swaps needed.
If balancing is possible, calculate the minimum number of swaps needed as (mismatches + stack.size()) / 2.

*/
