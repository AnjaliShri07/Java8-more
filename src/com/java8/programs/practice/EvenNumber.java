package com.java8.programs.practice;

import java.util.*;
import java.util.stream.Collectors;

public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream().sorted().filter(i-> i%2 ==0).collect(Collectors.toList()).forEach(System.out::println);
    }
}
