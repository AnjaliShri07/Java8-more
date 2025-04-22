import com.java8.programs.learning.SecondHighest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
Q2. Trapping Rainwater Problem - Given an array of n non-negative integers arr[] representing an elevation map
where the width of each bar is 1, compute how much water it can trap after rain

Input: arr[] = {3, 0, 1, 0, 4, 0, 2}
Output: 10
Explanation: The expected rainwater to be trapped is shown in the above image.
*/


public class Main {
    public static int trapWater(int[] height){

        if(height == null || height.length == 0)
            return 0;

        int left=0;
        int right = height.length -1;

        int leftMax =0;
        int rightMax= 0;
        int result = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    result +=leftMax- height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    result+=rightMax - height[right];
                }
                right--;
            }

        }
        return result;

    }

      public static void main(String[] args) {

          int arr[] = {1, 2, 3, 4};
          System.out.println(trapWater(arr));

    }
}


