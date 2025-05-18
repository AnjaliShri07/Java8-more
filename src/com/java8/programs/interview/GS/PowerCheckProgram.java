package com.java8.programs.interview.GS;

public class PowerCheck {
    // Function to check if x is a power of y
    public static boolean isPowerOf(int x, int y) {
        // Edge cases
        if (x == 1) return true; // Any number raised to 0 is 1
        if (y == 1) return false; // 1^k = 1 for any k

        int result = y;

        // Keep multiplying y by itself and check if it equals x
        while (result < x) {
            result *= y;
        }

        // If result equals x, then x is a power of y
        return result == x;
    }

    public static void main(String[] args) {
        int x = 16;
        int y = 2;

        if (isPowerOf(x, y)) {
            System.out.println(x + " is a power of " + y);
        } else {
            System.out.println(x + " is not a power of " + y);
        }
    }
}
