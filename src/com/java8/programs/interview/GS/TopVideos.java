package com.java8.programs.interview.GS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*"Given a list L of video names and their watch rates, write a function that will return the videos with the
top 10 watch rates.
Video names may appear more than once.Example:
L = [(‘abc’, 10), (‘def’, 15), (‘ghi’, 10), (‘abc’, 12), …, (‘xyz’,100)]
The function should return [‘xyz’, ‘abc’, …, ‘def’, ‘ghi’]"
*/
record Pair(String name, int watchRate) {
}
public class TopVideos {
    public static List<String> getTopVideos(List<Pair> videos, int topN) {
        return videos.stream()
                .sorted(Comparator.comparingInt(Pair::watchRate).reversed())
                .limit(topN)
                .map(Pair::name)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Pair> videos = Arrays.asList(
                new Pair("abc", 10),
                new Pair("def", 15),
                new Pair("ghi", 10),
                new Pair("abc", 12),
                new Pair("xyz", 100)
        );

        List<String> topVideos = getTopVideos(videos, 10);
        System.out.println("Top videos: " + topVideos);
    }
}
