# Problem 226: Invert Binary Tree

## Problem Overview
Invert a binary tree by swapping the left and right child of every node, transforming the tree into its mirror image.

## Solution Approach: Recursive Post-Order Traversal

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is tree height, for recursion stack

**Technique:** Depth-First Search (Recursive)

## Core Concept
Recursively invert the tree: if the node is null, return null. Otherwise, recursively invert the left subtree and right subtree, then swap them. The swap operation reverses the children at each node, and the recursive calls ensure all descendants are also inverted.

## Why This Works
Tree inversion is fundamentally about swapping children, which naturally maps to recursion. Process each subtree (both children first via post-order), then perform the swap at the current node. The recursive structure ensures every node gets its children swapped.

## Important Insights
- **Post-order traversal:** Process children (invert them) before processing the current node (swapping)
- **Swap mechanism:** Temporary variable holds one child; reassign using the other; no temporary needed in Java if using assignment
- **Leaf node handling:** Null children swap to null children (no visible change, but consistent)
- **Mirror image:** After inversion, left subtree structure mirrors the original right subtree
- **Why recursion?** Recursion naturally expresses the recursive structure of trees; iterative approach would need explicit stack
- **Simplicity:** This is one of the simplest tree problems; even during interviews, the recursive solution is elegant

## Key Technique: Recursive Tree Transformation
When transforming or modifying tree structures, recursion is natural. Process subtrees first (post-order), then apply transformation to the current node. This pattern applies to: inverting trees, cloning trees with modifications, and other structural tree changes.

## Edge Cases to Remember
- **Null tree:** Returns null (nothing to invert)
- **Single node:** Returns the same node (no children to swap)
- **Already inverted tree:** Inverting twice returns to original
- **Linear tree (only left children):** Becomes tree with only right children
- **Perfectly balanced tree:** Structure remains balanced after inversion
