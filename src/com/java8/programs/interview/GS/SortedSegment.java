package com.java8.programs.interview.GS;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a jumbled collection of segments, each of which is represented as
 * a Pair(startPoint, endPoint), this function sorts the segments to
 * make a continuous path.
 *
 * A few assumptions you can make:
 * 1. Each particular segment goes in one direction only, i.e.: if you
 * see (1, 2), you will not see (2, 1).
 * 2. Each starting point only have one way to the end point, i.e.: if
 * you see (6, 5), you will not see (6, 10), (6, 3), etc.
 *
 * For example, if you're passed a list containing the following int arrays:
 *      [(4, 5), (9, 4), (5, 1), (11, 9)]
 * Then your implementation should sort it such:
 *      [(11, 9), (9, 4), (4, 5), (5, 1)]
 *
 * @param segments collection of segments, each represented by a Pair(startPoint, endPoint).
 * @return The sorted segments such that they form a continuous path.
 * @throws Exception if there is no way to create one continuous path from
 *          all the segments passed into this function. Feel free to change the
 *          Exception type as you think appropriate.
 */


public class SortedSegment {
    // Custom Pair class
    static class ImmutablePair<L, R> {
        private final L left;
        private final R right;

        public ImmutablePair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            ImmutablePair<?, ?> other = (ImmutablePair<?, ?>) obj;
            return Objects.equals(left, other.left) && Objects.equals(right, other.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
    /**
     * Given a list of segments (each as a Pair of integers), sort them into
     * a continuous path.
     */
    public static List<ImmutablePair<Integer, Integer>> sortSegments(List<ImmutablePair<Integer, Integer>> segments)
            throws Exception {
        if (segments == null || segments.isEmpty()) {
            return Collections.emptyList();
        }

        // Validate and prepare lookup maps
        Map<Integer, ImmutablePair<Integer, Integer>> startMap = new HashMap<>();
        Map<Integer, ImmutablePair<Integer, Integer>> endMap = new HashMap<>();

        for (ImmutablePair<Integer, Integer> segment : segments) {
            if (startMap.containsKey(segment.getLeft())) {
                throw new Exception("Duplicate start point found: " + segment.getLeft());
            }
            if (endMap.containsKey(segment.getRight())) {
                throw new Exception("Duplicate end point found: " + segment.getRight());
            }
            startMap.put(segment.getLeft(), segment);
            endMap.put(segment.getRight(), segment);
        }

        // Find the true starting point (not appearing as any segment's end)
        Integer start = startMap.keySet().stream()
                .filter(s -> !endMap.containsKey(s))
                .findFirst()
                .orElseThrow(() -> new Exception("No valid starting point found"));

        // Traverse the path from start
        List<ImmutablePair<Integer, Integer>> sorted = new ArrayList<>();
        while (startMap.containsKey(start)) {
            ImmutablePair<Integer, Integer> segment = startMap.get(start);
            sorted.add(segment);
            start = segment.getRight();
        }

        if (sorted.size() != segments.size()) {
            throw new Exception("Could not use all segments to form a continuous path");
        }

        return sorted;
    }

    public static void main(String[] args) {
        try {
            // Example jumbled segments forming a valid continuous path
            List<ImmutablePair<Integer, Integer>> jumbledSegments = List.of(
                    new ImmutablePair<>(4, 5),
                    new ImmutablePair<>(9, 4),
                    new ImmutablePair<>(5, 1),
                    new ImmutablePair<>(11, 9)
            );

            // Sort the segments
            List<ImmutablePair<Integer, Integer>> sortedPath = sortSegments(jumbledSegments);

            // Print the sorted path
            System.out.println("Sorted path:");
            sortedPath.forEach(segment -> System.out.println(segment.getLeft() + " -> " + segment.getRight()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
