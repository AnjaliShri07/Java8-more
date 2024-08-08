package com.java8.programs.learning;

// Reference to constructor
interface Information
{  
    Show getInfo(String msg);  
}  
class Show{  
    Show(String msg)
    {  
        System.out.print(msg);  
    }  
}  
public class ExampleOfMethodReferences {

	public static void main(String[] args) {
		 Information info = Show::new;  
	        info.getInfo("JAVAGOAL");

	}

}
