# Problem 1448: Count Good Nodes in Binary Tree

## Problem Overview
A good node is defined as a node where the value of the node is greater than or equal to the maximum value on the path from the root to that node. The task is to count how many good nodes exist in the binary tree.

## Solution Approach: DFS with Path Maximum Tracking

**Time Complexity:** O(n) where n is the number of nodes (we visit each node once)  
**Space Complexity:** O(h) where h is the height of the tree (recursion stack depth)

**Technique:** Depth-First Search (DFS), Recursion

## Core Concept
We traverse the binary tree using DFS recursion while maintaining the maximum value seen on the path from the root to the current node. At each node, we check if the node's value is greater than or equal to this maximum. If so, it's a "good node" and we increment our count. We then update the maximum if the current node's value is greater, and recursively process the left and right subtrees.

## Why This Works
This approach correctly identifies good nodes by comparing each node's value against the maximum value encountered on the path from root to that node. Since we update the maximum as we traverse deeper into the tree, we maintain the correct running maximum for each path. The DFS traversal ensures we visit all nodes exactly once, capturing all good nodes in the tree.

## Important Insights
- **Good Node Definition:** A node is "good" if `node.val >= maxOnPathFromRoot`. The maximum is initially `Integer.MIN_VALUE` at the root, allowing the root to always be a good node if it's the maximum (which it always is relative to nothing).
- **Path-Based Maximum:** The key insight is that we need to track the maximum value *on the path from root to current node*, not the global maximum. Each different path has its own maximum, which is why we pass it as a parameter through the recursion.
- **Update Strategy:** After checking if the current node is good, we update `currentMax` to be the maximum of itself and the current node's value before recursing into children. This ensures children see the correct maximum on their path.
- **Optimal Tracking:** By passing the maximum as a parameter, we avoid needing extra data structures (like storing paths) and keep the solution space-efficient with only O(h) space for the recursion stack.

## Key Technique: DFS with State Tracking
This pattern of carrying state (the currentMax) through recursive calls is powerful for tree problems where properties depend on the path taken. Similar problems that use this pattern include finding paths with specific properties, checking BST validity (where you need min/max bounds), and calculating path sums. The key is identifying what state needs to be maintained along the path and passing it through the recursion.

## Edge Cases to Remember
- **Single Node Tree:** A single node is always a good node since it has no parent and is compared against `Integer.MIN_VALUE`, so it will always satisfy `node.val >= Integer.MIN_VALUE`.
- **All Nodes Same Value:** If all nodes have the same value, all nodes will be good nodes (since `node.val >= maxOnPath` will always be true as the max gets set to that value at the root).
- **Decreasing Path:** In a strictly decreasing path (e.g., [10, 5, 3, 1]), only the root is a good node since each child is smaller than the maximum seen so far on the path.
- **Null Children:** We handle null nodes by returning 0 immediately, which correctly contributes nothing to the count for branches that don't exist.
