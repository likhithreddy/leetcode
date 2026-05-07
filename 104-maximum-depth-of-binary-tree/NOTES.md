# Problem 104: Maximum Depth of Binary Tree

## Problem Overview
Find the maximum depth of a binary tree, where depth is the number of nodes along the longest path from root to leaf.

## Solution Approach: Recursive DFS Traversal

**Time Complexity:** O(n) where n is number of nodes  
**Space Complexity:** O(h) where h is tree height, for recursion stack

**Technique:** Depth-First Search (Recursive)

## Core Concept
Recursively calculate the depth: if node is null, return 0 (base case). Otherwise, recursively find the maximum depth of left and right subtrees, then return 1 plus the maximum of these two depths. This bottom-up approach naturally computes the depth of each subtree before computing the depth of its parent.

## Why This Works
Depth is defined recursively: the depth of a tree is 1 plus the maximum depth of its subtrees. This recursive definition maps directly to recursive implementation. The base case (null node = depth 0) provides natural termination. Post-order traversal (process children before parent) naturally computes depths from bottom up.

## Important Insights
- **Leaf node depth:** A single node has depth 1 (not 0; count the node itself)
- **Null vs leaf:** Null node returns 0; leaf node returns 1
- **Height vs depth:** This problem uses depth; height is sometimes defined as edges rather than nodes
- **Space consideration:** Recursion depth equals tree height; very unbalanced trees could hit stack limits
- **Efficiency:** Processes each node exactly once; no redundant calculations
- **Why not BFS?** Both BFS and DFS work; DFS is more intuitive here due to recursive definition

## Key Technique: Recursive Bottom-Up Tree Computation
When calculating properties that depend on subtree properties (max, min, sum, etc.), use recursion with post-order traversal. Process children first, then use their results to compute the current node's value. This pattern applies to: tree height, tree diameter, path sum, and many other tree property calculations.

## Edge Cases to Remember
- **Null tree:** Depth is 0
- **Single node:** Depth is 1
- **Linear tree (all left children):** Depth equals number of nodes
- **Balanced tree:** Depth approximately log(n)
- **Completely unbalanced tree:** Depth equals n (could cause stack overflow with recursion)
