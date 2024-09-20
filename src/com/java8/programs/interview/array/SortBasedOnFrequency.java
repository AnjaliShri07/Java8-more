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
/*
Explanation:
groupingBy: Group elements and count their occurrences.
sorted: Sort based on frequency in descending order.
        flatMap: Replicate each element according to its frequency to preserve the original structure.
collect: Convert the stream back into a list.
nCopies: It generates the output based on how often the element appears.
*/
