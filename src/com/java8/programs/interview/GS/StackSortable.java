package com.java8.programs.interview.GS;

import java.util.Stack;
//Check if an array is stack sortable. An array A[] is said to be stack sortable if it can be stored in another array B[],
// using a temporary stack S.
public class StackSortable {
    // Function to check if the array is stack sortable
    public static boolean isStackSortable(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;  // Pointer for A[]
        int j = 0;  // Pointer for B[]

        // Traverse through A[]
        while (i < A.length) {
            // Push elements from A[] to the stack
            stack.push(A[i]);
            i++;

            // Pop from the stack while the top of the stack matches the current element in B[]
            while (!stack.isEmpty() && stack.peek() == B[j]) {
                stack.pop();
                j++;
            }
        }

        // If we have successfully processed all elements in B[], return true
        return j == B.length;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {4, 5, 3, 2, 1};

        if (isStackSortable(A, B)) {
            System.out.println("The array is stack sortable.");
        } else {
            System.out.println("The array is not stack sortable.");
        }
    }
}
