package com.java8.programs.practice;

import java.util.*;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
public class containsDuplicate {

    public static boolean containsDuplicateNumber(List<Integer> myList){
        Set<Integer> set = new HashSet<>(myList);
        if(set.size() == myList.size())
            return false;
        else
            return true;
    }


    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1,2,3,1);  //1,2,3,4
        System.out.println(containsDuplicateNumber(myList));
    }
}
