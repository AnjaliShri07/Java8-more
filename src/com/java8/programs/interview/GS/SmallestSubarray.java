package com.java8.programs.interview.GS;

/* Problem : Find the smallest subarray whose sum is equal or greater than the target value
Approach:
Sliding Window Technique:
We maintain a window (or subarray) and expand it by adding elements to the window.
As soon as the sum of the window is greater than or equal to the target, we try to shrink the window from the left side to make the window smaller while still maintaining the sum greater than or equal to the target.

Steps:
Initialize two pointers: left and right. Both pointers start from the beginning of the array.
Expand the window by moving the right pointer and adding the elements to the currentSum.
Whenever the sum is greater than or equal to the target, try to minimize the window by moving the left pointer forward and reducing the window size while maintaining the sum condition.
Track the smallest window that satisfies the sum condition.

Edge Case:
If no subarray satisfies the condition, return 0 (or any suitable message indicating that no solution exists).*/
public class SmallestSubarray {
    // Function to find the smallest subarray with sum >= target
    public static int smallestSubarrayWithSum(int[] nums, int target) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;  // To track the minimum length of subarray
        int currentSum = 0;  // To store the current sum of the window
        int left = 0;  // Left pointer of the window

        // Traverse the array with the right pointer
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];  // Add the current element to the sum

            // Shrink the window from the left as much as possible while maintaining the sum >= target
            while (currentSum >= target) {
                // Update the minimum length if we found a smaller subarray
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];  // Subtract the element at the left pointer
                left++;  // Shrink the window by moving the left pointer
            }
        }

        // If we found a valid subarray, return the smallest length, otherwise return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = smallestSubarrayWithSum(nums, target);
        if (result != 0) {
            System.out.println("The smallest subarray length is: " + result);
        } else {
            System.out.println("No subarray found with sum >= " + target);
        }
    }
}
