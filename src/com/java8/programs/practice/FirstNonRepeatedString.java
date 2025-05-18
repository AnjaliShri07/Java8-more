package com.java8.programs.practice;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedString {
    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        input.chars()
                .mapToObj(s-> (char) s)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() ==1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
