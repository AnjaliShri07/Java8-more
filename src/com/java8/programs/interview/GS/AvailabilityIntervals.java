package com.java8.programs.interview.GS;

import java.util.*;

/*You are given the availability of multiple people in the form of time intervals. Each person is available during a
specific time range. Write a program to split the time intervals into smaller sub-intervals and determine who is
available during each sub-interval.
Example Input:
Person p1 is available from 10 to 15.
Person p2 is available from 12 to 16.
Expected Output:
10 to 12 -> p1
12 to 15 -> p1 and p2
15 to 16 -> p2
*/
/*To solve the problem of splitting time intervals into smaller sub-intervals and determining who is available during
each sub-interval, we can follow these steps:

Collect all time intervals and sort them.
Identify all unique time points where availability changes.
Create sub-intervals between these time points.
Determine availability for each sub-interval.
Approach
Collect and Sort Time Intervals:

Extract all start and end times from the given intervals.
Sort these times to identify the points where availability changes.
Create Sub-Intervals:

Iterate through the sorted time points to create sub-intervals.
For each sub-interval, determine which persons are available.
Determine Availability:

For each sub-interval, check which persons are available based on their original intervals.
Time Complexity and Space Complexity
Time Complexity: O(n log n) due to sorting the time points, where n is the number of intervals.
Space Complexity: O(n) for storing the time points and intervals.*/
public class AvailabilityIntervals {

    public static List<SubInterval> splitIntervals(List<Interval> intervals) {
        Set<Integer> timePoints = new TreeSet<>();
        for (Interval interval : intervals) {
            timePoints.add(interval.start);
            timePoints.add(interval.end);
        }

        List<SubInterval> subIntervals = new ArrayList<>();
        Integer[] sortedTimePoints = timePoints.toArray(new Integer[0]);

        for (int i = 0; i < sortedTimePoints.length - 1; i++) {
            int start = sortedTimePoints[i];
            int end = sortedTimePoints[i + 1];
            Set<String> availablePersons = new HashSet<>();

            for (Interval interval : intervals) {
                if (interval.start <= start && interval.end >= end) {
                    availablePersons.add(interval.person);
                }
            }

            subIntervals.add(new SubInterval(start, end, availablePersons));
        }

        return subIntervals;
    }

static class Interval {
    String person;
    int start;
    int end;

    Interval(String person, int start, int end) {
        this.person = person;
        this.start = start;
        this.end = end;
    }
}

static class SubInterval {
    int start;
    int end;
    Set<String> persons;

    SubInterval(int start, int end, Set<String> persons) {
        this.start = start;
        this.end = end;
        this.persons = persons;
    }

    @Override
    public String toString() {
        return start + " to " + end + " -> " + persons;
    }
}
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval("p1", 10, 15),
                new Interval("p2", 12, 16)
        );

        List<SubInterval> subIntervals = AvailabilityIntervals.splitIntervals(intervals);

        for (SubInterval subInterval : subIntervals) {
            System.out.println(subInterval);
        }
    }
}
