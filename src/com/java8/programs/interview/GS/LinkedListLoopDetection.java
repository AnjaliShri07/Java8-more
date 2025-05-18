package com.java8.programs.interview.GS;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListLoopDetection {
    public static void main(String[] args) {
        // Creating a linked list with a loop for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop

        System.out.println("Does the linked list have a loop? " + hasLoop(head));
    }

    public static boolean hasLoop(Node head) {
        Set<Node> visitedNodes = new HashSet<>();

        return Stream.iterate(head, node -> node != null && !visitedNodes.contains(node), node -> {
            visitedNodes.add(node);
            return node.next;
        }).anyMatch(node -> node != null && visitedNodes.contains(node));
    }
}
