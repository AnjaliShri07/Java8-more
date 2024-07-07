package com.java8.programs.learning;


/*public static Collector<T, ?, R> teeing(
        Collector<? super T, ?, R1> downstream1,
        Collector<? super T, ?, R2> downstream2,
        BiFunction<? super R1, ? super R2, R> merger
        )*/


/*
Here each element of the collection passed to the teeing collector is processed by downstream1 and downstream2 collectors,
once the processing is completed by both the collectors, the results are passed to the BiFunction collector to merge the result or process accordingly.
It is similar to calling two functions on a collection and then calling the third function to process the results of first two functions.

Here we are performing different functions on a collection and then merge the result using merger BiFunction.*/

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTeeing {
    public static void main(String[] args) {
        double mean
                = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(i -> i), Collectors.counting(),
                        (sum, n) -> sum / n));

        System.out.println(mean);
    }
}
