package com.java8.programs.interview.GS;

import java.util.ArrayList;
import java.util.List;

/** There are n dwarfs A{n} -> A{i} is height of dwarf where all A{i} are positive and distinct.
 * You are making a sequence of moves to arrange them in a sequence. During each move you must take either the leftmost
 * dwarf or the rightmost dwarf and add him to the end of the sequence.
 * Arrange these dwarfs in a strictly increasing sequence (in terms of height), and among all such sequences you should
 * take the longest (the length of the sequence is the number of dwarfs in it).
 No duplicates
 * e.g.- for the 5 dwarfs sequence [2,1,5,4,3] the answer is 4 (you take 2 and the sequence becomes [1,5,4,3],
 * then you take the rightmost element 3 and the sequence becomes [1,5,4], then you take 4 and the sequence becomes [1,5]
 * and then you take 5 and the sequence becomes [1], the obtained increasing sequence is [2,3,4,5]).*/
public class DwarfSequence {
    public static int findLongestIncreasingSequence(int[] dwarfs) {
        int left = 0;
        int right = dwarfs.length - 1;
        List<Integer> sequence = new ArrayList<>();

        while (left <= right) {
            if (sequence.isEmpty() || dwarfs[left] < dwarfs[right]) {
                if (sequence.isEmpty() || dwarfs[left] > sequence.get(sequence.size() - 1)) {
                    sequence.add(dwarfs[left]);
                }
                left++;
            } else {
                if (sequence.isEmpty() || dwarfs[right] > sequence.get(sequence.size() - 1)) {
                    sequence.add(dwarfs[right]);
                }
                right--;
            }
        }

        return sequence.size();
    }

    public static void main(String[] args) {
        int[] dwarfs = {2, 1, 5, 4, 3};
        int result = findLongestIncreasingSequence(dwarfs);
        System.out.println("The length of the longest increasing sequence is: " + result);

        // Additional test cases
        int[] test1 = {1, 3, 2, 4, 5};
        int[] test2 = {5, 4, 3, 2, 1};
        int[] test3 = {1, 2, 3, 4, 5};
        int[] test4 = {3, 1, 4, 2, 5};

        System.out.println("Test case 1: " + findLongestIncreasingSequence(test1)); // Expected: 5
        System.out.println("Test case 2: " + findLongestIncreasingSequence(test2)); // Expected: 1
        System.out.println("Test case 3: " + findLongestIncreasingSequence(test3)); // Expected: 5
        System.out.println("Test case 4: " + findLongestIncreasingSequence(test4)); // Expected: 4
    }
}
