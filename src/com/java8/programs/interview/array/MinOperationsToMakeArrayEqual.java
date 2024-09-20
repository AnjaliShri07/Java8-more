package com.java8.programs.interview.array;

import java.util.Arrays;

/*You are given an array 'ARR' of 'N' positive integers. You need to find the minimum number of operations needed to make
all elements of the array equal.
You can perform addition, multiplication, subtraction or division with any element on an array element.
Addition, Subtraction, Multiplication or Division on any element of the array will be considered as a single operation.
Example:
If the given array is [1,2,3] then the answer would be 2. One of the ways to make all the elements of the given
array equal is by adding 1 to the array element with value 1 and subtracting 1 from the array element with value 3.
So that final array would become [2,2,2].*/
public class MinOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int result = minOperations(arr);
        System.out.println("Minimum operations needed: " + result);
    }

    public static int minOperations(int[] arr) {
        // Step 1: Find the median element
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        int median = sortedArr[sortedArr.length / 2];

        // Step 2: Calculate the total operations required to make all elements equal to the median
        int operations = Arrays.stream(arr)
                .map(a -> Math.abs(a - median))
                .sum();

        return operations;
    }
}
