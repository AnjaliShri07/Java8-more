package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
	public static void main(String args[]) {
	      List<String> nameList = new ArrayList<String>();
			
	      nameList.add("Mahesh");
	      nameList.add("Suresh");
	      nameList.add("Ramesh");
	      			
	      nameList.forEach(System.out::println);
	      System.out.println("--------------------------");  
	      nameList.forEach(names -> System.out.println(names));   
	      List<String> gamesList = new ArrayList<String>();  
	        gamesList.add("Football");  
	        gamesList.add("Cricket");  
	        gamesList.add("Chess");  
	        gamesList.add("Hocky"); 
	        
	        System.out.println("------------Iterating by passing lambda expression--------------");  
	        gamesList.forEach(games -> System.out.println(games)); 
	        
	        System.out.println("------------Iterating by passing lambda expression---------------");  
	        gamesList.stream().forEachOrdered(games -> System.out.println(games)); 
	        
	        System.out.println("------------Iterating by passing method reference---------------");  
	        gamesList.stream().forEachOrdered(System.out::println);  
	   }
}
