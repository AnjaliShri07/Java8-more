package com.java8.programs.interview.GS;

import java.util.NoSuchElementException;

public class StringDeque {
    private static class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size = 0;

    // Add to front
    public void addFirst(String item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add to end
    public void addLast(String item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove from front
    public String removeFirst() {
        if (head == null) throw new NoSuchElementException("Deque is empty");
        String val = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return val;
    }

    // Remove from end
    public String removeLast() {
        if (tail == null) throw new NoSuchElementException("Deque is empty");
        String val = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return val;
    }

    // Peek front
    public String peekFirst() {
        if (head == null) return null;
        return head.data;
    }

    // Peek last
    public String peekLast() {
        if (tail == null) return null;
        return tail.data;
    }

    // Size
    public int size() {
        return size;
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print contents
    public void printDeque() {
        Node current = head;
        System.out.print("Deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Demo
    public static void main(String[] args) {
        StringDeque deque = new StringDeque();
        deque.addFirst("world");
        deque.addFirst("Hello");
        deque.addLast("from");
        deque.addLast("Java");

        deque.printDeque(); // Hello world from Java

        System.out.println("Removed first: " + deque.removeFirst()); // Hello
        System.out.println("Removed last: " + deque.removeLast()); // Java

        deque.printDeque(); // world from
    }
}
