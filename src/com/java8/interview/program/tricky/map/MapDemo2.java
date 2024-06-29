package com.tricky.map;

import java.util.HashMap;
import java.util.Map;

class Student{
    Integer id;

    Student(Integer id){
        this.id =id;
    }
}
public class MapDemo2 {
    public static void main(String[] arg){
        Student s1 = new Student(2);
        Student s2 = new Student(2);

        Map<Student, String> studentMap = new HashMap<>();
        studentMap.put(s1, "Anjali");
        studentMap.put(s2, "Anjali");
        System.out.println(studentMap.size());
        System.out.println(studentMap.get(s1));
    }
}
