package com.java8.programs.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxResult {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 10, 9, 5, 7, 2, 4, 6);
       Integer maximum =  list.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maximum);
    }
}
