package com.java8.programs.interview.GS;

import java.util.*;

/*
  Instructions:
 **
 **  Given a forest ( one or more disconnected trees ), find the root of largest tree
 **  and return its Id. If there are multiple such roots, return the smallest Id of them.
 **
 **  Complete the largestTree function in the editor below.
 **  It has one parameter, immediateParent, which is a map containing key-value pair indicating
 **  child -> parent relationship. The key is child and value is the corresponding
 **  immediate parent.
 **  Constraints
 **    - Child cannot have more than one immediate parent.
 **    - Parent can have more than one immediate child.
 **    - The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
 **
 **  Example:
 **
 **  Input:
 **  { { 1 -> 2 }, { 3 -> 4} }
 **
 **  Expected output: 2
 **  Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
 **  Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.
 */

/*✅ Objective
Given a map of {child -> parent}:
Identify all roots.
Build the parent-to-children map.
For each root, use DFS to calculate the size of the tree rooted at that node.
Return the root of the largest tree (or smallest root ID if there are multiple with the same size).*/
public class LongestTree {
    public static Integer largestTree(final Map<Integer,Integer> immediateParent) {
        // Step 1: Build parent to children map
        Map<Integer, List<Integer>> parentToChild = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            Integer child = entry.getKey();
            Integer parent = entry.getValue();
            parentToChild.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            allNodes.add(child);
            allNodes.add(parent);
            children.add(child);
        }

        // Step 2: Roots are all nodes not present as children
        Set<Integer> roots = new HashSet<>(allNodes);
        roots.removeAll(children);

        // Step 3: For each root, calculate tree size
        int maxSize = 0;
        int resultRoot = Integer.MAX_VALUE;

        for (Integer root : roots) {
            int size = getTreeSize(parentToChild, root) + 1; // +1 for the root node itself
            if (size > maxSize || (size == maxSize && root < resultRoot)) {
                maxSize = size;
                resultRoot = root;
            }
        }

        return resultRoot;
    }

    public static Integer getTreeSize(final Map<Integer, List<Integer>> parentToChild, final Integer rootIndex) {
        Integer result = 0;
        final Stack<Integer> nodes = new Stack<>();
        nodes.push(rootIndex);
        while (!nodes.empty()) {
            final Integer index = nodes.pop();
            for (final Integer childIndex : parentToChild.getOrDefault(index, new ArrayList<>())) {
                nodes.push(childIndex);
                result++;
            }
        }
        return result;
    }
    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // map of test cases to expected results
        final Map<Map<Integer,Integer>, Integer> testCases = new HashMap<>();

        // example
        final Map<Integer,Integer> testCaseOneKey = new HashMap<>() {{
            put(1,2);
            put(3,4);
        }};
        testCases.put(testCaseOneKey, 2);

        // More than two trees
        final Map<Integer,Integer> testCaseTwoKey = new HashMap<>() {{
            put( 2, 3 );
            put( 7, 8 );
            put( 12, 15 );
            put( 3, 1 );
            put( 13, 15 );
            put( 11, 15 );
            put( 9, 8 );
            put( 5, 12 );
        }};
        testCases.put(testCaseTwoKey, 15);

        // really large index values
        final Map<Integer,Integer> testCaseThreeKey = new HashMap<>() {{
            put( 200000000, 300000000 );
            put( 500000000, 200000000 );
            put( 700000000, 300000000 );
            put( 600000000, 700000000 );
            put( 900000000, 400000000 );
            put( 100000000, 400000000 );
            put( 800000000, 400000000 );
            put( 1000000000, 400000000 );
        }};
        testCases.put(testCaseThreeKey, 300000000);

        // two trees of same size
        final Map<Integer,Integer> testCaseFourKey = new HashMap<>() {{
            put( 9, 4 );
            put( 1, 4 );
            put( 5, 2 );
            put( 8, 4 );
            put( 7, 3 );
            put( 2, 3 );
            put( 6, 7 );
            put( 10, 4 );
        }};
        testCases.put(testCaseFourKey, 3);

        // tree sizes differ by one
        final Map<Integer,Integer> testCaseFiveKey = new HashMap<>() {{
            put( 35, 33 );
            put( 33, 28 );
            put( 31, 22 );
            put( 28, 25 );
            put( 34, 31 );
            put( 29, 27 );
            put( 21, 23 );
            put( 25, 21 );
            put( 22, 29 );
        }};
        testCases.put(testCaseFiveKey, 23);

        boolean passed = true;
        for(Map.Entry<Map<Integer,Integer>, Integer> entry : testCases.entrySet())
        {
            final Integer actual = largestTree(entry.getKey());
            if(!actual.equals(entry.getValue()))
            {
                passed = false;
                System.out.println("Failed for " + entry.getKey().toString()
                        + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
/*📊 Time and Space Complexity
Time Complexity: O(n), where n is the number of nodes (since each node is visited once).
Space Complexity: O(n), for storing the tree in memory and for DFS stack.*/