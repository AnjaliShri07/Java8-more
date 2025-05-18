package com.java8.programs.interview.GS;

import java.util.Stack;
import java.util.stream.IntStream;

public class QueueUsingStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        IntStream.of(1, 2, 3, 4, 5).forEach(queue::enqueue);

        // Dequeue elements
        IntStream.range(0, 5).forEach(i -> {
            try {
                System.out.println("Dequeued: " + queue.dequeue());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
