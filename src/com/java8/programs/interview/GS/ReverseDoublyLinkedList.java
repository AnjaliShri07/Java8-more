package com.java8.programs.interview.GS;

public class ReverseDoublyLinkedList {
    // Node class representing a node in a doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head of the list
    Node head;

    // Function to reverse the doubly linked list using recursion
    public Node reverseRecursively(Node node) {
        // Base case: if the node is null or it is the last node, return the node
        if (node == null || node.next == null) {
            return node;
        }

        // Recursively reverse the next node
        Node rest = reverseRecursively(node.next);

        // Swap the next and prev pointers for the current node
        node.next.next = node;  // Make the next node's next pointer point to the current node
        node.prev = node.next;  // Make the current node's prev pointer point to the next node
        node.next = null;       // Set the current node's next to null (it will become the new tail)

        // Return the new head of the reversed list
        return rest;
    }

    // Function to print the doubly linked list
    public void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to push a new node to the list (adding at the end)
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Main method to test the recursive reversal
    public static void main(String[] args) {
        ReverseDoublyLinkedList list = new ReverseDoublyLinkedList();

        // Add nodes to the list
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original List:");
        list.printList(list.head);

        // Reverse the list recursively
        list.head = list.reverseRecursively(list.head);

        System.out.println("Reversed List:");
        list.printList(list.head);
    }
}
