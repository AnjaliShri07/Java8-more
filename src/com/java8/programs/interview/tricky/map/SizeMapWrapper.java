package com.java8.programs.interview.tricky.map;
import java.util.*;

public class SizeMapWrapper {
    public static void main(String[] args) {
        Integer i1= new Integer(1);
        Integer i2= new Integer(1);

        Map<Integer,String> map = new HashMap<>();
        map.put(i1, "One");
        map.put(i2, "One");
        System.out.println(map.size());
        System.out.println(map.get(i1));

    }
}
/*
Explanation:
Creating Integer Objects:

In Java, Integer objects with values between -128 and 127 are cached by the JVM. This means that when you create
an Integer object within this range using the new keyword, a new object is not created. Instead, the cached
instance is reused.

In this case, since i1 and i2 both have the value 1, which is within the cached range, they actually refer to the
same object in memory. This is why the map only contains one entry.*/
