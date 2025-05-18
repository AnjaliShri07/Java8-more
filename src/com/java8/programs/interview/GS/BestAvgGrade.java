package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.Collectors;

/*🧠 Problem:
Given a list of test scores (in the form of a 2D string array), where:
Each entry is a pair [name, score]
A student can appear multiple times
You must return the best average score (as an integer).*/
public class BestAvgGrade {
    public static Integer bestAvgGrade(String[][] scores) {
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Collect scores per student
        //Iterate through each [name, score] in the array.
        //Use computeIfAbsent to initialize a list for a new student.
        //Add the score to that student's list.
        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);
            studentScores.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
        }

        int bestAverage = Integer.MIN_VALUE;
        // Compute averages
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> scoreList = entry.getValue();
            int total = 0;

            for (int score : scoreList) {
                total += score;
            }

            int average = total / scoreList.size(); // Integer division as per example
            System.out.println("average ==> "+average);
            bestAverage = Math.max(bestAverage, average);
            System.out.println("bestAverage ==> "+bestAverage);
        }

        return bestAverage;
    }

    public static int bestAvgGradeWithStream(String[][] scores) {
        Map<String, List<Integer>> grouped = Arrays.stream(scores)
                .collect(Collectors.groupingBy(
                        arr -> arr[0],
                        Collectors.mapping(
                                arr -> Integer.parseInt(arr[1])
                                , Collectors.toList())
                ));

        return grouped.values().stream()
                .mapToInt(
                        list -> list.stream()
                        .mapToInt(Integer::intValue)
                        .sum() / list.size())
                .max().orElse(-1);
    }

    public static boolean pass() {
        String[][] s1 = {
                { "Rohan", "84" },
                { "Sachin", "102" },
                { "Ishan", "55" },
                { "Sachin", "18" }
        };

        String[][] s2 = {
                { "Alice", "99" },
                { "Bob", "100" },
                { "Alice", "100" } // Avg = 99.5, Bob = 100
        };

        return bestAvgGrade(s1) == 84 /*&& bestAvgGrade(s2) == 100.0*/;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }
}
/*📈 Time & Space Complexity
Time Complexity: O(n) — where n is number of entries in scores array.
Space Complexity: O(s) — where s is the number of unique students.*/