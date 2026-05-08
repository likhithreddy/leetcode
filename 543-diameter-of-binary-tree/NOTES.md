# Problem 543: Diameter of Binary Tree

## Problem Overview
Find the length of the diameter of a binary tree, where the diameter is the length of the longest path between any two nodes in the tree. The path doesn't have to pass through the root.

## Solution Approach: DFS with Simultaneous Diameter Tracking

**Time Complexity:** O(n) where n is number of nodes  
**Space Complexity:** O(h) where h is tree height, for recursion stack

**Technique:** Depth-First Search (Recursive) with Running Maximum

## Core Concept
Use a DFS helper function that calculates the height of each node while simultaneously tracking the maximum diameter. For each node, the diameter passing through that node equals the sum of heights of its left and right subtrees (the longest path down the left plus the longest path down the right). Track the maximum of all such diameters. Return the height (1 + max height of children) to enable parent nodes to use this value.

## Why This Works
The diameter is the longest path between any two nodes. This path at any given node consists of the longest path down the left subtree and the longest path down the right subtree. By checking every node as a potential "peak" of the diameter and calculating what the diameter would be if it passed through that node, you capture the global maximum. A single DFS traversal visiting each node exactly once computes all necessary values: heights for each subtree and all possible diameters.

## Important Insights
- **Global variable for diameter:** Use a class-level or passed variable to track the maximum diameter found so far; local variables won't persist across recursive calls
- **Height definition:** Height of null node is 0; height of leaf is 1 (include the node itself)
- **Diameter at each node:** For any node, diameter through it = leftHeight + rightHeight; update global max if this is larger
- **Return value is height:** The recursive function must return the height for parent nodes to use, not the diameter
- **Single pass efficiency:** Computing diameter and height together in one DFS avoids recalculating heights (which would be O(n²) if done separately)
- **Path doesn't need root:** Unlike some tree problems, the longest path can connect any two nodes, not just going through root

## Key Technique: Global State Tracking During DFS
When you need to find a global maximum/minimum property while traversing a tree, maintain a class or reference variable to track the best value found. This pattern applies to: diameter of tree, longest path in tree, tree properties that depend on comparing values across different branches. Separating the value you compute locally (height) from the value you track globally (diameter) is a powerful pattern.

## Edge Cases to Remember
- **Null tree:** Diameter is 0
- **Single node:** Diameter is 0 (longest path is the node itself, length 0)
- **Linear tree (only left or right children):** Diameter is the height minus 1 (path from root to deepest leaf)
- **Balanced tree:** Diameter may not pass through root; could be in a subtree
- **Two nodes:** Diameter is 1 (path between the two nodes)
