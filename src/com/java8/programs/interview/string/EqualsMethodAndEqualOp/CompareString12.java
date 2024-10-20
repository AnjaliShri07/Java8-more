package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class CompareString12 {
    public static void main(String[] args) {
        String s1 = "Welcome";

        String s2 = s1.intern();

        String s3 = new String("Welcome");

        String s4 = s3.intern();

        System.out.println(s1==s2);

        System.out.println(s1==s3);

        System.out.println(s1==s4);

        System.out.println(s2==s3);

        System.out.println(s2==s4);

        System.out.println(s3==s4);
    }
}
