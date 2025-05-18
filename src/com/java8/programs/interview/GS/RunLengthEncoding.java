package com.java8.programs.interview.GS;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RunLengthEncoding {
    public static String rle(String input) {
        if (input == null || input.isEmpty()) return "";

        Map<Character, Long> map = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        return map.entrySet().stream()
                .map(entry -> "" + entry.getKey() + entry.getValue())
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(RunLengthEncoding.rle("abbcccdddd"));

        if ("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa")) &&
                "a2b3".equals(rle("aabbb")) &&
                "a1b1c1".equals(rle("abc"))) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
