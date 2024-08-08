package com.java8.programs.learning;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageResult {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
        //List<Integer> list = Arrays.asList(arr);
        OptionalDouble average = Arrays.stream(arr)    //Returns a sequential Stream with the specified array as its source.
                                 .mapToInt(n->n*n)    // IntStream
                                 .filter(n->n>10000) //Returns a stream consisting of the elements of this stream that match the given predicate. 
                                 .average();
 
        if(average.isPresent())
            System.out.println(average.getAsDouble());

	}

}
