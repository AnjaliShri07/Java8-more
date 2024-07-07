package com.java8.programs.learning;

import java.util.*;

public class ReferenceToConstructor {
    public static void main(String args[]) {
        List<String> studentNames = Arrays.asList("Mahesh","Suresh","Ramesh","Robert","Jon");

        // create the list of student objects from names
        Student[] students =  studentNames.stream().map(Student::new).toArray(Student[]::new);

        List<Student> list = Arrays.asList(students);

        System.out.println(list);
    }
}
