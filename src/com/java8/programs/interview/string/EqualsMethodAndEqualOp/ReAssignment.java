package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class ReAssignment {
    public static void main(String[] args) {
        String str = "abc";
        str.toUpperCase(); // This does not change 'str', it creates a new string.
        System.out.println(str); // Output: abc (not ABC)

        str = str.toUpperCase(); // Correct reassignment
        System.out.println(str); // Output: ABC
    }
}
