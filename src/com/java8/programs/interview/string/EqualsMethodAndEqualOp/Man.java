package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class Man {
    int geneticCode;

    public static void main(String[] args) {

        Man man1 = new Man();
        man1.geneticCode = 1111222233;

        Man man2 = new Man();
        man2.geneticCode = 1111222233;

        System.out.println(man1 == man2);
        System.out.println(man1.equals(man2));
        System.out.println(man2.equals(man1));
    }
}
