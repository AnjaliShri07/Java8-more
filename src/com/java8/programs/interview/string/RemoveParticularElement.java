package com.java8.programs.interview.string;

import java.util.stream.Collectors;

public class RemoveParticularElement {
    public static void main(String[] args) {
        String str = "CloudTech";
        String updatedStr = str.chars()
                .filter(ch-> ch != 'c')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(updatedStr);
    }
}
