package com.java8.programs.interview.GS;

import java.util.stream.IntStream;

public class SecondSmallestInSortedRotatedArray {
    public static int findSecondSmallest(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        // Find the index of the pivot (smallest element) using binary search
        int pivot = findPivot(arr);

        // Create a new stream that combines the two parts of the rotated array
        int[] combined = new int[n];
        System.arraycopy(arr, pivot, combined, 0, n - pivot);
        System.arraycopy(arr, 0, combined, n - pivot, pivot);

        // Now, find the second-smallest element using streams
        return IntStream.of(combined)
                .distinct()  // Remove duplicates
                .sorted()    // Sort the array in ascending order
                .skip(1)     // Skip the smallest element
                .findFirst() // Get the second-smallest element
                .orElseThrow(() -> new RuntimeException("Array doesn't have enough elements"));
    }

    // Method to find the pivot (index of the smallest element)
    public static int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the pivot
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] >= arr[low]) {
                // Left side is sorted, so pivot is on the right
                low = mid + 1;
            } else {
                // Right side is sorted, so pivot is on the left
                high = mid - 1;
            }
        }

        // If no rotation is found, the array is not rotated, return 0 (first element)
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int secondSmallest = findSecondSmallest(arr);
        System.out.println("Second smallest element is: " + secondSmallest);
    }
}
