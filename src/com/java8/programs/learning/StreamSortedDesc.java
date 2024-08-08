package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedDesc {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(30);
		marks.add(45);
		marks.add(50);
		marks.add(80);
		marks.add(90);
		marks.add(25);
		marks.add(100);
		System.out.println(marks);
		//List<Integer> sortedList = marks.stream().sorted((i1,i2)->(i1<i2)?1 :(i1>i2)?-1:0).collect(Collectors.toList());//DESC
		//List<Integer> sortedList = marks.stream().sorted((i1,i2)-> i1.compareTo(i2)).collect(Collectors.toList()); //ASC
		//List<Integer> sortedList = marks.stream().sorted((i1,i2)-> i2.compareTo(i1)).collect(Collectors.toList()); //DESC
		List<Integer> sortedList = marks.stream().sorted((i1,i2)-> -i1.compareTo(i2)).collect(Collectors.toList()); //DESC
		System.out.println("sortedList : " +sortedList);

	}

}
