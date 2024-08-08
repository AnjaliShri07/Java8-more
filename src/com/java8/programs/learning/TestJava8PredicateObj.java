package com.java8.programs.learning;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8PredicateObj {
	
	
	public static void main (String args[])
	{
		ArrayList<TestEmployee> listdata = new ArrayList<TestEmployee>();
		
		TestEmployee e1 = new TestEmployee(1, "DEB", 2, new Double(22));
		TestEmployee e2 = new TestEmployee(2, "HAR", 3, new Double(35));
		TestEmployee e3 = new TestEmployee(3, "SAT", null, new Double(100));
		TestEmployee e4 = new TestEmployee(4, "SUR", 2, new Double(23));
		TestEmployee e5 = new TestEmployee(5, "RAM", 2, new Double(25));
		TestEmployee e6 = new TestEmployee(6, "ANU", 3, new Double(34));
		listdata.addAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		
		filterBymanager(listdata, TestEmployee -> TestEmployee.getManager_id()!=null &&
				TestEmployee.getManager_id().intValue()==2);
		
		filterBymanager(listdata, TestEmployee -> TestEmployee.getManager_id()!=null &&
				TestEmployee.getManager_id().intValue()==3);
		
		filterByHead(listdata, TestEmployee -> TestEmployee.getManager_id()==null );
		
		filterByData(listdata, TestEmployee -> TestEmployee.getManager_id()!=null &&
				TestEmployee.getManager_id().intValue()==3);
		
		filterByData(listdata, TestEmployee -> TestEmployee.getManager_id()!=null &&
				TestEmployee.getManager_id().intValue()==2);
		
	}
	
	
	public static void filterByData(ArrayList<TestEmployee> listdata,Predicate<TestEmployee> predicate)
	{
		//System.out.println("MAX SALARY of particualr reporting manager :: " + highest_sal);
		
		System.out.println(listdata
	      .stream().filter(predicate)
	      .flatMap(x -> Stream.of(x.getSalary()))
	      .distinct().count());
	      
		
		listdata
	      .stream().filter(predicate)
	      .map(x -> Stream.of(x.getSalary()))
	      .distinct().count();
	     
		
		Double highest_sal= listdata
	      .stream().filter(predicate)
	      .reduce(
	       new Double(0), (partialAgeResult, user) -> user.getSalary(), Double::max);
		
		Double highest_sal_1= listdata
			      .stream().filter(predicate)
			      .reduce(
			       new Double(0), (partialAgeResult, user) -> partialAgeResult + user.getSalary(), Double::sum);
		
		System.out.println(highest_sal);
		
		System.out.println(highest_sal_1);
		
		Predicate<TestEmployee> predicate1 = TestEmployee -> TestEmployee.getSalary().doubleValue()==highest_sal;
		
		System.out.println("MAX SALARY of particualr reporting manager :: " + 
		listdata.parallelStream().filter(predicate1).findFirst());
	}
	
	public static void filterByHead(ArrayList<TestEmployee> listdata,Predicate<TestEmployee> predicate)
	{
		System.out.println( "HEAD of org ::"+
				listdata.stream().filter(predicate).findFirst() );
	}
	
	public static void filterBymanager(ArrayList<TestEmployee> listdata,Predicate<TestEmployee> predicate)
	{
		Predicate<TestEmployee> predicate1 = TestEmployee -> TestEmployee.getSalary()>new Double(20);
		
		//System.out.println("Custom Object STREAMS FILTER GROUP BY PREDICATE ::" );
		listdata.stream()
		.filter(predicate.and(predicate1))
		.collect(Collectors.groupingBy(TestEmployee::getManager_id,Collectors.counting()))
		.forEach((k,v) -> {
			System.out.println("Manager id  ::"+ k + "  Count   :: "+ v);
		});
		
		//System.out.println("Custom Object STREAMS FILTER GROUP BY and JOIN ::" );
		listdata.stream()
		.filter(predicate.and(predicate1))
		.collect(Collectors.groupingBy(TestEmployee::getManager_id,
				Collectors.toMap(TestEmployee::getEmpid, 
			TestEmployee::getEmpname)))
		.forEach((k,v) -> {
			System.out.println("Manager id  ::"+ k + "  Count   :: "+ v );
		});
	
		
		//System.out.println("Custom Object STREAMS FILTER GROUP BY and JOIN Full Obj ::" );
		listdata.stream()
		.filter(predicate.and(predicate1))
		.collect(Collectors.groupingBy(TestEmployee::getManager_id,
				Collectors.toList()))
		.forEach((k,v) -> {
			System.out.println("Manager Data  ::"+ 
			listdata.parallelStream().filter(TestEmployee -> 
			TestEmployee.getEmpid().intValue()==k.intValue()).findFirst() + "  Count   :: "+ v );
		});
		
		
		//System.out.println("Custom Object STREAMS FILTER GROUP BY and JOIN Full Obj operating on data ::" );
		listdata.stream()
		.filter(predicate.and(predicate1))
		.collect(Collectors.groupingBy(TestEmployee::getManager_id,
				Collectors.toList()))
		.forEach((k,v) -> {
			System.out.print("Manager name  ::"+ 
			listdata.parallelStream().filter(TestEmployee -> 
			TestEmployee.getEmpid().intValue()==k.intValue()).findFirst().get().getEmpname() );
			System.out.print ("  Reportess   :: " );
			v.forEach((tdd) -> {
				System.out.print("{ emp id:: " +tdd.getEmpid() + "  emp name :: "+tdd.getEmpname() +" }");
			});
			System.out.println();
		});
	}

}
