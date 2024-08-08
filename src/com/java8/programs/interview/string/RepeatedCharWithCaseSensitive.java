package com.java8.programs.interview.string;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharWithCaseSensitive {
    public static String findRepeatedChars(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter) // Filter only letters
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";
        String repeatedChars = findRepeatedChars(input);
        System.out.println(repeatedChars);
    }
}
