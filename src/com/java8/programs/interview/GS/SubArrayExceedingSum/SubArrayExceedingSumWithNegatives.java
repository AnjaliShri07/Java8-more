package com.java8.programs.interview.GS.SubArrayExceedingSum;

public class SubArrayExceedingSumWithNegatives {
    public static int subArrayExceedsSum(int[] arr, int target) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum > target) {
                    minLen = Math.min(minLen, end - start + 1);
                    break; // optional optimization
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        boolean result = true;

        int[] arr1 = {1, 2, 3, 4};
        result = result && subArrayExceedsSum(arr1, 6) == 2;    // [3, 4]
        result = result && subArrayExceedsSum(arr1, 12) == -1;  // no subarray

        int[] arr2 = {2, -1, 2, 3, -4, 2};
        result = result && subArrayExceedsSum(arr2, 3) == 2;    // [2, -1, 2] or [2,3] etc.

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
