package com.java8.programs.interview.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        //result holds the final sliding window max values.
        //deque will store indices of nums.
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // If the front of the deque is outside the current window, remove it.
            //i - k gives the left boundary of the current window.
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                System.out.println("deque.peekFirst() ==> "+deque.peekFirst());
                System.out.println("deque.pollFirst() ==> "+deque.pollFirst());
                deque.pollFirst();
            }

            // Remove indices whose values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                System.out.println("deque.pollLast() ==> "+deque.pollLast());
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Add to result once first window is hit
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // Output: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2))); // Output: [1]
    }
}
