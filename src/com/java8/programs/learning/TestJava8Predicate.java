package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class TestJava8Predicate {

	public static void main(String args[])
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("DEBA", 1);
		map.put("SEBA", 2);
		map.put("DD", 3);
		map.put("DEB", 4);
		map.put("DEBASR", 5);
		map.put("PRI", 6);
		
		
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("TEST");
		data.add("TDD");
		data.add("Termide");
		data.add("TENU");
		data.add("PP");
		
		
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		printData(map, a -> a.contains("EB"));
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		//printData(map, a -> a.startsWith("D"));
		
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		printArrayList(data, a -> a.startsWith("T"));
		
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		streamsArrayList(data, a -> a.startsWith("T"));
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		streamsData(map);
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		//Bi consumer usage
		playwithBiconsumer(map, data);
		
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		//Biconsumer usage as override of default method
		BiConsumer<HashMap<String, Integer> , String> mb = new MYBiConsumer ();
		mb.accept(map, "D");
		
		// Example of predicate usage
		//LAMBDA EXPRESIION USAGE
		//Functions usage 
		playwithFunctions(map);
		
	}
	
	
	public static void printData(HashMap<String, Integer> map, Predicate<String> predicate)
	{
		
		System.out.println("printData HASHMAP  PREDICATE ::" );
		//Example of how to iterate HashMap in java 8
		//LAMBDA EXPRESIION USAGE
		map.forEach((k,v)-> {
		if(predicate.test(k))
		{
			System.out.println("KEY  ::"+ k + "  VAL  :: "+ v);
		}
		});
	}
	
	public static void printArrayList(ArrayList<String> map, Predicate<String> predicate)
	{
		System.out.println("printData ArrayList  PREDICATE ::" );
		Predicate<String> dbpredicate = a -> a.contains("e");
		Predicate<String> dbpredicate1 = a -> a.contains("E");
		
		//Example of how to iterate Arraylist in java 8
		//LAMBDA EXPRESIION USAGE
		map.forEach((k)->{
			// Composite predicate usage
			if(predicate.and(dbpredicate.or(dbpredicate1)).test(k))
			{
				System.out.println("KEY  ::"+ k );
			}
		});
	}
	
	public static void streamsData(HashMap<String, Integer> map)
	{
		
		System.out.println("printData HASHMAP  STREAMS FILTER PREDICATE ::" );
		//Example of how to iterate HashMap in java 8
		//LAMBDA EXPRESIION USAGE
		map.entrySet().stream().filter(entry -> entry.getKey().contains("EB") 
				&& entry.getKey().startsWith("D"))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue))
		.forEach((k,v)->{ 
			System.out.println("KEY  ::"+ k + "  VAL  :: "+ v);
		});;
		
		
		System.out.println("printData HASHMAP  STREAMS FILTER SORT PREDICATE ::" );
		//Example of how to iterate HashMap in java 8
		//LAMBDA EXPRESIION USAGE
		map.entrySet().stream().filter(entry -> entry.getKey().contains("EB") 
				&& entry.getKey().startsWith("D"))
		.sorted(
				(Entry<String, Integer> s1, Entry<String,Integer> s2) -> s1.getValue().compareTo(s2.getValue()))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue))
		.forEach((k,v)->{ 
			System.out.println("KEY  ::"+ k + "  VAL  :: "+ v);
		});;
		
		//Example of how to iterate HashMap in java 8
				//LAMBDA EXPRESIION USAGE
		System.out.println("printData HASHMAP  STREAMS FILTER PREDICATE FIND FIRST ::" );
		Optional<Entry<String, Integer>> map1= map.entrySet().stream().filter(entry -> entry.getKey().contains("EB") 
				&& entry.getKey().startsWith("D")).findFirst();
		
		//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
		System.out.println("KEY  ::"+ map1.get().getKey() + "  VAL  :: "+ map1.get().getValue());
		
		
		
		System.out.println("printData HASHMAP  STREAMS FILTER GROUP BY PREDICATE ::" );
		//Example of how to iterate HashMap in java 8
		//LAMBDA EXPRESIION USAGE
		map.entrySet().stream().filter(entry -> entry.getKey().contains("EB") 
				&& entry.getKey().startsWith("D"))
		.collect(Collectors.groupingBy(
	            Entry::getKey,Collectors.mapping(Entry::getKey, Collectors.counting())))
		.forEach((k,v) -> {
			System.out.println("KEY  ::"+ k + "  VAL  :: "+ v);
		});
		
		
		
	}
	
	
	public static void streamsArrayList(ArrayList<String> map, Predicate<String> predicate)
	{
		
		System.out.println("printData streams FILTER ArrayList  PREDICATE ::" );
		Predicate<String> dbpredicate = a -> a.contains("e");
		Predicate<String> dbpredicate1 = a -> a.contains("E");
		
		map.stream().filter(predicate.and(dbpredicate.or(dbpredicate1))).collect(Collectors.toList())
		.forEach((k) -> {
			System.out.println("KEY  ::"+ k);
		});
		
		
		System.out.println("printData streams FILTER  SORT ArrayList  PREDICATE ::" );
		map.stream().filter(predicate.and(dbpredicate.or(dbpredicate1)))
		.sorted((String s1, String s2) -> s1.compareTo(s2))
		.collect(Collectors.toList()).forEach((k) -> {
			System.out.println("KEY  ::"+ k);
		});
		
		
		System.out.println("printData parallelStream FILTER ArrayList  PREDICATE ::" );
		// Example of parallel stream it is same as streams its just used for parallel processing.
		
		map.parallelStream().filter(predicate.and(dbpredicate.or(dbpredicate1))).collect(Collectors.toList())
		.forEach((k) -> {
			System.out.println("KEY  ::"+ k);
		});
		
		
		System.out.println("printData parallelStream FILTER  SORT ArrayList  PREDICATE ::" );
		map.parallelStream().filter(predicate.and(dbpredicate.or(dbpredicate1)))
		.sorted((String s1, String s2) -> s1.compareTo(s2))
		.collect(Collectors.toList()).forEach((k) -> {
			System.out.println("KEY  ::"+ k);
		});
		;
		
		
	}
	
	public static void playwithBiconsumer(HashMap<String, Integer> map , ArrayList<String> data )
	{
		BiConsumer<HashMap<String, Integer> , ArrayList<String>> comapredataset
		= (map1 , data1) -> {
			
			final Integer[] counter = {null};
			final Integer[] counter1 = {null};
			if(map1 != null && data1!=null)
			{
				map1.entrySet().stream().
				forEach((entry) -> {
					
					if(entry.getKey().startsWith("D"))
						{
							//count++;
							if(counter[0] != null)
							counter[0]=counter[0] +1;
							else
								counter[0]=1;
						}
					
				});

				data1.stream().forEach((k) -> {
					
					if(k.startsWith("T"))
					{
						//count1++;
						if(counter1[0] != null)
							counter1[0]=counter1[0]+1;
						else
							counter1[0]=1;
					}
				});
				
				if(counter[0].intValue() ==counter1[0].intValue())
					{
						System.out.println("TRUE   :::" + counter[0].intValue() + "  :::  "+ counter1[0].intValue());
						return;
					}
			}
			
			
		};
		 
		comapredataset.accept(map, data);
		
		BiConsumer<HashMap<String, Integer> , ArrayList<String>> matcherthen = (map2, data2) -> {
			
			
			map2.entrySet().stream().filter(entry1 -> entry1.getKey().startsWith("D"))
			.forEach((entry) -> System.out.print( entry.getKey() + " ") );
			System.out.println();
			data2.stream().filter(s -> s.startsWith("T")).forEach((entry) -> System.out.print( entry + "  ") );
			System.out.println();
		};
		
		
		comapredataset.andThen(matcherthen).accept(map, data);
	}
	
	public static void playwithFunctions(HashMap<String, Integer> map)
	{
		Function<Entry<String, Integer> , Entry<String, Integer> > func = entry -> 
		{
			if(entry!=null && entry.getKey().startsWith("D"))
				System.out.println(entry.getKey() + "  " + entry.getValue());
			
			return entry;
		};
		
		map.entrySet().stream().forEach((entry) -> {
			func.apply(entry);
		});
		
		Function<Entry<String, Integer> , Entry<String, Integer> > func1 = entry -> 
		{
			if(entry.getKey().contains("E"))
				return entry;
			else 
				return null;
			
			
		};
		
		map.entrySet().stream().forEach((entry) -> {
			Function<Entry<String, Integer> , Entry<String, Integer> > func2 = func1.andThen(func);
			func2.apply(entry);
			
			Function<Entry<String, Integer> , Entry<String, Integer> > func3 = func.compose(func1);
			func3.apply(entry);				
		});
	}
	
}

class MYBiConsumer implements BiConsumer<HashMap<String, Integer> , String >
{

	@Override
	public void accept(HashMap<String, Integer> arg0, String arg1) {
		// TODO Auto-generated method stub
		arg0.entrySet().stream().filter(entry1 -> entry1.getKey().startsWith(arg1))
		.forEach((entry) -> System.out.print( entry.getKey() + " ") );
		System.out.println();
		
		
	}
	
}
