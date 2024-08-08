package com.java8.programs.interview.number;

import java.util.stream.IntStream;

public class FindSumOfFirstFiveOdd {
    public static void main(String[] args) {
        int sum = IntStream.iterate(1, n -> n + 2)
                .limit(5)
                .sum();
        System.out.println(sum);
    }
}
