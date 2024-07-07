package com.java8.programs.practice;

import java.util.Arrays;
import java.util.List;

public class CountElements {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Long count = myList.stream().count();
        System.out.print(count);
    }
}
