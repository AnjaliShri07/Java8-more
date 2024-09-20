package com.java8.programs.interview.tricky.Strings;

public class EqualsDemo1 {
    public static void main(String [] args){
        String s1 = "Hey Amigo";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));
    }
}
/*
equals() is string class method.
When s1.equals(s2) is called, the equals method of the String class is executed.
The String class's equals method first checks if the passed object (s2 in this case) is an instance of the
String class.If not, it immediately returns false.*/
