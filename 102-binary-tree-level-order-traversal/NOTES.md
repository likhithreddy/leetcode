# Problem 102: Binary Tree Level Order Traversal

## Problem Overview
Perform a level order (breadth-first) traversal of a binary tree, returning the node values organized by level as a list of lists.

## Solution Approach: BFS with Queue

**Time Complexity:** O(n) where n is number of nodes  
**Space Complexity:** O(w) where w is maximum width of tree

**Technique:** Breadth-First Search (Queue-Based)

## Core Concept
Use a queue to process nodes level by level. Initialize queue with root node. While queue is not empty: (1) record current queue size (this represents one level), (2) dequeue and process that many nodes (one level), (3) enqueue their non-null children. This ensures each level is processed together, producing the level-by-level output.

## Why This Works
A queue naturally maintains FIFO order, processing nodes in the order they appear in the tree level by level. By dequeuing exactly queue.size() nodes in each iteration, you ensure that each iteration processes exactly one complete level before moving to the next level. This level-by-level processing is what produces the desired level-order output.

## Important Insights
- **Queue size as level indicator:** The size of the queue at the start of each iteration tells you how many nodes are at the current level
- **Critical detail:** Record queue.size() before the inner loop because queue.size() changes as you enqueue children
- **Why not recursion?** While recursive DFS with depth tracking exists, BFS is more natural for level-order and avoids managing depth explicitly
- **Space complexity:** Maximum width matters more than total nodes; a tree can be very wide (approaching O(n)) or very tall (O(1))
- **Null child handling:** Only enqueue non-null children; simplifies logic compared to enqueueing null values

## Key Technique: Queue-Based Level Processing
When processing tree level by level, use a queue and process exactly queue.size() elements per iteration. This pattern applies to: level-order traversal, level-order predecessor, tree width problems, and other level-based tree problems.

## Edge Cases to Remember
- **Single node tree:** Returns [[root.val]]
- **Null tree:** Returns empty list
- **Linear tree (only left children):** Width is always 1
- **Complete binary tree:** Width maximized at level below root
- **Single branch from root:** Correctly returns one value per level
