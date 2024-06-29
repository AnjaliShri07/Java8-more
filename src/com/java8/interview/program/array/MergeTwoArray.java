package com.java8.interview.program.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};

        // Merge two arrays using Streams
        int[] mergedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray();

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }
}
