package com.java8.programs.interview.GS;

import java.util.HashSet;
import java.util.Set;

/**
 * You have an integer array.
 * Starting from arr[startIndex], follow each element to the index it points to.
 * Continue to do this until you find a cycle.
 * Return the length of the cycle. If no cycle is found return -1
 */
public class CountLengthOfCycle {
    public static int countLengthOfCycle(int[] arr, int startIndex) {
        Set<Integer> visitedIndices = new HashSet<>();
        int currentIndex = startIndex;
        int cycleLength = 0;

        while (!visitedIndices.contains(currentIndex)) {
            // If the index points to itself or an invalid index, return -1
            if (currentIndex < 0 || currentIndex >= arr.length) {
                // If the index goes out of bounds, return -1 (invalid input scenario)
                return -1;
            }
            // Add current index to visited set
            visitedIndices.add(currentIndex);
            currentIndex = arr[currentIndex]; // Move to the next index
            cycleLength++;

            // If the next index leads back to the starting index, we've found the cycle
            if (visitedIndices.contains(currentIndex)) {
                return cycleLength;
            }
        }

        return -1; // No cycle detected
    }

    public static void main(String[] args) {
        boolean testsPassed = true;

        // Test cases
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        if (testsPassed) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}

/*Explanation:
Set to Track Visited Indices:
We use a Set<Integer> to track the indices we have visited. This ensures that when we revisit an index, we know we've encountered a cycle.

While Loop:
The while loop continues until we reach an index that we've already visited, which indicates that we've found a cycle. We add each visited index to the set and move to the next index as per the value in the arr array.

Cycle Length Calculation:
As we traverse the array, we increment the cycleLength counter to track how many steps it takes until we detect the cycle.

Return Cycle Length:
If we detect a cycle, we return the cycleLength. If no cycle is detected, we return -1.
Why This Works:
Using a Set: We store all visited indices in a Set, which allows for constant time checks to see if an index has already been visited.

No Need for Streams: While Streams are good for processing sequences, this particular problem requires tracking state (i.e., which indices we've visited) and it doesn't lend itself well to the declarative style that Streams provide.

Time Complexity
Time complexity: O(n) where n is the number of elements in the array. Each index is visited at most once during the traversal.
Space complexity: O(n) due to the space used by the visited set, where n is the number of elements in the array.*/
