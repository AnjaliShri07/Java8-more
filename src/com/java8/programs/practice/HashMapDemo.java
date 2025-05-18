package com.java8.programs.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapDemo {
    public static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int n : arr) {
            if (i < 2 || n != arr[i - 2]) {
                arr[i++] = n;
            }
        }
        return i;
    } //time - O(n), space- O(1)
    
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 1, 1, 2, 2, 3, 3);
        int[] arr = {1, 1, 1, 2, 2, 3, 3};

        List<Integer> result = input.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.toList()))
                .values()
                .stream()
                .flatMap(list -> list.stream().limit(2))  // limit each group to at most 2
                .collect(Collectors.toList());

        System.out.println(result);  // Output: [1, 1, 2, 2, 3, 3]
        System.out.println("size of array: "+result.size());
        System.out.println("Using for loop: "+removeDuplicates(arr));

    }//time - O(n), space- O(n)
}
