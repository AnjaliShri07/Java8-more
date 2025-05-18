package com.java8.programs.interview.GS;

public class PowerOf10 {
    /**
     * Returns true if x is a power-of-10.
     */
    public static boolean isPowerOf10(int x) {
        if (x <= 0)
            return false;  // Negative numbers and 0 cannot be powers of 10

        // Keep dividing by 10 and check if the result is 1
        while (x % 10 == 0) {
            x /= 10;
        }

        return x == 1; // If we end up with 1, it's a power of 10
    }

    public static boolean doTestsPass() {
        int[] isPowerList = {10, 100, 1000, 10000, 1}; // Expected power of 10 numbers
        int[] isNotPowerList = {3, 50, 250, -10, 0}; // Expected non-power of 10 numbers

        // Test the numbers that should be power of 10
        for (int i : isPowerList) {
            if (!isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        // Test the numbers that should not be power of 10
        for (int i : isNotPowerList) {
            if (isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Some tests failed");
        }
    }
}
