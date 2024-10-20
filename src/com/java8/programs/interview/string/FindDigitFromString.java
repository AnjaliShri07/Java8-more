package com.java8.programs.interview.string;

import java.util.Arrays;

public class FindDigitFromString {
    public static void main(String[] args) {
        String str= "swuif1289ul23";
        Arrays.stream(str.split("\\D+"))
                .filter(s-> !s.isEmpty()).map(Integer :: parseInt)
                .forEach(System.out::println);
    }
}
