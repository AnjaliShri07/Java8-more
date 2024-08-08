package com.java8.programs.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 9, 2, 8, 10, 1);
        Integer secondHighest = numbers.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("secondHighest: "+ secondHighest);

        Integer thirdHighest = numbers.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(-1);
        System.out.println("thirdHighest: "+ thirdHighest);
    }
}
