package com.java8.programs.interview.GS.SubArrayExceedingSum;

public class SubArrayExceedingSum {
    public static int subArrayExceedsSum(int[] arr, int target) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE; // Holds the smallest subarray length found
        int start = 0, end = 0; // Pointers for window (sliding window)
        int currentSum = 0;  // Tracks sum of current window

        //This keeps running until we've explored all possible subarrays using the sliding window.
        while (end < n) {
            // Expand the window
            //Keeps adding elements to currentSum while it's ≤ target.
            while (currentSum <= target && end < n) {
                currentSum += arr[end++];
            }

            // Shrink the window
            //When currentSum exceeds the target, we try to shrink the window from the left.
            //For each valid window, we check if its size (end - start) is smaller than the previous minLength.
            //Then, we reduce the window by subtracting the leftmost value.
            while (currentSum > target && start < n) {
                minLength = Math.min(minLength, end - start);
                currentSum -= arr[start++];
            }
        }

        //If we never found a valid subarray (i.e., minLength was never updated), return -1.
        //Otherwise, return the smallest valid window length found.
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        boolean result = true;
        int[] arr = { 1, 2, 3, 4 };

        result = result && subArrayExceedsSum(arr, 6) == 2;    // [3, 4]
        result = result && subArrayExceedsSum(arr, 12) == -1;  // no subarray

        if (result) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
}
/*🧠 Key Idea:
We use a sliding window to keep expanding the range until the sum exceeds the target.
Then, we shrink the window from the start to try and minimize its length.
✅ Solution: Sliding Window Approach (Efficient)
✔️ Time Complexity: O(n)
✔️ Space Complexity: O(1)*/