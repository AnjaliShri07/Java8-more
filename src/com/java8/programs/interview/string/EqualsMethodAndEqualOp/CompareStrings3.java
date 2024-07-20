package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class CompareStrings3 {
    public static void main(String[] args) {

        String style = new String("Bold");
        String style2 = new String("Bold");

        if(style.equals(style2))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
