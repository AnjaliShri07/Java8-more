package com.java8.programs.learning;

import java.util.ArrayList;

public class StreamCount {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(90);
		marks.add(80);
		marks.add(70);
		marks.add(60);
		marks.add(50);
		marks.add(25);
		marks.add(30);
		System.out.println(marks);
		long noOfFailedStudent = marks.stream().filter(i->i<35).count();
		System.out.println("noOfFailedStudent : " +noOfFailedStudent);

	}

}
