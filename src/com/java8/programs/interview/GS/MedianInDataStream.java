package com.java8.programs.interview.GS;/*Given that integers are read from a data stream. Find median of elements read so
   for in an efficient way. For simplicity assume, there are no duplicates. For example,
   let us consider the stream 5, 15, 1, 3 …

   After reading 1st element of stream - 5 -> median - 5
   After reading 2nd element of stream - 5, 15 -> median - 10
   After reading 3rd element of stream - 5, 15, 1 -> median - 5
   After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...  */

import java.util.Collections;
import java.util.PriorityQueue;

/*Concept:
Max Heap (lowers) → stores the lower half of numbers.
Min Heap (highers) → stores the higher half of numbers.
The median:
If both heaps have the same size → average of tops of both heaps.
If uneven → top of the larger heap.*/
public class MedianInDataStream {
    // Max Heap for the lower half
    private PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap for the higher half
    private PriorityQueue<Integer> highers = new PriorityQueue<>();

    // Function to add number to the correct heap
    public void addNumber(int number) {
        if (lowers.isEmpty() || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }

        // Rebalance heaps if needed
        rebalanceHeaps();
    }

    // Rebalance the two heaps to make sure their size difference is at most 1
    private void rebalanceHeaps() {
        if (lowers.size() > highers.size() + 1) {
            highers.add(lowers.poll());
        } else if (highers.size() > lowers.size() + 1) {
            lowers.add(highers.poll());
        }
    }

    // Get current median
    public double getMedian() {
        if (lowers.size() == highers.size()) {
            return (lowers.peek() + highers.peek()) / 2.0;
        } else if (lowers.size() > highers.size()) {
            return lowers.peek();
        } else {
            return highers.peek();
        }
    }

    public static void main(String[] args) {
        MedianInDataStream medianFinder = new MedianInDataStream();

        int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        for (int num : stream) {
            medianFinder.addNumber(num);
            System.out.println("After reading " + num + ", current median: " + medianFinder.getMedian());
        }
    }
}
/*📊 Time and Space Complexity:
Operation	Complexity
Insertion	O(log n)
Get Median	O(1)
Space	O(n)*/