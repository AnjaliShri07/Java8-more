package com.java8.programs.interview.array;

import java.util.Arrays;
import java.util.*;
import java.util.stream.*;

public class SortBasedOnFrequency {

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 2, 8, 6, 6, 6, 4, 4, 4, 8, 8, 2};
        Arrays.stream(arr).collect(Collectors.groupingBy(n->n, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder()))
                .flatMap(e-> Collections.nCopies(e.getValue().intValue(), e.getKey()).stream())
                .toList().forEach(System.out::println);
    }
}
