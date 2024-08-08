package com.java8.programs.interview.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartWithOne {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 200,101, 36, 87, 16, 18, 67);
        list.stream()
                .map(s-> s+"")
                .filter(i-> i.startsWith("1"))
                .toList().forEach(System.out::println);
    }
}
