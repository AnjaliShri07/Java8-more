package com.java8.programs.interview.array;

import java.util.*;

public class Median {
    public static int findMedianStream(List<Integer> arr) {
        List<Integer> sortedList = arr.stream()
                .sorted()
                .toList();
        int n = sortedList.size();
        if (n % 2 == 0) {
            return (int) ((sortedList.get(n / 2 - 1) + sortedList.get(n / 2)) / 2.0);
        } else {
            return sortedList.get(n / 2);
        }
    }
    public static void main(String[] args){
        List<Integer> numList = Arrays.asList(3, 1, 4, 2, 5);
        System.out.println(findMedianStream(numList));
    }
}
