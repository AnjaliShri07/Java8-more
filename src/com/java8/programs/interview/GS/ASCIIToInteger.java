package com.java8.programs.interview.GS;

//implement the atoi() function (ASCII to Integer),
public class ASCIIToInteger {
    /*this method converts a String into an integer (just like C's atoi), handling:
Leading/trailing spaces
Optional + or - sign
Non-digit characters after the number
Integer overflow/underflow */
    public static int atoi(String str) {
        if (str == null || str.isEmpty()) return 0;

        //i: pointer for looping through the string
        //sign: assumes positive +1 unless proven otherwise
        //result: accumulates the numeric value
        int i = 0, sign = 1, result = 0;
        str = str.trim(); // Remove leading/trailing spaces

        // Check for sign
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //This loop runs as long as you're seeing digits.
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            /* For each digit:
                Convert it to an int by subtracting '0' from the char.
                For example:
                '3' - '0' → 51 - 48 → 3*/
            int digit = str.charAt(i) - '0';

            // Optional: check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static int atoiStream(String asciiString){
        if (asciiString == null || asciiString.isEmpty()) return 0;

        boolean isNegative = asciiString.charAt(0) == '-';
        String numericPart = isNegative ? asciiString.substring(1) : asciiString;

        int result = numericPart.chars()
                .map(Character::getNumericValue)
                .reduce(0, (acc, digit) -> acc * 10 + digit);

        if (isNegative) {
            result = -result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(atoi("42"));         // 42
        System.out.println(atoi("   -42"));     // -42
        System.out.println(atoi("4193 with"));  // 4193
        System.out.println(atoi("words 123"));  // 0
        System.out.println(atoi("-91283472332")); // Integer.MIN_VALUE
        System.out.println("--------Using Stream--------------");
        System.out.println(atoiStream("-91283472332"));
    }
}
