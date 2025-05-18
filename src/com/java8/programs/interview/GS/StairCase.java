package com.java8.programs.interview.GS;

import java.util.HashMap;
import java.util.Map;

/*

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */
public class StairCase {
    // Recursive Approach (Brute Force)
    public int countStepsRecursive(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countStepsRecursive(n - 1) + countStepsRecursive(n - 2) + countStepsRecursive(n - 3);
    }
    /*🔍 Explanation:
Base case: n == 0 means a valid path
For each step, try all options: n-1, n-2, and n-3
❌ Drawback:
Exponential time due to repeated subproblems*/

    //Top-Down with Memoization (Recursion + Cache)
    public int countStepsMemo(int n, Map<Integer, Integer> memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int steps = countStepsMemo(n - 1, memo)
                + countStepsMemo(n - 2, memo)
                + countStepsMemo(n - 3, memo);

        memo.put(n, steps);
        return steps;
    }
/*Time: O(n)
Only computes each value of n once. Space for recursion + map.*/

    //Bottom-Up Dynamic Programming
    public int countStepsDP(int n) {
        /*If n is less than 0, there are no ways to reach a negative step, so return 0.
If n is 0, there is exactly one way to be at the starting point (doing nothing), so return 1.*/
        if (n < 0) return 0;
        if (n == 0) return 1;

        /*Create an array dp of size n + 1 to store the number of ways to reach each step.*/
        int[] dp = new int[n + 1];
        //Initialize dp[0] to 1 because there is one way to be at the starting point.
        dp[0] = 1;
        /*Iterate from step 1 to step n.
        For each step i, calculate the number of ways to reach step i by summing the ways to reach the previous three steps:
        dp[i - 1]: Ways to reach step i from step i - 1.
        dp[i - 2]: Ways to reach step i from step i - 2.
        dp[i - 3]: Ways to reach step i from step i - 3.
        Use conditional checks (i - 1 >= 0 ? dp[i - 1] : 0) to ensure we don't access negative indices.*/
        for (int i = 1; i <= n; i++) {
            dp[i] += (i - 1 >= 0 ? dp[i - 1] : 0);
            dp[i] += (i - 2 >= 0 ? dp[i - 2] : 0);
            dp[i] += (i - 3 >= 0 ? dp[i - 3] : 0);
        }

        return dp[n];
    }
/*🧠 Time: O(n)
🧠 Space: O(n)*/

    //Bottom-Up (Optimized Space)
    public int countStepsDPOptimized(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        int a = 1, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            int total = a + b + c;
            c = b;
            b = a;
            a = total;
        }
        return a;
    }
/*🧠 Time: O(n)
✅ Space: O(1)*/

    public static void main(String[] args) {
        int n = 5;

        StairCase s = new StairCase();

        System.out.println("Recursive: " + s.countStepsRecursive(n));
        System.out.println("Memoization: " + s.countStepsMemo(n, new HashMap<>()));
        System.out.println("DP: " + s.countStepsDP(n));
        System.out.println("Optimized DP: " + s.countStepsDPOptimized(n));

        for (int i = 1; i <= 5; i++)
        {
            int numberOfCombinations = s.countStepsDPOptimized(i);
            System.out.println(i + " steps => " + numberOfCombinations);
        }
    }

}
