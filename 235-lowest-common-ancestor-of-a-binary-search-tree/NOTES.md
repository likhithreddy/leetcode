# Problem 235: Lowest Common Ancestor of a Binary Search Tree

## Problem Overview
Given a binary search tree (BST) and two nodes p and q, find the lowest common ancestor (LCA)—the deepest node that has both p and q as descendants.

## Solution Approach: BST Property Traversal

**Time Complexity:** O(h) where h is height of tree (O(n) worst case, O(log n) average)  
**Space Complexity:** O(1)

**Technique:** Binary Search Tree Property Navigation

## Core Concept
Leverage the BST property (left subtree values < parent < right subtree values) to efficiently navigate to the LCA without exploring all nodes. Starting from the root, if both p and q values are less than the current node, move to the left subtree; if both are greater, move to the right; otherwise, the current node is the LCA. This avoids unnecessary traversals and finds the answer in a single path down the tree.

## Why This Works
The BST property guarantees that at the point where the traversal "splits" (one value goes left and one goes right, or one equals the current node), we've found the deepest node with both as descendants. Since BST values are ordered, we can determine direction without examining subtree structures, making this direct path approach optimal and correct.

## Important Insights
- **BST property enables direct navigation:** Unlike a general binary tree, BST property allows us to determine which subtree contains each node without searching
- **LCA is where paths diverge:** The LCA is exactly where the two nodes would follow different directions (or where we find one of them)
- **Iterative is optimal:** Recursive solution has same complexity but uses O(h) space; iterative saves this space
- **Single pass efficiency:** We visit at most h nodes, never backtrack or explore unnecessary branches
- **Node comparison is sufficient:** We never need to call a search function; simple value comparisons guide us

## Key Technique: Binary Search Tree Path Navigation
The pattern: when searching in a BST, use the BST property to eliminate entire subtrees with a single comparison. This transforms a potentially O(n) search into O(h) where h is tree height. This technique generalizes to any BST search problem—it's the core efficiency gain of using a BST over an unordered tree.

## Edge Cases to Remember
- **Both nodes on left subtree:** LCA is left child, correctly found by left traversal
- **Both nodes on right subtree:** LCA is right child, correctly found by right traversal
- **One node is the LCA:** If p or q is an ancestor of the other, that node is the LCA (when current == p or q, return immediately)
- **Root is the LCA:** Handled naturally when p is on left and q is on right of root
- **Nodes not in tree:** Algorithm assumes p and q exist in tree; if assumptions violated, behavior is undefined per problem constraints
