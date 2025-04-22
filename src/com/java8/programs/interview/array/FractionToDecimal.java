package com.java8.programs.interview.array;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle negative result
        if ((numerator < 0) ^ (denominator < 0)) {  // Uses XOR to determine if only one of them is negative.
            result.append("-");
        }

        // Convert to long to avoid overflow (e.g., Integer.MIN_VALUE / -1)
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        // Append integer part
        result.append(dividend / divisor);
        long remainder = dividend % divisor;

        // No decimal part
        if (remainder == 0) return result.toString();

        result.append(".");

        // Map to store remainder and the index at which it appeared in the result
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int start = remainderMap.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / divisor);
            remainder %= divisor;
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));     // Output: "0.5"
        System.out.println(fractionToDecimal(2, 1));     // Output: "2"
        System.out.println(fractionToDecimal(4, 333));   // Output: "0.(012)"
        System.out.println(fractionToDecimal(-50, 8));   // Output: "-6.25"
        System.out.println(fractionToDecimal(7, -12));   // Output: "-0.58(3)"
    }
}
