# Problem 701: Insert into a Binary Search Tree

## Problem Overview
Given a binary search tree (BST) and an integer value to insert, add a new node with that value to the BST in the correct position while maintaining the BST property.

## Solution Approach: Iterative BST Insertion

**Time Complexity:** O(h) where h is height of tree (O(n) worst case, O(log n) average)  
**Space Complexity:** O(1)

**Technique:** Binary Search Tree Traversal with Node Insertion

## Core Concept
Use the BST property to navigate to the correct insertion position. Start at the root and compare the value to insert with each node: if smaller, go left; if larger, go right. Continue until finding an empty spot (null child), then insert the new node there. This maintains the BST invariant—all left descendants are smaller, all right descendants are larger.

## Why This Works
The BST property ensures that by following the comparison-based navigation, we reach the unique position where the new value belongs. Inserting at the first available null child maintains the BST property because all existing values have already been correctly positioned relative to the insertion point during the previous tree construction and insertions.

## Important Insights
- **BST property guides placement:** Each comparison eliminates one entire subtree, ensuring we reach exactly the right position in O(h) time
- **Null child indicates insertion point:** No need for explicit rebalancing; inserting at the first null child maintains BST structure
- **Iterative vs Recursive:** Iterative uses O(1) space instead of O(h) call stack; both have same time complexity
- **Edge case: empty tree:** Must handle root == null separately; new node becomes the root
- **No duplicates requirement:** Problem typically assumes all values are unique; behavior with duplicates depends on implementation choice

## Key Technique: BST Navigation for Insertion
The pattern: when inserting into a BST, use value comparisons to navigate to the correct position without searching or rebalancing. This pattern extends to all BST operations (search, delete, successor/predecessor). The efficiency comes from the binary decision tree created by value comparisons—O(h) navigation instead of O(n) search through unsorted data.

## Edge Cases to Remember
- **Empty tree:** If root is null, new node becomes the root
- **Inserting smallest value:** Navigates all the way left to the leftmost leaf, inserts as left child
- **Inserting largest value:** Navigates all the way right to the rightmost leaf, inserts as right child
- **Inserting between existing nodes:** Correctly finds the leaf position based on comparison chain
- **Single node tree:** Works correctly; navigates to either left or right of the single node
