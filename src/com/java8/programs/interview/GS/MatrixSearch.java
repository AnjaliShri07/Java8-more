package com.java8.programs.interview.GS;
/*) find a target value under 2D matrix using optimized way.
I have solved in optimized way and interviewer was agree after running test cases
/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix
matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Input: matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},
target = 5
Output: true
Input: matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},
target = 20
Output: false*/
public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            } else if (current > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target1 = 5;
        int target2 = 20;

        System.out.println("Target " + target1 + ": " + searchMatrix(matrix, target1)); // true
        System.out.println("Target " + target2 + ": " + searchMatrix(matrix, target2)); // false

        System.out.println(searchMatrix(new int[][]{}, 1)); // false (empty matrix)
        System.out.println(searchMatrix(new int[][]{{}}, 1)); // false (matrix with empty row)
        System.out.println(searchMatrix(new int[][]{{1}}, 1)); // true (single element match)
        System.out.println(searchMatrix(new int[][]{{1}}, 2)); // false (single element no match)
        System.out.println(searchMatrix(new int[][]{{1, 3, 5}}, 3)); // true (single row)
        System.out.println(searchMatrix(new int[][]{{1}, {3}, {5}}, 3)); // true (single column)


        int[][] matrix1 = {
                 {-10, -5, 0, 3},
                 {-8, -3, 1, 5},
                 {-6, -2, 2, 6},
                 {-4, 0, 4, 8}
                };

        System.out.println(searchMatrix(matrix1, -3)); // true
        System.out.println(searchMatrix(matrix1, 7)); // false
        System.out.println(searchMatrix(matrix1, -11)); // false


    }
}
