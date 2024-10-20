package com.java8.programs.interview.tricky.map;

import java.util.HashMap;
import java.util.Map;

public class Demo3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("string", "Hi");
        map.put(new String("string"),"bii");
        System.out.println(map.get("string"));
    }
}
