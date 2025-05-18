package com.java8.programs.interview.GS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 * Given the arrival and departure times of all trains that reach a railway station, the task
 * is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays that represent the arrival and departure times of trains that stop.
 *
 * Examples:
 *
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)
 *
 * Input: arr[] = {9:00, 9:40}
 * dep[] = {9:10, 12:00}
 * Output: 1
 * Explanation: Only one platform is needed.
 *
 */
/*✅ Approach (Efficient: O(n log n)):
Sort the arrival and departure times.
This approach uses sorting and two-pointer to reduce the complexity.
First, we sort the arrival and departure times of all trains. Then, using two pointers, we traverse through both arrays.
Keep track of the count of platforms needed at a time.
Update the result if the current platform requirement exceeds the previous maximum.*/

public class TrainPlatformScheduler {
    // Converts time in "HH:mm" format to minutes since midnight
    private static int toMinutes(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse(time);
        return date.getHours() * 60 + date.getMinutes();
    }

    // Main logic to find minimum platforms required
    public static int findMinimumPlatforms(String[] arrival, String[] departure) throws ParseException {
        int n = arrival.length;
        int[] arr = new int[n];
        int[] dep = new int[n];

        // Convert times to minutes
        for (int i = 0; i < n; i++) {
            arr[i] = toMinutes(arrival[i]);
            dep[i] = toMinutes(departure[i]);
        }

        // Sort both arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++; // A train has arrived
                i++;
            } else {
                platforms--; // A train has departed
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) throws ParseException {
        String[] arrival1 = {"09:00", "09:40", "09:50", "11:00", "15:00", "18:00"};
        String[] departure1 = {"09:10", "12:00", "11:20", "11:30", "19:00", "20:00"};

        String[] arrival2 = {"09:00", "09:40"};
        String[] departure2 = {"09:10", "12:00"};

        System.out.println("Minimum platforms needed (Test 1): " + findMinimumPlatforms(arrival1, departure1)); // Output: 3
        System.out.println("Minimum platforms needed (Test 2): " + findMinimumPlatforms(arrival2, departure2)); // Output: 1
    }
}
/*📊 Time & Space Complexity:
Complexity	Value
Time	O(n log n)
Space	O(n)*/