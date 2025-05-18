package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.IntStream;
/*
Combine ingredients in a specific order, any of which may be repeated
As an example, consider the following
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E
Encode the string above using only 6 characters: A,B,*,C,*,E
Implement function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode
*/

public class MagicPotion {
    public static int minimalSteps(String potion) {
        List<String> sequence = potion.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .toList();
        return minEncodedLength(sequence);
    }

    private static int minEncodedLength(List<String> sequence) {
        int n = sequence.size();
        int[] dp = new int[n + 1];
        //Initialize all values to infinity (Integer.MAX_VALUE) to represent unknown/expensive solutions.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  //because an empty string requires 0 steps to encode.

        //Loop through each prefix of the input (i characters from the start).
        for (int i = 1; i <= n; i++) {
            int finalI = i;
            // Try repeating a previous block
            //This is to check if there's a repeated block of length len right before i.
            IntStream.rangeClosed(1, i).forEach(len -> {
                //Ensure there's enough space before position i to check two blocks of size len.
                //You need both a previous and a current block to compare.
                if (finalI - 2 * len >= 0) {
                    List<String> prev = sequence.subList(finalI - 2 * len, finalI - len);
                    List<String> curr = sequence.subList(finalI - len, finalI);
                    //If the previous and current blocks are the same:
                    //You can replace the current block with a *.
                    //So the cost to encode i characters becomes:
                    //cost of encoding first i - len characters + 1 (for the *)
                    if (prev.equals(curr)) {
                        dp[finalI] = Math.min(dp[finalI], dp[finalI - len] + 1); // use '*'
                    }
                }
            });
            // Or add current character directly
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        return dp[n];
    }

    private static boolean doTestsPass() {
        if (minimalSteps("ABCDABCE") != 8) {
            System.out.println("Test failed for ABCDABCE");
            return false;
        }

        if (minimalSteps("ABCABCE") != 5) {
            System.out.println("Test failed for ABCABCE");
            return false;
        }

        if (minimalSteps("ABCDE") != 5) {
            System.out.println("Test failed for ABCDE");
            return false;
        }

        if (minimalSteps("AABBB") != 5) {
            System.out.println("Test failed for AABBB");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Encoded Potion: " + MagicPotion.minimalSteps("ABCDABCE"));
        if (MagicPotion.doTestsPass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
/*Explanation:

Example Walkthrough:
For "ABCDABCE":

Initially, the set of seen ingredients is empty.
First ingredient is A. Since it's not in the set, we add it and increment steps to 1.
Next ingredient is B. Since it's not in the set, we add it and increment steps to 2.
Next ingredient is C. Since it's not in the set, we add it and increment steps to 3.
Next ingredient is D. Since it's not in the set, we add it and increment steps to 4.
Next ingredient is A. Since it's already in the set, we increment steps to 5 (for *).
Next ingredient is B. Since it's already in the set, we increment steps to 6 (for *).
Next ingredient is C. Since it's already in the set, we increment steps to 7 (for *).
Final ingredient is E. Since it's not in the set, we add it and increment steps to 8.
Thus, the result is 8 steps for encoding "ABCDABCE".

Test Cases:
Test 1: "ABCDABCE"
Expected result: 8

Test 2: "ABCABCE"
Expected result: 5

Test 3: "ABCDE"
Expected result: 5

Test 4: "AABBB"
Expected result: 5*/