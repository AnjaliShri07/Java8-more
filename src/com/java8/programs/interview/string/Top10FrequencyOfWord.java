package com.java8.programs.interview.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Given a large text file containing a list of words, find the top 10 most frequent words and their corresponding
frequencies.*/
public class Top10FrequencyOfWord {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog. The lazy dog jumps over the quick brown fox. The lazy dog and fox got into fight.";
        Map<String, Long> map = Arrays.stream(str.toLowerCase()
                                                 .replaceAll("[^a-z\\s]", "")
                                                 .split("\\s+"))
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        List<Map.Entry<String, Long>> freq = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(freq);
//[the=5, lazy=3, dog=3, fox=3, over=2, quick=2, jumps=2, brown=2, into=1, and=1]

    }
}
