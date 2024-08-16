package com.java8.programs.interview.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateLeft {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int n = 4; // Number of positions to rotate left

        List<Integer> rotatedList = rotateLeft(list, n);

        System.out.println(rotatedList); // Output: [3, 4, 5, 1, 2]
    }

    public static <T> List<T> rotateLeft(List<T> list, int n) {

        return Stream.concat(
                list.stream().skip(n),
                list.stream().limit(n)
        ).collect(Collectors.toList());
    }
}
