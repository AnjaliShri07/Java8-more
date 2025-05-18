package com.java8.programs.interview.GS;

import java.util.Scanner;
/*To add two fractions, we need to follow these steps:
Find a common denominator: The least common denominator (LCD) of two fractions is typically the least common multiple
(LCM) of their individual denominators.
Adjust the numerators: Once we have the LCD, we adjust the numerators by multiplying them with the appropriate factor
that makes the denominators equal.
Add the numerators: After adjusting the numerators, we can simply add them together.
Simplify the result: If necessary, simplify the resulting fraction by finding the greatest common divisor (GCD) of the
numerator and denominator.*/
public class FractionAdder {
    // Function to calculate the Greatest Common Divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find the Least Common Denominator (LCD)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Function to add two fractions
    public static String addFractions(int num1, int den1, int num2, int den2) {
        // Find the Least Common Denominator (LCD)
        int lcd = lcm(den1, den2);

        // Adjust the numerators
        int adjustedNum1 = num1 * (lcd / den1);
        int adjustedNum2 = num2 * (lcd / den2);

        // Add the numerators
        int resultNum = adjustedNum1 + adjustedNum2;

        // Simplify the result by dividing both numerator and denominator by their GCD
        int gcdResult = gcd(resultNum, lcd);
        resultNum /= gcdResult;
        lcd /= gcdResult;

        // Return the result as a string
        return resultNum + "/" + lcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first fraction
        System.out.println("Enter the first fraction:");
        System.out.print("Numerator: ");
        int num1 = scanner.nextInt();
        System.out.print("Denominator: ");
        int den1 = scanner.nextInt();

        // Input second fraction
        System.out.println("Enter the second fraction:");
        System.out.print("Numerator: ");
        int num2 = scanner.nextInt();
        System.out.print("Denominator: ");
        int den2 = scanner.nextInt();

        // Check for denominator being zero
        if (den1 == 0 || den2 == 0) {
            System.out.println("Denominator cannot be zero.");
        } else {
            // Add the fractions and display the result
            String result = addFractions(num1, den1, num2, den2);
            System.out.println("The result of adding the fractions is: " + result);
        }

        scanner.close();
    }
}
/*Explanation:
GCD Function: The gcd() method calculates the greatest common divisor of two numbers using the Euclidean algorithm. This is useful for simplifying fractions after performing the addition.
LCM Function: The lcm() method calculates the least common multiple of two numbers. This is used to determine the least common denominator (LCD) for the two fractions.

addFractions() Method:
It first calculates the LCD of the two denominators.
Then, it adjusts the numerators by multiplying them with factors such that both fractions have the same denominator.
The numerators are added together.
The result is simplified by dividing both the numerator and denominator by their GCD.
The result is returned as a string in the form "numerator/denominator".
User Input: The program prompts the user to input the numerators and denominators of two fractions. It handles the case where the denominator is zero (which is invalid).
Simplification: After adding the fractions, the result is simplified using the GCD.

Example:
Input:
Enter the first fraction:
Numerator: 1
Denominator: 2
Enter the second fraction:
Numerator: 1
Denominator: 3

Output:
The result of adding the fractions is: 5/6
Time Complexity:
GCD Calculation: The gcd() function runs in
𝑂(log⁡(min⁡(𝑎,𝑏)))
O(log(min(a,b))), where a and b are the numbers whose GCD is being calculated.

LCM Calculation: The lcm() function runs in constant time because it only calls gcd().

Fraction Addition: The overall complexity of adding two fractions is
𝑂(log⁡(min⁡(𝑎,𝑏)))
O(log(min(a,b))), due to the GCD computation involved in simplifying the result.

Space Complexity:
Space Complexity: The space complexity is𝑂(1)
O(1) because we are only using a few integer variables and no additional space that grows with input size.*/