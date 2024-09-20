package com.java8.programs.interview.string;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringWihoutAffectingSpecialChar {
    public static void main(String[] args) {
        String str = "a,b$c";
        char[] ch= str.toCharArray();
        List<Character> letters = IntStream.range(0, ch.length)
                .mapToObj(i->ch[i])
                .filter(Character :: isLetter)
                .collect(Collectors.toList());
        Collections.reverse(letters);
        //System.out.println(letters);
        StringBuilder result = new StringBuilder();

        for(char c: ch){
            if(Character.isLetter((c))){
                //result.append(letters.removeFirst());
                System.out.println("letter = "+ result.toString());
            }else{
                result.append(c);
                //System.out.println("special = "+result.toString());
            }
        }

        System.out.println(result.toString());
    }
}
