package com.java8.interview.program.string;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    public static Character firstNonRepeatedCharacter(String str) {
        Map<Character, Long> characterCountMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return characterCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static Character firstNonRepeatingCharUsingSet(String str){
        Set<Character> set = new HashSet<>();
                return str.chars()
                .mapToObj(c -> (char) c)
                .filter(set::add)
                .findFirst().orElse(null);
    }

    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        Character result = firstNonRepeatedCharacter(input);
        if (result != null) {
            System.out.println("The first non-repeated character is: " + result);
        } else {
            System.out.println("There are no non-repeated characters.");
        }

        System.out.println("Using Set : " + firstNonRepeatingCharUsingSet(input));
    }
}
