package com.java8.programs.interview.GS;

import java.util.*;

/*✅ Pascal’s Triangle Rule
The value at position (col, row) in Pascal’s Triangle corresponds to the binomial coefficient:
pascal(col, row) = C(row, col) = row! / (col! * (row - col)!)
Where:
! is factorial
row >= col >= 0
We can implement this using either recursion with memoization or directly using a combinatorial formula.*/
public class PascalTriangle {

    // Use a map to cache previously computed factorials (optional optimization)
    private static Map<Integer, Long> factorialCache = new HashMap<>();

    public static int pascal(int col, int row) {
        if (col > row || col < 0) return 0;
        return (int) (factorial(row) / (factorial(col) * factorial(row - col)));
    }

    // Factorial with memoization
    private static long factorial(int n) {
        if (n <= 1) return 1;
        if (factorialCache.containsKey(n)) return factorialCache.get(n);
        long result = n * factorial(n - 1);
        factorialCache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        if (
                PascalTriangle.pascal(0, 0) == 1 &&
                        PascalTriangle.pascal(1, 2) == 2 &&
                        PascalTriangle.pascal(5, 6) == 6 &&
                        PascalTriangle.pascal(4, 8) == 70 &&
                        PascalTriangle.pascal(6, 6) == 1
        ) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }
    }
}
