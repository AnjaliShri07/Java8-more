package com.tricky.map;

import java.util.HashMap;
import java.util.Map;

class A{
    private String name;

}
public class Demo1 {
    public static void main(String[] args){
        Map<A, String> map = new HashMap<>();
        A a = new A();
        map.put(a, "");
        map.put(a, "2");
        String str = map.get(a);
        System.out.println(str);
    }
}
