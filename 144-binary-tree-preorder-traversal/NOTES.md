# Problem 144: Binary Tree Preorder Traversal

## Problem Overview
Perform a preorder traversal (root-left-right) of a binary tree and return the values of all nodes in the traversal order.

## Solution Approach: Recursive DFS

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is the height of the tree (recursion call stack)

**Technique:** Depth-First Search (DFS), Recursion

## Core Concept
Preorder traversal visits nodes in the order: current node → left subtree → right subtree. This is achieved using recursion by first processing the current node, then recursively traversing the left subtree, and finally traversing the right subtree. This approach is useful for creating a copy of the tree or serializing it.

## Why This Works
The recursive approach works because it directly implements the preorder traversal definition. At each node, we immediately add its value to the result, then solve the problem recursively for its left and right subtrees. This order naturally processes parents before children, which is essential for tree copying and prefix-based operations.

## Important Insights
- **Preorder traversal order:** Node → Left subtree → Right subtree is useful for tree serialization and copying
- **Parent-first processing:** The current node is processed before its children, making this traversal useful for reconstructing tree structure
- **Three traversal types:** Inorder, preorder, and postorder differ only in when the current node is processed relative to its subtrees
- **Base case handling:** Using null checks prevents stack overflow and naturally terminates recursion

## Key Technique: Tree Traversal with DFS
Recursive tree traversal is a fundamental pattern where recursion depth equals the tree height. The order in which you process the node versus its children (pre/in/post-order) determines the properties of the traversal. Preorder is particularly useful when you need to process parents before children.

## Edge Cases to Remember
- **Single node tree:** A tree with only root returns [root.val]
- **Null/empty tree:** An empty tree returns an empty list
- **Skewed tree:** A tree with only left or right children performs linear traversal like a linked list
- **Large tree:** Recursion stack could be deep for unbalanced trees; iterative approach with explicit stack can be used as alternative
