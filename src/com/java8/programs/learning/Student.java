package com.java8.programs.learning;

public class Student {
    int rollNo;
    String name;
    int marks;

    public Student(String name) {
        this.name = name;
    }

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [RollNo=" + rollNo + ", Name=" + name + ", Marks=" + marks + "]";
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}