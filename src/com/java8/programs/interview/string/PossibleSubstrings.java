package com.java8.programs.interview.string;

import java.util.List;
import java.util.stream.*;

public class PossibleSubstrings {
    public static void main(String[] args) {
        String input = "abcd";

   List<String> substrings = IntStream.range(0, input.length())
                    .boxed()
                    .flatMap(i-> IntStream.range(i+1, input.length()+1)
                                        .mapToObj(j->input.substring(i, j)))
                    .collect(Collectors.toList());
        System.out.println(substrings);
    }
}
