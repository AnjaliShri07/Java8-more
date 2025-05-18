package com.java8.programs.interview.GS;

public class PowerCheck {
    public static void main(String[] args) {
        int base = 2; // Example base
        int number = 16; // Example number

        boolean isPower = isPowerOf(base, number);
        System.out.println(number + " is " + (isPower ? "" : "not ") + "a power of " + base);
    }

    public static boolean isPowerOf(int base, int number) {
        if (base <= 1) {
            return number == base;
        }

        int power = 1;
        while (power < number) {
            power *= base;
        }
        return power == number;
    }
}
