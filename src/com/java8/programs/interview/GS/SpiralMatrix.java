package com.java8.programs.interview.GS;

import java.util.ArrayList;
import java.util.List;

/*Approach
Initialize Variables: Create variables to keep track of the boundaries of the matrix (top, bottom, left, right).
Iterate in Spiral Order: Use a loop to traverse the matrix in a spiral order:
Traverse from left to right along the top row.
Traverse from top to bottom along the right column.
Traverse from right to left along the bottom row.
Traverse from bottom to top along the left column.
Update Boundaries: After each traversal, update the boundaries to move inward.
Stream Operations: Use Java 8 streams to collect the elements in the desired order.

Steps
Initialize four boundaries: top, bottom, left, and right.
Use a loop to traverse the matrix in the spiral order, adjusting the boundaries after each pass (right, down, left, up).
Collect the results in a list and then print them using Java 8 streams.*/
public class SpiralMatrix {

    public static List<Integer> getSpiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> spiralOrder = getSpiralOrder(matrix);

        // Print the result using streams
        spiralOrder.stream().forEach(num -> System.out.print(num + " "));
    }
}
/*Explanation
Input Matrix: The input matrix is a 2D array. For example, {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.

Boundaries: We initialize four boundary variables:
top: Initially 0.
bottom: Initially the last row of the matrix (matrix.length - 1).
left: Initially 0.
right: Initially the last column of the matrix (matrix[0].length - 1).

Spiral Traversal Logic:
First, traverse from left to right across the top row, then move the top boundary down.
Next, traverse from top to bottom along the right column, then move the right boundary left.
If still within bounds, traverse from right to left along the bottom row, then move the bottom boundary up.
Finally, if still within bounds, traverse from bottom to top along the left column, then move the left boundary right.
Repeat this process until all elements are traversed.
Using Java 8 Streams: We collect the results in a List<Integer>, and then use the stream() method to print the results in a space-separated format.

Time Complexity
Traversal Complexity: The matrix has m rows and n columns. The spiral traversal visits every element of the matrix exactly once. Hence, the time complexity is O(m * n).
Stream Complexity: Collecting and printing using streams takes linear time in the number of elements, so it is O(m * n) as well.*/