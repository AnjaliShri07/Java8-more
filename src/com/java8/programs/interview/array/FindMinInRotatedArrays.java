package com.java8.programs.interview.array;

/*Returns the smallest number in array that has been rotated
For example - Array {3,4,5,6,1,2} returns 1 Input array was originally sorted in increasing orders
FindMinInArray must have O(log n) runtime Input array does not have any duplicates
Signature: public static int FindMin(int a[]){ }*/
public class FindMinInRotatedArrays {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 1, 2};
        System.out.println("Minimum value: " + FindMin(arr)); // Output: 1
    }

    public static int FindMin(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] > a[right]) {
                // The minimum value is in the right part of the array
                left = mid + 1;
            } else {
                // The minimum value is in the left part of the array (including mid)
                right = mid;
            }
        }

        // At the end of the loop, left == right and points to the smallest element
        return a[left];
    }
}
