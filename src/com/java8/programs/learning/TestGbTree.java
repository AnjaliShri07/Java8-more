package com.java8.programs.learning;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.function.Predicate;



public class TestGbTree {

	
	// Represents a node of an n-ary tree 
	static class Node 
	{ 
	    HashMap<String, Integer> key = new HashMap<String, Integer>(); 
	    Vector<Node>child = new Vector<>(); 
	}; 
	  
	// Utility function to create a new tree node 
	static Node newNode(String key, Integer value) 
	{ 
	    Node temp = new Node(); 
	    temp.key.putIfAbsent(key, value); 
	    return temp; 
	} 
	
	
	// Prints the n-ary tree level wise 
	static void LevelOrderTraversal(Node root) 
	{ 
	    if (root == null) 
	        return; 
	  
	    // Standard level order traversal code 
	    // using queue 
	    Queue<Node> q = new LinkedList<>(); // Create a queue 
	    q.add(root); // Enqueue root  
	    while (!q.isEmpty()) 
	    { 
	        int n = q.size(); 
	  
	        // If this node has children 
	        while (n > 0) 
	        { 
	            // Dequeue an item from queue 
	            // and print it 
	            Node p = q.peek(); 
	            q.remove(); 
	            System.out.print(p.key + " "); 
	  
	            // Enqueue all children of  
	            // the dequeued item 
	            for (int i = 0; i < p.child.size(); i++) 
	                q.add(p.child.get(i)); 
	            n--; 
	        } 
	          
	        // Print new line between two levels 
	        System.out.println();  
	    } 
	} 
	
	
	static void TraverseThrough (Node root, LinkedList<String> arr ) 
	{ 
		
		Integer count = 0;
		
		System.out.println(new DateTime());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String temp = "";
		String temp1= "";
		Boolean nextcall = false;
		Node d= null;
		for(String a: arr)
		{
			if(!temp.equalsIgnoreCase(""))
				{
					temp1 = temp;
					temp = temp + "_"+ a;
				}
			else
				temp = a;
			
			if(nextcall)
			{
				d = searchAll(root,temp1,a,map);
			}
			else
			{
				 d = search(root,temp,map);
			}
			if(d==null)
			{
				temp = temp1;
				nextcall=true;
			}
			//System.out.println(d!=null?d.key.entrySet():0);
			
			
		}
		
		//System.out.println("DEBA count" + count);
		map.entrySet().forEach((entry) -> {
			 
			System.out.println("KEY   ::" + entry.getKey() + "  VALUE  ::" + entry.getValue());
		});
		
		 count= map.entrySet()
			      .stream()
			      .reduce(
			       (0),(data,entry)-> data+ entry.getValue(), Integer::sum);
		 System.out.println("Count :: "+ count);
		 
		 System.out.println(new DateTime());
		
	}
	
	static Node search(Node node, String nodeName, HashMap<String, Integer> map) {
		
		if(node!=null)
		{
			if(node.key.containsKey(nodeName))
				{
					map.put(nodeName, node.key.get(nodeName));
					return node;
				}
			
			Vector<Node> children = node.child;
			   for(Node child1 : children) { 
			      Node resultChild = search(child1, nodeName, map);
			      if (resultChild != null)
			    	  {
			    	  	return resultChild;
			    	  }

			   }
		}
		
		

		 return null;
		}
	
	
	static Node searchAll(Node node, String nodeName, String nodename1, HashMap<String, Integer> map) {
		
		
		Predicate<String> dbpredicate = a -> a.contains(nodeName);
		Predicate<String> dbpredicate1 = a -> a.startsWith(nodename1);
		
		if(node!=null)
		{
			
			if(node.key.keySet().parallelStream().allMatch(dbpredicate.and(dbpredicate1)) )
				{
					map.put(nodeName, node.key.get(nodeName));
					return node;
				}
			
			Vector<Node> children = node.child;
			   for(Node child1 : children) { 
			      Node resultChild = search(child1, nodeName, map);
			      if (resultChild != null)
			    	  {
			    	  	return resultChild;
			    	  }

			   }
		}
		
		

		 return null;
		}
	
	// Driver Code 
	public static void main(String[] args)  
	{ 
	      
	    /* Let us create below tree 
	    *             10 
	    *     / / \ \ 
	    *     2 34 56 100 
	    *     / \         | / | \ 
	    *     77 88     1 7 8 9 
	    */
	    Node root = newNode("SE", 12345); 
	    (root.child).add(newNode("123", 123456)); 
	    /*(root.child).add(newNode(34)); 
	    (root.child).add(newNode(56)); 
	    (root.child).add(newNode(100));*/ 
	    (root.child.get(0).child).add(newNode("123_S_1", 123)); 
	    (root.child.get(0).child).add(newNode("123_S_2",234)); 
	    (root.child.get(0).child.get(0).child).add(newNode("123_S_1_F_1", 111)); 
	    (root.child.get(0).child.get(0).child).add(newNode("123_S_1_F_2", 12));
	    (root.child.get(0).child.get(1).child).add(newNode("123_S_2_F_1", 222)); 
	    (root.child.get(0).child.get(1).child).add(newNode("123_S_2_F_2", 12));
	    
	    (root.child.get(0).child.get(0).child.get(0).child).add(newNode("123_S_1_F_1_en", 11));
	    (root.child.get(0).child.get(0).child.get(0).child).add(newNode("123_S_1_F_1_sv", 12));
	    (root.child.get(0).child.get(0).child.get(0).child).add(newNode("123_S_1_F_1_fi", 14));
	    
	    (root.child.get(0).child.get(0).child.get(1).child).add(newNode("123_S_1_F_2_en", 15));
	    (root.child.get(0).child.get(0).child.get(1).child).add(newNode("123_S_1_F_2_sv", 16));
	    (root.child.get(0).child.get(0).child.get(1).child).add(newNode("123_S_1_F_2_fi", 17));
	    
	    (root.child.get(0).child.get(1).child.get(0).child).add(newNode("123_S_2_F_1_en", 13));
	    (root.child.get(0).child.get(1).child.get(0).child).add(newNode("123_S_2_F_1_sv", 12));
	    (root.child.get(0).child.get(1).child.get(0).child).add(newNode("123_S_2_F_1_fi", 14));
	    
	  
	    System.out.println("Level order traversal " +  
	                            "Before Mirroring "); 
	    LevelOrderTraversal(root); 
	    
	    
	    LinkedList<String> arr = new LinkedList<String>();
	    //arr.add("SE");
	    arr.add("123");
	    arr.add("S_1");
	    arr.add("F_1");
	    arr.add("en");
	    TraverseThrough(root, arr);
	    
	    LinkedList<String> arr1 = new LinkedList<String>();
	    //arr1.add("SE");
	    arr1.add("123");
	    arr1.add("S_1");
	    //arr.add("F_1");
	    arr1.add("en");
	    //arr.add("sv");
	    TraverseThrough(root, arr1);
	    
	    LinkedList<String> arr2 = new LinkedList<String>();
	    //arr2.add("SE");
	    arr2.add("123");
	    arr2.add("S_1");
	    arr2.add("F_2");
	    arr2.add("en");
	    //arr.add("sv");
	    TraverseThrough(root, arr2);
	} 
} 
	  

