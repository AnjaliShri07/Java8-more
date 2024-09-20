package com.java8.programs.interview.string;

import java.util.stream.Collectors;

public class ShiftChar {

    private static int shiftChar(char c){
        if(c >='a' && c <='z'){
            return c =='z'? 'a' : c+1;
        }else if(c >='A' && c <='Z'){
            return c =='Z'? 'A' : c+1;
        }else{
            return c;
        }
    }
    public static void main(String[] args) {
        String input = "AdzF";

        String result = input.chars()
                .mapToObj(c-> (char) shiftChar((char)c))
                .map(String :: valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }


}
