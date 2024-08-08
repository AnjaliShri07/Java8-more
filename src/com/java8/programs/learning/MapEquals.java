package com.java8.programs.learning;

import java.util.*;
import java.util.stream.*;


public class MapEquals {

	public static void main(String[] args) {
		Map<String, String> m0 = new LinkedHashMap<>();
	    m0.put("x", "123");
	    m0.put("y", "456");
	    m0.put("z", "789");

	    Map<String, String> m1 = new LinkedHashMap<>();
	    m1.put("x", "000");
	    m1.put("y", "111");
	    m1.put("z", "222");
	    
	    List<Map<String, String>> l = Arrays.asList(m0, m1);

	    List<Map<String, String>> tx = l.stream().map(m -> m.entrySet().stream()
	            .filter(map -> map.getKey().equals("x") || map.getKey().equals("z"))
	            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())))
	        .collect(Collectors.toList());
	    System.out.println(tx);

	}

}
