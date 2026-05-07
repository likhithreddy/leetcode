# Problem 572: Subtree of Another Tree

## Problem Overview
Given two binary trees, determine if the first tree (root) has a subtree that is identical to the second tree (subRoot). A subtree includes the node and all its descendants.

## Solution Approach: DFS with Tree Comparison

**Time Complexity:** O(n·m) where n is number of nodes in root, m is number of nodes in subRoot  
**Space Complexity:** O(min(h₁, h₂)) for recursion stack

**Technique:** Depth-First Search with Tree Equality Check

## Core Concept
Traverse the root tree using DFS. At each node, check if the subtree rooted at that node is identical to subRoot using a tree comparison function (like in Problem 100). If any node's subtree matches, return true. If no match found after traversing all nodes, return false.

## Why This Works
A subtree match occurs when some node in root has the same structure and values as subRoot. By checking each node in root to see if its subtree equals subRoot, you cover all possible subtree placements in root. Early termination when a match is found avoids unnecessary comparisons.

## Important Insights
- **Two-function approach:** One function traverses root; another function compares two trees for equality
- **Node-by-node checking:** Check each node in root as a potential starting point for subtree match
- **Traversal efficiency:** In practice, many nodes are eliminated early because they don't match the root value of subRoot
- **Space complexity:** Only recursion stacks matter; no additional data structures needed
- **Why not hash-based?** Could hash tree structures for faster comparison, but straightforward comparison is simpler and usually sufficient
- **Null handling:** Null subtrees are valid; check properly to avoid NullPointerException

## Key Technique: Multi-Function Tree Problem Solving
When comparing trees within a larger tree, decompose into: (1) traversal function, (2) comparison/validation function. Composition of simpler functions makes complex tree problems manageable.

## Edge Cases to Remember
- **Both trees null:** root has subtree that matches (null subtree matches null subRoot)
- **root null, subRoot not null:** Return false (can't find non-null subtree in null tree)
- **subRoot null:** Any node in root has null subtree, so return true
- **Identical trees:** Root tree has itself as subtree; return true
- **Single node match:** Need full subtree match, not just root node match
