package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(90);
		marks.add(80);
		marks.add(70);
		marks.add(60);
		marks.add(50);
		marks.add(40);
		marks.add(30);
		System.out.println(marks);
		List<Integer> updatedMarks = marks.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println("updatedMarks : " +updatedMarks);
	}

}
