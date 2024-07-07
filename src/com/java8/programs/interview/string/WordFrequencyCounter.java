package com.java8.programs.interview.string;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCounter {
    public static Map<String, Long> countWordFrequency(List<String> words) {
        return words.stream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.groupingBy(n->n, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple banana apple", "banana cherry", "apple banana cherry");
        Map<String, Long> frequencyMap = countWordFrequency(words);
        System.out.println("Word frequency: " + frequencyMap);
    }
}


/*
Explanation:
Creating a Stream of Words:

        words.stream(): Creates a stream from the list of strings.
        .flatMap(line -> Arrays.stream(line.split("\\s+"))): Splits each string into individual words and flattens the resulting streams of words into a single stream.
Collecting the Frequencies:

        .collect(Collectors.groupingBy(word -> word, Collectors.counting())): Groups the words by themselves and counts the occurrences of each word.
Printing the Frequencies:

        wordFrequency.forEach((word, count) -> System.out.println(word + ": " + count)): Iterates through the map and prints each word along with its frequency.*/
