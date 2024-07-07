package com.java8.programs.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartWithOne {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,2000,98,1000);
        myList.stream().map(s-> s.toString()) // Convert integer to String
        .filter(i->i.startsWith("1")).collect(Collectors.toList()).forEach(System.out ::println);
    }
}
