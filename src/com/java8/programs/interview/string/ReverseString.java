package com.java8.programs.interview.string;

import java.util.Arrays;
import java.util.stream.*;

public class ReverseString {
    public static void main(String[] args) {
        String str = "My name is Christopher Nolan";
        String reversedString = Arrays.stream(str.split(" ")).map(s -> new StringBuffer(s).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reversedString);
    }
}
