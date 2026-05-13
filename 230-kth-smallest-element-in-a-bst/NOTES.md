# Problem 230: Kth Smallest Element in a BST

## Problem Overview
Given the root of a binary search tree and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

## Solution Approach: In-order Traversal (DFS)

**Time Complexity:** O(k) in best case, O(n) in worst case  
**Space Complexity:** O(h) where h is the height of the tree (recursion call stack)

**Technique:** Depth-First Search (DFS), In-order Traversal

## Core Concept
In a binary search tree, an in-order traversal (left → root → right) visits nodes in ascending sorted order. We perform a recursive in-order traversal while maintaining a count of visited nodes. When the count equals k, we have found the kth smallest element and return its value immediately. This avoids unnecessary traversal of remaining nodes.

## Why This Works
By leveraging the BST property, we know that in-order traversal inherently visits nodes in sorted order. Since k represents the position in sorted order, we can simply count nodes as we traverse and stop as soon as we reach the kth node. This is much more efficient than constructing a sorted list first.

## Important Insights
- **In-order Traversal:** The key property of BST is that in-order traversal gives elements in sorted order (ascending). This directly maps to finding the kth smallest element.
- **Early Termination:** By returning immediately when we find the kth element, we avoid unnecessary traversal of the right subtree, making it more efficient than building a complete sorted array.
- **Count Tracking:** Using a class-level counter allows us to maintain state across recursive calls. This counter is crucial for tracking which position we're at in the sorted sequence.
- **Recursive Call Chain:** When we find the answer in a recursive call, we propagate it back through the call stack by returning non-zero values, which signals to parent calls to stop further processing.

## Key Technique: In-order Traversal DFS
In-order traversal is a fundamental tree traversal pattern where you visit nodes in the order: left subtree → current node → right subtree. In a BST, this produces elements in sorted order, making it useful for problems involving sorted sequences, nth smallest/largest elements, and validation. This pattern applies to any problem where you need elements from a BST in sorted order without actually creating a sorted array.

## Edge Cases to Remember
- **Single Node Tree:** If k=1, return the root's value immediately. The algorithm handles this correctly by incrementing count and checking k on the root.
- **k at End:** If k equals the total number of nodes (n), the kth smallest element is the largest. In-order traversal will eventually reach the rightmost node.
- **Unbalanced Tree:** If the tree is skewed (like a linked list), space complexity approaches O(n) due to deep recursion, but the algorithm still works correctly.
- **Return Value Convention:** The function returns 0 when not found and the actual value when found. This works because BST values can be negative, so we use non-zero return values as indicators of "found" state in the recursion.
