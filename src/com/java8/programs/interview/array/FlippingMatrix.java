package com.java8.programs.interview.array;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlippingMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;

        return IntStream.range(0, n)
                .map(i -> IntStream.range(0, n)
                        .map(j -> Math.max(
                                Math.max(matrix.get(i).get(j), matrix.get(i).get(2 * n - 1 - j)),
                                Math.max(matrix.get(2 * n - 1 - i).get(j), matrix.get(2 * n - 1 - i).get(2 * n - 1 - j))
                        ))
                        .sum())
                .sum();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimension of the matrix
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read the matrix elements into a List<List<Integer>>
        List<List<Integer>> matrix = IntStream.range(0, 2 * n)
                .mapToObj(i -> {
                    return IntStream.range(0, 2 * n)
                            .mapToObj(j -> scanner.nextInt())
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList());

        // Calculate and print the result
        int result = flippingMatrix(matrix);
        System.out.println(result);

        scanner.close();
    }

    }

