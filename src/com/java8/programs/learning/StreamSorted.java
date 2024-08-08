package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(90);
		marks.add(80);
		marks.add(70);
		marks.add(60);
		marks.add(50);
		marks.add(25);
		marks.add(30);
		List<Integer> sortedList = marks.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList : " +sortedList);

	}

}
