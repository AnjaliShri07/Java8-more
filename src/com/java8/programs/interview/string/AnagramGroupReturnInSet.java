package com.java8.programs.interview.string;


import java.util.*;
import java.util.stream.Collectors;

public class AnagramGroupReturnInSet {
    public static Set<Set<String>> groupAnagram(String[] str){
        return Arrays.stream(str).collect(Collectors.groupingBy(AnagramGroupReturnInSet:: sortChar)).values().stream()
                .map(HashSet:: new).collect(Collectors.toSet());
    }

    private static String sortChar(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public static void main(String[] args) {
        String[] str = {"cat", "dog", "act", "god"};
        System.out.println(AnagramGroupReturnInSet.groupAnagram(str));
    }
}
