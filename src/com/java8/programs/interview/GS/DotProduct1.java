package com.java8.programs.interview.GS;

public class DotProduct1 {
    // Function to calculate the dot product of two arrays
    public static int calculateDotProduct(int[] array1, int[] array2) {
        // Find the minimum length of the two arrays
        int minLength = Math.min(array1.length, array2.length);
        int dotProduct = 0;

        // Calculate the dot product by iterating up to the minimum length
        for (int i = 0; i < minLength; i++) {
            dotProduct += array1[i] * array2[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        // Example arrays
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7};

        // Calculate and print the dot product
        int result = calculateDotProduct(array1, array2);
        System.out.println("The dot product is: " + result); // Output: 38
    }
}
