package com.java8.programs.interview.array;

import java.util.*;
import java.util.stream.Collectors;

public class SeperateOddEven {
    public static void main(String[] args) {
        Integer[] arr = {1, 43, 15, 66, 87, 89, -9, -10, 22, 34, -23, 89, 54, 34};
        Map<Boolean, List<Integer>> oddEven = Arrays.stream(arr).collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(oddEven);
    }
}
