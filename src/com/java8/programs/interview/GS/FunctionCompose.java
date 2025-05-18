package com.java8.programs.interview.GS;
/*"write a function compose([f1, f2,..]) such that it should return a function.
compose should accept an array of functions of variable length.
e.g.:
function add(a) {
return a+1;
}
function multiBy2(a) {
return a*2;
}
console.log(compose([add, multiBy2])(1)); // prints 3
let person = {
age: 18,
check: function(a) {
if(a<this.age) return false;
return true;
}
}
console.log(compose([person.check, multiBy2]).bind(person)(9)); // prints true"
*/
import java.util.List;
import java.util.function.Function;

class Person {
    int age;

    Person(int age) {
        this.age = age;
    }

    public boolean check(int a) {
        return a >= age;
    }
}

public class FunctionCompose {
    public static <T> Function<T, T> compose(List<Function<T, T>> functions) {
        return functions.stream()
                .reduce(Function::andThen)
                .orElseThrow(() -> new IllegalArgumentException("No functions provided"));
    }

    public static void main(String[] args) {
        Function<Integer, Integer> add = a -> a + 1;
        Function<Integer, Integer> multiBy2 = a -> a * 2;

        Function<Integer, Integer> composedFunction = compose(List.of(add, multiBy2));
        System.out.println(composedFunction.apply(1)); // prints 3

        Person person = new Person(18);
        Function<Integer, Boolean> check = person::check;
        Function<Integer, Integer> composedCheckFunction = compose(List.of(multiBy2, Function.identity()));
        Function<Integer, Boolean> finalCheckFunction = composedCheckFunction.andThen(check);
        System.out.println(finalCheckFunction.apply(9)); // prints true
    }
}
