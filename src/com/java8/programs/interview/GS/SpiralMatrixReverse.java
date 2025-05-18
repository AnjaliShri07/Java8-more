package com.java8.programs.interview.GS;

public class SpiralMatrixReverse {
    // Function to print matrix in reverse spiral form using recursion
    public static void printReverseSpiral(int[][] matrix, int top, int bottom, int left, int right) {
        // Base case: if the boundaries are invalid, return
        if (top > bottom || left > right) {
            return;
        }

        // Print the bottom row from right to left
        for (int i = right; i >= left; i--) {
            System.out.print(matrix[bottom][i] + " ");
        }
        bottom--; // Move up to the previous row

        // Print the right column from bottom to top
        if (top <= bottom) { // Check to avoid double printing in case of a single row
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][right] + " ");
            }
            right--; // Move left to the previous column
        }

        // Print the top row from right to left
        if (left <= right) { // Check to avoid double printing in case of a single column
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[top][i] + " ");
            }
            top++; // Move down to the next row
        }

        // Print the left column from top to bottom
        if (top <= bottom) { // Check to avoid double printing in case of a single row
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][left] + " ");
            }
            left++; // Move right to the next column
        }

        // Recursively call the function to process the next inner rectangle
        printReverseSpiral(matrix, top, bottom, left, right);
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        int m = matrix.length;
        int n = matrix[0].length;

        // Start with the full boundary
        printReverseSpiral(matrix, 0, m - 1, 0, n - 1);
    }
}
/*Time Complexity:

The time complexity is O(m * n), where m is the number of rows and n is the number of columns in the matrix. We visit each element of the matrix exactly once during the recursion.

Space Complexity:

The space complexity is O(m + n) due to the recursive stack. In the worst case, the recursion depth is proportional to the smaller of the matrix dimensions (m or n).*/