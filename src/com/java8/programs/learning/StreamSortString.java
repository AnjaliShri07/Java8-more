package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortString {

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("Suresh");
		l.add("Kapil");
		l.add("Prabhas");
		l.add("Anchala");
		l.add("Monika");
		l.add("Ishika");
		List<String> sortedList = l.stream().sorted().collect(Collectors.toList()); //ASC
		//List<String> sortedList = l.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList()); //DESC
		System.out.println("After Sorting : " +sortedList);

	}

}
