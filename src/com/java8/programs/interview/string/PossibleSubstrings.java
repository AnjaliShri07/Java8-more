package com.java8.programs.interview.string;

import java.util.List;
import java.util.stream.*;

public class PossibleSubstrings {
    public static void main(String[] args) {
        String input = "abcd";

   List<String> substrings = IntStream.range(0, input.length())
                    .boxed()
                    .flatMap(i-> IntStream.range(i+1, input.length()+1)
                                        .mapToObj(j->input.substring(i, j)))
                    .collect(Collectors.toList());
        System.out.println(substrings);
    }
}

/*
* Let’s say input = "abc".

1. IntStream.range(0, input.length())
Creates an IntStream from 0 to input.length() - 1.

For "abc" → IntStream = [0, 1, 2] (indexes of the string).

2. .boxed()
Converts the primitive int stream into a Stream<Integer>.

3. .flatMap(...)
For each index i, it creates a stream of substrings that start at i.

4. IntStream.range(i + 1, input.length() + 1)
For each starting index i, generates all possible ending indexes j (exclusive).

So, for:

i = 0 → j = [1, 2, 3]
i = 1 → j = [2, 3]
i = 2 → j = [3]

5. .mapToObj(j -> input.substring(i, j))
For each pair (i, j), extract substring from index i to j (exclusive).

For "abc":
i=0: "a", "ab", "abc"
i=1: "b", "bc"
i=2: "c"

6. .collect(Collectors.toList())
Collects all substrings into a List<String>.*/

/*
* 🔍 Step-by-step Breakdown:
1. IntStream.range(0, input.length())
Generates an IntStream of indices from 0 to input.length() - 1.

Each i is a starting index of a substring.

2. .boxed()
Converts the IntStream to a Stream<Integer> (because flatMap works on objects, not primitives).

3. .flatMap(i -> IntStream.range(i + 1, input.length() + 1)...)
For each starting index i, it generates an ending index j that runs from i + 1 to input.length().

j is the end index (exclusive) for the substring.

4. .mapToObj(j -> input.substring(i, j))
For each i and j, it creates the substring input.substring(i, j).

substring(i, j) extracts a substring starting at index i and ending at j - 1.

5. .collect(Collectors.toList())
Collects all the generated substrings into a List<String>.*/