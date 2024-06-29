package com.java8.interview.program.string;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*Flatten the list of strings into a stream of characters.
(optional in case of using Set)Use the distinct() method to filter out duplicate characters.
Collect the result into a list or any other collection.*/

public class DistinctCharacterFinder {
    public static Set<Character> findDistinctCharacters(List<String> strings) {
        return strings.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                //.distinct()
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Set<Character> distinctChars = findDistinctCharacters(strings);
        System.out.println("Distinct characters: " + distinctChars);
    }
}

/*Explanation:
List Initialization: A list of strings strings is initialized with some values.

Streaming and Flattening:

        strings.stream() creates a stream of strings.
        .flatMapToInt(CharSequence::chars) flattens each string into an IntStream of its characters.
        .mapToObj(c -> (char) c) converts each integer (character code) back to a char.
Collecting to Set:

        .collect(Collectors.toSet()) collects the characters into a Set, which automatically removes duplicates
        to give us distinct characters.
Printing the Result:

        System.out.println("Distinct characters: " + distinctCharacters); prints the distinct characters found in
        the list of strings.
This program effectively uses Java 8 streams to find and print the distinct characters present across all strings in the
list. The use of flatMapToInt allows easy transformation and flattening of data, making the solution concise and efficient.*/
