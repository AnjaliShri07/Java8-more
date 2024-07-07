package com.java8.programs.learning;

/*Syntax
default Stream<T> takeWhile(Predicate<? super T> predicate)
        takeWhile method takes all the values until the predicate returns false.
        It returns, in case of ordered stream, a stream consisting of the longest prefix of elements taken from this stream matching the given predicate.*/

import java.util.stream.Stream;

public class takeWhileMethod {
    public static void main(String[] args) {
        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty())
                .forEach(System.out::println);
    }
}
