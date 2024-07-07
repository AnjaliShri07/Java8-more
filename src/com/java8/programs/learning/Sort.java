package com.java8.programs.learning;

import java.util.*;

public class Sort {
    public static void main(String args[]) {
        List<Integer> numbers = Arrays.asList(1,2,4,9,8,7,3);
        System.out.println("Sorted using lambda expression");
        numbers = numbers.stream().sorted((a,b) -> a.compareTo(b)).toList();

        System.out.println(numbers);

        numbers = Arrays.asList(1,2,4,9,8,7,3);
        System.out.println("Sorted using method reference" );
        numbers = numbers.stream().sorted(Integer::compareTo).toList();

        System.out.println(numbers);

        List<String> strings = Arrays.asList("Joe", "Sarah", "Dean", "Sam");
        strings = strings.stream().sorted(String::compareTo).toList();
        strings.forEach(System.out ::println);

    }

}
