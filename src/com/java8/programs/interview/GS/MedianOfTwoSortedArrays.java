package com.java8.programs.interview.GS;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double logic(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }

        while (i < m) merged[k++] = A[i++];
        while (j < n) merged[k++] = B[j++];

        int total = m + n;
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }

    public static double logicJava8(int[] A, int[] B) {
        /*Creates a new array merged with a length equal to the total length of arrays A and B.
          Copies all elements of array A into the beginning of merged.*/
        int[] merged = Arrays.copyOf(A, A.length + B.length);

        /*Copies all elements of array B into merged, starting at position A.length.
        At this point, merged contains all elements from both A and B, but not yet sorted.*/
        System.arraycopy(B, 0, merged, A.length, B.length);

        Arrays.sort(merged); // Java 8 sorting

        int len = merged.length;
        if (len % 2 == 0) {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        } else {
            return merged[len / 2];
        }
    }

    public static boolean pass() {
        boolean result = true;
        result = result && logic(new int[]{1, 3}, new int[]{2}) == 2.0;
        result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && logic(new int[]{}, new int[]{1}) == 1.0;
        result = result && logic(new int[]{2}, new int[]{}) == 2.0;
        return result;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("pass");
        } else {
            System.out.println("some failures");
        }
    }
}
/* Problem Statement
Given two sorted arrays A and B, return the median of the two combined.

Examples:

A = {1, 3}, B = {2} → Combined: {1, 2, 3} → Median = 2
A = {1, 3}, B = {2, 4} → Combined: {1, 2, 3, 4} → Median = (2 + 3) / 2 = 2.5

✅ Optimal Approach (O(log(min(m, n))) time)
We'll implement a binary search partitioning method on the smaller array. But for now, let me give you the simpler
approach first, then follow up with the optimal one.
✅ Explanation:
Merging: Merge both sorted arrays like merge step in merge sort.

Finding Median:
If total number of elements is odd → return the middle element.
If even → return the average of the two middle elements.

⏱️ Time & Space Complexity:
Time: O(m + n)
Space: O(m + n) (due to merged array)*/