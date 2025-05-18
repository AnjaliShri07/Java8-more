package com.java8.programs.interview.GS;

public class DotProduct {
    /**
     * Given two arrays of integers, returns the dot product of the arrays
     */
    public static int dotProduct(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must be of the same length.");
        }

        int dotProduct = 0;
        for (int i = 0; i < array1.length; i++) {
            dotProduct += array1[i] * array2[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 2 };
        int[] array2 = { 2, 3 };

        int result = dotProduct(array1, array2);

        // Check if the result is 8 as expected
        if (result == 8) {
            System.out.println("Passed.");
        } else {
            System.out.println("Failed.");
        }
    }
}
/*The task is to compute the dot product of two arrays of integers. The dot product of two vectors (arrays) is the sum of the products of their corresponding elements.

Formula for Dot Product:
If you have two arrays array1 and array2, the dot product is computed as:
dot product=
i=0
∑
n−1
 array1[i]×array2[i]
Where n is the length of the arrays (both arrays should have the same length).

Example:
Given:
int[] array1 = { 1, 2 };
int[] array2 = { 2, 3 };
The dot product will be:

dot product=(1×2)+(2×3)=2+6=8
Plan:
Ensure that both arrays are of the same length.
For each index i, multiply the elements at array1[i] and array2[i], and sum the results.
Return the sum as the dot product.

Code Explanation:
Input: Two integer arrays, array1 and array2.

Process:
Multiply each element of array1 with the corresponding element of array2.
Sum up all the products.
Output: The dot product of the two arrays.*/

/*Explanation:
dotProduct function:
The function checks if the arrays array1 and array2 have the same length.
It initializes a variable dotProduct to 0, which will hold the sum of the products.
The loop runs over the length of the arrays, multiplying the corresponding elements and adding the results to dotProduct.

Main function:
We define the two arrays array1 and array2.
We call the dotProduct function and check if the result is 8 (the expected value).
If the result is correct, the program prints "Passed.", otherwise it prints "Failed.".

Example Walkthrough:
For arrays:

array1 = { 1, 2 }
array2 = { 2, 3 }
Multiply 1 * 2 = 2 and add it to dotProduct.
Multiply 2 * 3 = 6 and add it to dotProduct.
Final dot product is 2 + 6 = 8.*/