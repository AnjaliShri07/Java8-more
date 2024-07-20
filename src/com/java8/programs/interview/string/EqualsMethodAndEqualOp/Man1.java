package com.java8.programs.interview.string.EqualsMethodAndEqualOp;

public class Man1 {
    int dnaCode;

    public boolean equals(Man1 man) {
        return this.dnaCode ==  man.dnaCode;
    }

    public static void main(String[] args) {
        Man1 man1 = new Man1();
        man1.dnaCode = 1111222233;

        Man1 man2 = new Man1();
        man2.dnaCode = 1111222233;

        System.out.println(man1.equals(man2));
    }
}
