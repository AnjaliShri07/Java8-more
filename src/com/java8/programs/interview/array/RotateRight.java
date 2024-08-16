package com.java8.programs.interview.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateRight {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
        int n = 4; // Number of positions to rotate right

        List<Integer> rotatedList = rotateRight(list, n);

        System.out.println(rotatedList); // Output: [4, 5, 1, 2, 3]
    }

    public static <T> List<T> rotateRight(List<T> list, int n) {
             return Stream.concat(
                list.stream().skip(n-1),
                list.stream().limit(n)
        ).collect(Collectors.toList());
    }
}
