package com.java8.programs.interview.GS;

import java.util.Arrays;
import java.util.Comparator;

/*To solve the problem of arranging a given list of numbers to form the largest number possible,
the challenge lies in comparing how to arrange two numbers in a way that their concatenation results in a larger number.
The key observation is that the number formed by concatenating two numbers should be compared in two possible orders:
ab and ba, where a and b are two numbers. We should choose the order that results in the larger number.

Steps to Approach:
Custom Comparison Logic: We need a custom comparator to compare two numbers a and b:

Convert the numbers to strings.
Compare the concatenation of a + b with b + a. If a + b is greater, a should come before b in the final arrangement.
Sorting: Once the custom comparison logic is defined, sort the list of numbers using this logic to arrange them in the desired order.
Edge Case: If the result of the sorting contains leading zeros (e.g., all numbers are zeros), the result should be just 0.*/
public class LargestNumber {
    // Custom comparator to decide the order of numbers
    public static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            // Compare concatenated strings a+b and b+a
            return (b + a).compareTo(a + b);
        }
    }

    // Function to arrange numbers in a way that forms the largest number
    public static String largestNumber(int[] nums) {
        // Convert integer array to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the string array using the custom comparator
        Arrays.sort(strNums, new CustomComparator());

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join all the numbers to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 34, 3, 98, 9, 76, 45, 4};
        String result = largestNumber(nums);
        System.out.println("The largest number formed is: " + result);
    }
}
/*Explanation of the Code:
Custom Comparator:
The CustomComparator compares two numbers a and b by checking which concatenated string (a + b or b + a) is larger.
If a + b is greater, a should come before b. Otherwise, b should come before a.

Sorting:
We convert the integer array to a string array for easier comparison of concatenated numbers.
The Arrays.sort() method is used with our custom comparator to sort the string numbers in the order that maximizes the final number.

Handling Edge Case:
If the largest number in the sorted array is 0, it means that all the numbers are 0, so we simply return "0".

Building the Result:
The sorted strings are concatenated using StringBuilder to form the final largest number.

Example Walkthrough:
For the input: {1, 34, 3, 98, 9, 76, 45, 4}, the sorting process works as follows:
After applying the custom comparator, the sorted array of strings will be: {"9", "98", "76", "45", "4", "34", "3", "1"}.
When concatenated, they form the string "998764543431", which is the largest number possible.

Output:
The largest number formed is: 998764543431
Time and Space Complexity:
Time Complexity:

Sorting the numbers takes
𝑂
(
𝑛
log
⁡
𝑛
)
O(nlogn), where
𝑛
n is the number of numbers in the list.

Comparing two numbers involves concatenating two strings, which can take
𝑂
(
𝑘
)
O(k), where
𝑘
k is the maximum length of the numbers as strings. Therefore, the overall time complexity is
𝑂
(
𝑛
log
⁡
𝑛
⋅
𝑘
)
O(nlogn⋅k), where
𝑛
n is the number of elements and
𝑘
k is the average length of the numbers.

Space Complexity:

We store the numbers as strings in the strNums array, so the space complexity is
𝑂
(
𝑛
)
O(n), where
𝑛
n is the number of elements in the array.*/