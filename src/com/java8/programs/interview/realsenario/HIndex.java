package com.java8.programs.interview.realsenario;

import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);  // Sort in ascending order
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // number of papers with citations >= citations[i]
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations1));  // Output: 3

        int[] citations2 = {1, 3, 1};
        System.out.println(hIndex(citations2));  // Output: 1
    }
}
