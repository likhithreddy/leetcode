# Problem 94: Binary Tree Inorder Traversal

## Problem Overview
Perform an inorder traversal (left-root-right) of a binary tree and return the values of all nodes in the traversal order.

## Solution Approach: Recursive DFS

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is the height of the tree (recursion call stack)

**Technique:** Depth-First Search (DFS), Recursion

## Core Concept
Inorder traversal visits nodes in the order: left subtree → current node → right subtree. This is achieved using recursion by first traversing the left subtree, then processing the current node, and finally traversing the right subtree. This approach naturally follows the recursive structure of the tree.

## Why This Works
The recursive approach works because it directly mirrors the definition of inorder traversal. At each node, we recursively solve the problem for the left and right subtrees, then combine the results by inserting the current node's value between them. This builds the complete inorder sequence from bottom-up.

## Important Insights
- **Inorder traversal order:** Left subtree → Node → Right subtree produces a sorted sequence for binary search trees
- **Recursive elegance:** The recursive solution is clean and intuitive, directly matching the problem definition
- **Three traversal types:** Inorder, preorder, and postorder are distinguished only by when the current node is processed relative to its subtrees
- **Base case handling:** Using null checks prevents stack overflow and naturally terminates recursion

## Key Technique: Tree Traversal with DFS
Recursive tree traversal is a fundamental pattern where recursion depth equals the tree height. This technique applies to many tree problems including path finding, validation, and data collection. The key is understanding when to process the node relative to its children (pre/in/post-order).

## Edge Cases to Remember
- **Single node tree:** A tree with only root returns [root.val]
- **Null/empty tree:** An empty tree returns an empty list
- **Skewed tree:** A tree with only left or right children performs linear traversal like a linked list
- **Large tree:** Recursion stack could be deep for unbalanced trees; iterative approach with explicit stack can be used as alternative
