package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.Collectors;

//"Find winner of an election where votes are represented as candidate names. Given an array of names of candidates
// in an election.A candidate name in array represents a vote casted to the candidate.
//Print the name of candidates received Max vote. If there is tie, print lexicographically smaller name."
public class ElectionWinner {
    public static void main(String[] args) {
        List<String> votes = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Alice",
                "Charlie", "Charlie", "Charlie");
        String winner = findWinner(votes);
        System.out.println("Winner: " + winner);
    }

    private static String findWinner(List<String> votes) {
        Map<String, Long> voteCount = votes.stream()
                .collect(Collectors.groupingBy(candidate -> candidate, Collectors.counting()));

        return voteCount.entrySet().stream()
                .max((entry1, entry2) -> {
                    int countComparison = entry1.getValue().compareTo(entry2.getValue());
                    if (countComparison == 0L) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return countComparison;
                })
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
