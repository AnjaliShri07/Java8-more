package com.java8.programs.interview.GS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Return an array containing prime numbers whose product is x
 * Examples:
 * primeFactorization( 6 ) == [2,3]
 * primeFactorization( 5 ) == [5]
 */
public class PrimeFactorization {
    public static ArrayList<Integer> primeFactorization(int x) {
        ArrayList<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (x > 1) {
            while (x % divisor == 0) {
                factors.add(divisor);
                x /= divisor;
            }
            divisor++;
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(primeFactorization(6) + " " + primeFactorization(5));

        if (primeFactorization(6).equals(new ArrayList<>(Arrays.asList(2, 3))) &&
                primeFactorization(5).equals(new ArrayList<>(Arrays.asList(5)))) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }
    }
}
