package com.java8.programs.interview.GS;

/*Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate
characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.
Examples :
Input : str = “001”
Output : 1
Minimum number of flips required = 1
We can flip 1st bit from 0 to 1

Input : str = “0001010111”
Output : 2
Minimum number of flips required = 2
We can flip 2nd bit from 0 to 1 and 9th
bit from 1 to 0 to make alternate
string “0101010101”.*/
public class BinaryAlternateFlipCount {
    // Function to count minimum flips
    public static int minFlips(String str) {
        int flipCountStartWith0 = 0; // for pattern 010101...
        int flipCountStartWith1 = 0; // for pattern 101010...

        for (int i = 0; i < str.length(); i++) {
            char expectedChar0 = (i % 2 == 0) ? '0' : '1'; // alternating starting with 0
            char expectedChar1 = (i % 2 == 0) ? '1' : '0'; // alternating starting with 1

            if (str.charAt(i) != expectedChar0) {
                flipCountStartWith0++;
            }
            if (str.charAt(i) != expectedChar1) {
                flipCountStartWith1++;
            }
        }

        return Math.min(flipCountStartWith0, flipCountStartWith1);
    }

    public static void main(String[] args) {
        String str1 = "001";
        String str2 = "0001010111";

        System.out.println("Minimum flips for \"" + str1 + "\": " + minFlips(str1));
        System.out.println("Minimum flips for \"" + str2 + "\": " + minFlips(str2));
    }
}
/*Time & Space Complexity
Time Complexity: O(n) – where n is the length of the string
Space Complexity: O(1) – uses constant extra space*/