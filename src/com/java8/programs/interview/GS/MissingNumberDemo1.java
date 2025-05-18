package com.java8.programs.interview.GS;

import java.util.HashSet;
import java.util.Set;

/*Given an unsorted integer array nums. Return the smallest positive integer that is not
present in nums. [7,8,9,11,12] o/p: 1*/
public class MissingNumberDemo1 {
    public static int findSmallestMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index position
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where the number is not correct
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers are in their correct positions, return n + 1
        return n + 1;
    }

    public static int findSmallestMissingPositiveUsingSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                numSet.add(num);
            }
        }

        int smallestMissingPositive = 1;
        while (numSet.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        return smallestMissingPositive;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println("The smallest missing positive integer is: " + findSmallestMissingPositive(nums));
        int[] arr = new int[] { 0, 0, 1, 2, 3, 4, 5 };  //6
        int[] arr2 = new int[] { -1, 1, -2, -3, 4, 5 }; // 2 - failing
        int[] arr3 = new int[] { 5, 1, 2, 10, 3 }; // 4

        System.out.println(findSmallestMissingPositiveUsingSet(arr));
        System.out.println(findSmallestMissingPositiveUsingSet(arr2));
        System.out.println(findSmallestMissingPositiveUsingSet(arr3));

    }
}
