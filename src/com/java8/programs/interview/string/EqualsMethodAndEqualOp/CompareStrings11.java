package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class CompareStrings11 {
    public static void main(String[] args) {
        String s1= new String("abc");
        String s2 = new String("ABC");
        String s3 = "ABC";
        s1=s2;
        s1=s3;
        System.out.println(s1);
        System.out.println(s1);
    }
}
