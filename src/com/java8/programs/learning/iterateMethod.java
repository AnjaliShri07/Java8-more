package com.java8.programs.learning;


import java.util.stream.IntStream;

public class iterateMethod {
    public static void main(String[] args) {
        IntStream.iterate(3, x -> x < 10, x -> x+ 3).forEach(System.out::println);
    }
}
