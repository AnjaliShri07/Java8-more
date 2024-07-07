package com.java8.programs.interview.string;

import java.util.*;
import java.util.stream.Collectors;

public class Vowel {
    public static void main(String[] args) {
        String name = "Anjali Shrivastav";
        List<Character> vowel = name.toLowerCase().chars()
                .mapToObj(c-> (char) c)
                .filter(c->"aeiou".indexOf(c) != -1)
                .collect(Collectors.toList());

        System.out.println(vowel);

    }
}
