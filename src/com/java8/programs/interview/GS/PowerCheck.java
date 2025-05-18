package com.java8.programs.interview.GS;

public class PowerCheck {
    public static void main(String[] args) {
        int base = 2;
        int number = 16;

        boolean isPower = isPowerOf(base, number);
        System.out.println(number + " is " + (isPower ? "" : "not ") + "a power of " + base);
        System.out.println(isPowerOf(0,0));
    }

    public static boolean isPowerOf(int base, int number) {
        // Edge cases
        if (number == 1) return true; // Any number raised to 0 is 1
        if (base == 1) return false; // 1^k = 1 for any k

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
