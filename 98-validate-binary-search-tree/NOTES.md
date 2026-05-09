# Problem 98: Validate Binary Search Tree

## Problem Overview
Determine whether a given binary tree is a valid Binary Search Tree (BST). A BST is valid if for every node, all values in its left subtree are strictly less than the node's value, and all values in its right subtree are strictly greater than the node's value. This property must hold for every node in the tree, not just direct children.

## Solution Approach: DFS with Range Validation

**Time Complexity:** O(n) where n is the number of nodes (we visit each node once)  
**Space Complexity:** O(h) where h is the height of the tree (recursion stack depth)

**Technique:** Depth-First Search (DFS), Recursion, Range Validation

## Core Concept
We traverse the tree using DFS while maintaining valid min and max bounds for each node. Starting with `Long.MIN_VALUE` and `Long.MAX_VALUE` as initial bounds, we check if each node's value falls within its valid range. When recursing to the left child, we update the max bound to the current node's value (since all nodes in the left subtree must be less than the current node). When recursing to the right child, we update the min bound to the current node's value (since all nodes in the right subtree must be greater than the current node).

## Why This Works
The key insight is that BST validity isn't just about parent-child relationships, but about the *entire path* from root to a node. By maintaining range bounds that get progressively tightened as we traverse deeper, we ensure that every ancestor's constraint is satisfied. A node is valid only if it falls strictly within its allowed range (greater than min and less than max). This validates the entire BST property in a single pass.

## Important Insights
- **Range-Based Validation:** Instead of checking only immediate children, we validate each node against all constraints imposed by its ancestors. The bounds represent what values are valid at that position in the tree.
- **Strict Inequality:** The BST property requires strict inequality (`<` and `>`), not `<=` or `>=`. A node with the same value as an ancestor would violate the BST property.
- **Long vs Integer:** Using `Long.MIN_VALUE` and `Long.MAX_VALUE` avoids issues with boundary values when the tree contains `Integer.MIN_VALUE` or `Integer.MAX_VALUE` nodes.
- **Early Termination:** The solution returns false immediately when a violation is found, avoiding unnecessary traversal of invalid subtrees.

## Key Technique: Range-Based Tree Validation
This pattern of maintaining range constraints is useful for many tree validation problems where properties depend on ancestor values. Similar applications include validating balanced BSTs, finding median BST, and path sum problems. The key is identifying what constraints need to be enforced and propagating them through the recursion stack as parameters.

## Edge Cases to Remember
- **Single Node Tree:** A single node is always a valid BST (the null children are ignored and the node has no constraints).
- **Duplicate Values:** Nodes with duplicate values violate the BST property, so a tree with duplicates is invalid. The strict inequality in our condition (`node.val >= max || node.val <= min`) correctly rejects duplicates.
- **Integer Boundary Values:** If a tree contains `Integer.MIN_VALUE` or `Integer.MAX_VALUE`, using `long` for bounds (`Long.MIN_VALUE` and `Long.MAX_VALUE`) ensures we don't have overflow issues.
- **Inverted Subtrees:** A tree might look valid at the parent level but have violations deep in subtrees. Our traversal of the entire tree ensures we catch all violations regardless of depth.
- **Null Children:** Empty subtrees (null children) are valid by definition and contribute nothing to the validation process.
