package com.java8.programs.practice;

import java.util.*;
import java.util.stream.Collectors;

public class CubeAndGreater {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream().map(i-> i*i*i).filter(j-> j>50).collect(Collectors.toList()).forEach(System.out::println);
    }
}
