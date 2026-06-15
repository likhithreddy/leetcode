# Problem 145: Binary Tree Postorder Traversal

## Problem Overview
Perform a postorder traversal (left-right-root) of a binary tree and return the values of all nodes in the traversal order.

## Solution Approach: Recursive DFS

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is the height of the tree (recursion call stack)

**Technique:** Depth-First Search (DFS), Recursion

## Core Concept
Postorder traversal visits nodes in the order: left subtree → right subtree → current node. This is achieved using recursion by first recursively traversing the left subtree, then the right subtree, and finally processing the current node. This approach is useful for operations that require processing children before parents, such as deleting a tree.

## Why This Works
The recursive approach works because it directly implements the postorder traversal definition. At each node, we recursively process both the left and right subtrees first, then add the current node's value to the result. This "children-first" order is essential for operations like tree deletion, where you must free children before their parent.

## Important Insights
- **Postorder traversal order:** Left subtree → Right subtree → Node is useful for tree deletion and bottom-up processing
- **Children-first processing:** The current node is processed after its children, making this traversal essential for destructive operations
- **Three traversal types:** Inorder, preorder, and postorder differ only in when the current node is processed relative to its subtrees
- **Base case handling:** Using null checks prevents stack overflow and naturally terminates recursion

## Key Technique: Tree Traversal with DFS
Recursive tree traversal is a fundamental pattern where recursion depth equals the tree height. The order in which you process the node versus its children (pre/in/post-order) determines the properties of the traversal. Postorder is particularly useful for operations that depend on processing children before parents.

## Edge Cases to Remember
- **Single node tree:** A tree with only root returns [root.val]
- **Null/empty tree:** An empty tree returns an empty list
- **Skewed tree:** A tree with only left or right children performs linear traversal like a linked list
- **Large tree:** Recursion stack could be deep for unbalanced trees; iterative approach with explicit stack can be used as alternative
