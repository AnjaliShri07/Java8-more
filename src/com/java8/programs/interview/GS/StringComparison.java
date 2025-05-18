package com.java8.programs.interview.GS;

import java.util.stream.Collectors;

public class StringComparison {
    public static String removeHashCharacter(String input) {
        return input.chars()
                .filter(c -> c != '#')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
    public static void main(String[] args) {
        String firstString = "abd#def";
        String secondString = "abc#def";

        String processedFirstString = removeHashCharacter(firstString);
        String processedSecondString = removeHashCharacter(secondString);

        boolean areEqual = processedFirstString.equals(processedSecondString);

        System.out.println("Are the strings equal after removing '#': " + areEqual);
    }
}
