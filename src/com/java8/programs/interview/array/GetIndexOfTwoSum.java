package com.java8.programs.interview.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetIndexOfTwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If found, return the indices of the current number and the complement
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            // Otherwise, add the current number and its index to the map
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
