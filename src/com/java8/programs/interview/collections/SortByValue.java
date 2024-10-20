package com.java8.programs.interview.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValue {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Jaipur");
        map.put(2, "Delhi");
        map.put(3, "Bangalore");

        Map<Integer, String> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry :: getKey,
                        Map.Entry :: getValue, (e1,e2)->e2, LinkedHashMap:: new));
        result.forEach((key, value)-> System.out.println(key + " : "+value));
    }
}
