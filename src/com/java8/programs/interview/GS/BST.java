package com.java8.programs.interview.GS;

import java.util.*;

/*Let's complete your Binary Search Tree (BST) implementation by:
Implementing the put(int value) method to insert nodes.
Implementing the contains(int value) method to search for values.
Fixing the bug in the inOrderTraversal(Node, List) method — the current traversal is not in-order.*/
public class BST {
        // Node class
        private static class Node {
            Integer val;
            Node left;
            Node right;
        }

        private Node root;

        public BST() {
            this.root = null;
        }

        // Insert value into BST
        public void put(int value) {
            root = insert(root, value);
        }

        private Node insert(Node node, int value) {
            if (node == null) {
                node = new Node();
                node.val = value;
                return node;
            }

            if (value < node.val) {
                node.left = insert(node.left, value);
            } else if (value > node.val) {
                node.right = insert(node.right, value);
            }
            return node; // do nothing if value already exists
        }

        // Search value in BST
        public boolean contains(int value) {
            return search(root, value);
        }

        private boolean search(Node node, int value) {
            if (node == null) return false;
            if (value == node.val) return true;
            if (value < node.val) return search(node.left, value);
            return search(node.right, value);
        }

        // Return in-order traversal
        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) return;
            inOrderTraversal(node.left, acc);
            acc.add(node.val);                    // ✅ Fix: moved to correct position
            inOrderTraversal(node.right, acc);

    }

    public static void main(String[] args) {

        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        if (
                Arrays.asList(1, 2, 3, 5).equals(searchTree.inOrderTraversal())
                        && !searchTree.contains(0)
                        && searchTree.contains(1)
                        && searchTree.contains(2)
                        && searchTree.contains(3)
                        && !searchTree.contains(4)
                        && searchTree.contains(5)
                        && !searchTree.contains(6)
        ) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
