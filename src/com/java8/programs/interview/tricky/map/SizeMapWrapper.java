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

i1 and i2 are both Integer objects with the value 1.
Even though they are two different objects, they have the same value.
HashMap Behavior:

HashMap uses the hashCode method to determine the bucket location for each key.
It uses the equals method to check if an existing key is equal to the new key.
Integer hashCode and equals Methods:

The hashCode method for Integer returns the value of the Integer itself.
The equals method for Integer returns true if the values are the same.
Since both i1 and i2 have the same value, their hashCode values will be identical,
and the equals method will return true when comparing i1 and i2.

Analysis:
When map.put(i1, "One") is called, i1 is added to the HashMap.
When map.put(i2, "One") is called, the HashMap will check if there is already a key with the same hashCode and equals value as i2.
Since i1 and i2 are equal in terms of hashCode and equals, i2 will replace i1 as the key in the HashMap.
Output:
Only one entry will be in the HashMap since i1 and i2 are considered the same key.
        Therefore, the size of the HashMap will be 1.*/
