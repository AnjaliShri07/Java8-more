package com.java8.programs.interview.array;

public class PairOfSongsWithTotalDurationDividedBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int[] remainderFreq = new int[60];
        int count = 0;

        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;

            count += remainderFreq[complement];
            remainderFreq[remainder]++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] time1 = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time1));  // Output: 3

        int[] time2 = {60, 60, 60};
        System.out.println(numPairsDivisibleBy60(time2));  // Output: 3
    }
}
