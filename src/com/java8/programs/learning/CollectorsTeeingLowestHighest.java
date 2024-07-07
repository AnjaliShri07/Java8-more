package com.java8.programs.learning;

import java.util.*;
import java.util.stream.*;

public class CollectorsTeeingLowestHighest {
    public static void main(String args[]) {
        // list of students
        List<Student> students = Arrays.asList(
                new Student(1, "Robert", 390),
                new Student(2, "Julie", 410),
                new Student(3, "John", 440),
                new Student(4, "Michael", 420));

        // collect the result in hashmap
        HashMap<String, Student> result = students.stream().collect(
                // apply the teeing operator
                Collectors.teeing(
                        // get the student having highest marks
                        Collectors.maxBy(Comparator.comparing(Student::getMarks)),
                        // get the student having lowest marks
                        Collectors.minBy(Comparator.comparing(Student::getMarks)),
                        // put both student entries in the map using merger
                        (s1, s2) -> {
                            HashMap<String, Student> map = new HashMap<>();
                            map.put("Highest", s1.get());
                            map.put("Lowest", s2.get());
                            return map;
                        }
                ));
        System.out.println(result);
    }
}


