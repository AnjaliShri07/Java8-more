package com.java8.programs.interview.tricky.Strings;

public class Demo4 {
    public static void main(String[] args) {
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        String s3 = null;
        System.out.println(s1.equals(s2));
        //System.out.println(s1 == s2);
        System.out.println(s1.contentEquals(s2));
        System.out.println(s3.equals(s2));
    }
}
