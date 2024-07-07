package com.java8.programs.learning;

import java.util.stream.Stream;

public class dropWhileMethod {
    public static void main(String[] args) {
        Stream.of("a","b","c","","e","f").dropWhile(s-> !s.isEmpty())
                .forEach(System.out::println);

        System.out.println();
        Stream.of("a","b","c","","e","","f").dropWhile(s-> !s.isEmpty())
                .forEach(System.out::println);
    }
}
