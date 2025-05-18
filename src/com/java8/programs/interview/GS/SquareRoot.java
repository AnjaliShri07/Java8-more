package com.java8.programs.interview.GS;

public class SquareRoot {
    /*
     *   double squareRoot( double x )
     *   Uses Newton-Raphson method to compute square root
     */
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot compute square root of negative number");
        }

        double guess = x;
        double epsilon = 0.00001; // accuracy threshold

        if (x == 0 || x == 1) return x;

        while (Math.abs(guess * guess - x) > epsilon) {
            guess = (guess + x / guess) / 2;
        }

        return guess;
    }

    public static void main(String[] args) {
        double[] inputs = {2, 4, 100};
        double[] expected_values = {1.41421, 2, 10};
        double threshold = 0.001;
        boolean allPassed = true;

        for (int i = 0; i < inputs.length; i++) {
            double actual = squareRoot(inputs[i]);
            if (Math.abs(actual - expected_values[i]) > threshold) {
                System.out.printf("Test failed for %f, expected=%.5f, actual=%.5f\n", inputs[i], expected_values[i], actual);
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("All tests passed");
        }
    }
}
