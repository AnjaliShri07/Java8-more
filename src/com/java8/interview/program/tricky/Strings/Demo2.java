package com.tricky.Strings;

public class Demo2 {
    public static void main(String[] args) {
        String s = new String("5");
        System.out.println(1 + 10 + s + 1 + 10);
    }
}

/*
The string concatenation operator works as follows:
if both the operands are numbers, it performs the addition;
otherwise, it concatenates the arguments by calling the toString() method if needed. It evaluates from left to right.
Hence, the expression in the program results in the string 115110.*/
