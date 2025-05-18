package com.java8.programs.interview.GS;

import java.util.Arrays;

/* Problem
Given two fractions represented as integer arrays (numerator and denominator),
return their sum as a reduced fraction.

For example:
addFractions([2, 3], [1, 2]) → [7, 6]
Steps to Add Fractions
Let fraction1 = [a, b], fraction2 = [c, d]

Find a common denominator: lcm(b, d) or simply b * d if you simplify afterward
Convert both to have the same denominator:
a' = a * d
c' = c * b

Add numerators:
numerator = a * d + c * b
denominator = b * d
Reduce the result by dividing both by their greatest common divisor (GCD)*/
public class AddFraction {

    // Helper: GCD using Euclid's algorithm
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int a = fraction1[0], b = fraction1[1];
        int c = fraction2[0], d = fraction2[1];

        // Calculate numerator and denominator
        int numerator = a * d + c * b;
        int denominator = b * d;

        // Reduce the result
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    public static void main(String[] args) {
        int[] result = addFractions(new int[]{2, 3}, new int[]{1, 2});
        Arrays.stream(result).forEach(System.out::println);
        if (result[0] == 7 && result[1] == 6) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
            System.out.println("Got: [" + result[0] + "/" + result[1] + "]");
        }
    }
}
