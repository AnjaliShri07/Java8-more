package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class CompareStrings9 {
    public static void main(String[] args) {

        String s1 = "CodeGym is the best website for learning Java!";
        String s2 = new String("CodeGym is the best website for learning Java!");
        System.out.println(s1 == s2.intern());
    }
}
