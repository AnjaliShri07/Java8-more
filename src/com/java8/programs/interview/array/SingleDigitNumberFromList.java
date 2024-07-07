package com.java8.programs.interview.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleDigitNumberFromList {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,43,15,66,87,89,-9,-10,22,34,-23,89,54,34);
        List<Integer> result = numbers.stream().filter(n->n/10 == 0).collect(Collectors.toList());
        System.out.println(result);
    }
}
