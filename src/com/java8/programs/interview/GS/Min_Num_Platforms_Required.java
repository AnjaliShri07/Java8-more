package com.java8.programs.interview.GS;

import java.util.Arrays;

public class Min_Num_Platforms_Required {

    public static int findPlatform(int arr[], int dep[]) {
        // First sort arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 1, maxPlatforms = 1;
        int i = 1, j = 0;
        int n = arr.length;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformsNeeded++; // A train is arriving before the previous one departs
                i++;
            } else {
                platformsNeeded--; // A train departs, so free a platform
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        int arr1[] = {900, 940};
        int dep1[] = {910, 1200};

        if (findPlatform(arr, dep) == 3 && findPlatform(arr1, dep1) == 1)
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }
}
/*🧠 Time & Space Complexity:
Time Complexity: O(n log n) – for sorting the arrays.
Space Complexity: O(1) – no extra space used beyond variables.*/