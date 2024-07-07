package com.java8.programs.practice;

import java.util.Arrays;

public class SortAndConvertIntoStream {
    public static void main(String[] args) {
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
