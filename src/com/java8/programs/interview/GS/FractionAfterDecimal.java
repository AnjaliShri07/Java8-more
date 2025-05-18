package com.java8.programs.interview.GS;

import java.util.*;

public class FractionAfterDecimal {
    public static String fractionRepresentation(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // If either one is negative (not both), add '-'
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        // Convert to Long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString(); // No decimal part

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int start = map.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionRepresentation(1, 2));    // 0.5
        System.out.println(fractionRepresentation(1, 3));    // 0.(3)
        System.out.println(fractionRepresentation(6, 11));   // 0.(54)
        System.out.println(fractionRepresentation(22, 7));   // 3.(142857)
        System.out.println(fractionRepresentation(-50, 8));     // -6.25
        System.out.println(fractionRepresentation(-1, -3));     // 0.(3)
        System.out.println(fractionRepresentation(7, -12));     // -0.58(3)

        boolean passed = true;
        passed &= fractionRepresentation(1, 2).equals("0.5");
        passed &= fractionRepresentation(1, 3).equals("0.(3)");
        passed &= fractionRepresentation(6, 11).equals("0.(54)");
        passed &= fractionRepresentation(22, 7).equals("3.(142857)");
        passed &= fractionRepresentation(-50, 8).equals("-6.25");
        passed &= fractionRepresentation(-1, -3).equals("0.(3)");

        if (passed) {
            System.out.println("All passed");
        } else {
            System.out.println("Some tests failed");
        }
    }
}
/*🧠 How It Works:
Perform manual division.
Use a Map to remember previously seen remainders and the index in the result string.
If a remainder repeats, it means the decimal part is repeating from that index.

✅ Time & Space Complexity:
Metric	Complexity
Time	O(n) where n is the length of the repeating cycle (usually small)
Space	O(n) to track remainders*/