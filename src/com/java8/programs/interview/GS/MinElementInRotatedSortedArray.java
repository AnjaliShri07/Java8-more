package com.java8.programs.interview.GS;

public class MinElementInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum element is in the right half
                left = mid + 1;
            } else {
                // Minimum element is in the left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums1 = {3,4,5,6,1,2};
        int[] nums2 = {};
        int minElement = findMin(nums);
        System.out.println("The minimum element is: " + minElement);
        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
    }
}
