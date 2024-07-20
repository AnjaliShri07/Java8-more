package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class CompareStrings7 {
    public static void main(String[] args) {

        String s1 = "CodeGym is the best website for learning Java!";
        String s2 = new String("CODEGYM IS THE BEST WEBSITE FOR LEARNING JAVA!");
        System.out.println(s1.equals(s2));
    }
}
