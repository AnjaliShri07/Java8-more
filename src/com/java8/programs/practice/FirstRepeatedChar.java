package com.java8.programs.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedChar {
    public static void main(String[] args) {
        String input = "Java Articles are Awesome";
        Character c = input.chars().mapToObj(s-> (char) s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry-> entry.getValue() > 1L).map(Map.Entry::getKey).findFirst().get();
        System.out.println(c);
    }
}
