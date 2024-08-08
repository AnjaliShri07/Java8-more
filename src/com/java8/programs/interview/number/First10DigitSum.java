package com.java8.programs.interview.number;

import java.util.stream.IntStream;

public class First10DigitSum {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);
    }
}
