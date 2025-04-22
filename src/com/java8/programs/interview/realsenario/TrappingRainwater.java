package com.java8.programs.interview.realsenario;
/* Trapping Rainwater Problem - Given an array of n non-negative integers arr[] representing an elevation
map where the width of each bar is 1, compute how much water it can trap after rain
Input: arr[] = {3, 0, 1, 0, 4, 0, 2}
Output: 10
*/
public class TrappingRainwater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left <= right) {
            System.out.println("height[left] ==> "+ height[left]);
            System.out.println("height[right] ==> "+height[right]);
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                    System.out.println("leftMax ==> "+leftMax);
                } else {
                    waterTrapped += leftMax - height[left];
                    System.out.println("left waterTrapped ==> "+ waterTrapped);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                    System.out.println("rightMax ==> "+rightMax);
                } else {
                    waterTrapped += rightMax - height[right];
                    System.out.println("right waterTrapped ==>"+ waterTrapped);
                }
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {3, 0, 1, 0, 4, 0, 2}; //{1, 2, 3, 4} // {1,2,3,4}
        int water = trap(height);
        System.out.println("The amount of water trapped is: " + water);
    }
}
