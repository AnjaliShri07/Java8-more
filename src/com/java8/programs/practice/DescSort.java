package com.java8.programs.practice;

import java.util.*;
import java.util.stream.Collectors;

public class DescSort {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);
    }
}
