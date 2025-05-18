package com.java8.programs.interview.GS;

import java.util.Arrays;

/*Given an integer array do the following:
	a. distribute 0's equally to start and end of array
	b. after that even numbers should follow odd number
	c. first and second largest, first and second smallest
	i/p = [1,2,3,5,4,7,0,0]
o/p = [0, 2, 4, 1, 3, 5, 7, 0] 7, 5, 0, 1*/
public class ArrayManipulation {
    public static int[] distributeZeros(int[] arr) {
        int zeroCount = 0;
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int[] result = new int[arr.length];
        int start = zeroCount / 2;


        int index = start;
        for (int num : arr) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    public static int[] arrangeEvenOdd(int[] arr) {
        int[] result = new int[arr.length];
        int oddIndex = 0;
        int evenIndex = arr.length - 1;

        for (int num : arr) {
            if (num % 2 == 0) {
                result[evenIndex--] = num;
            } else {
                result[oddIndex++] = num;
            }
        }

        return result;
    }

    public static void findExtremes(int[] arr) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }

            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if (num < secondSmallest && num != firstSmallest) {
                secondSmallest = num;
            }
        }

        System.out.println("First Largest: " + firstLargest);
        System.out.println("Second Largest: " + secondLargest);
        System.out.println("First Smallest: " + firstSmallest);
        System.out.println("Second Smallest: " + secondSmallest);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4,7,0,0};

        // Step 1: Distribute 0's equally to start and end of array
        arr = distributeZeros(arr);
        System.out.println("After distributing zeros: " + Arrays.toString(arr));

        // Step 2: Arrange even numbers to follow odd numbers
        arr = arrangeEvenOdd(arr);
        System.out.println("After arranging even and odd: " + Arrays.toString(arr));

        // Step 3: Find the first and second largest, and the first and second smallest numbers
        findExtremes(arr);
    }
}
