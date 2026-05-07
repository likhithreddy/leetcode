# Problem 110: Balanced Binary Tree

## Problem Overview
Determine whether a binary tree is height-balanced, where a tree is balanced if the absolute difference between the heights of left and right subtrees of every node is at most 1.

## Solution Approaches Comparison

### Approach 1: Recursive Height Calculation (Brute Force)
**Time Complexity:** O(n²)  
**Space Complexity:** O(h) for recursion stack

**Key Idea:** For each node in the tree, explicitly calculate the height of its left and right subtrees by recursively traversing them. Check if the height difference exceeds 1. Then recursively check all children. The core logic is: heightOfTree(root.left) and heightOfTree(root.right) are called independently for each node, which means you're recalculating heights multiple times for the same subtrees.

**Why it's brute force:** Each node's height is recalculated every time it's referenced. For a balanced tree, every node might be visited multiple times during height calculations. Consider a call chain: checking node A requires heights of B and C, checking B requires heights of D and E, but then checking if C is balanced also requires recalculating heights of D and E. This redundant recalculation is the defining characteristic of the brute force approach.

### Approach 2: Single-Pass DFS with Early Termination (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(h) for recursion stack

**Key Idea:** Calculate heights bottom-up in a single DFS pass. The function returns either the height (if subtree is balanced) or -1 (if imbalanced). Crucially, once an imbalance is detected at any node, immediately return -1 without checking further subtrees. This early termination prevents unnecessary computation.

**Why it's optimal:** Each node is visited exactly once. Heights are computed during the post-order traversal, so no node's height is recalculated. The -1 marker enables instant propagation of imbalance information upwards through the recursion stack. On average, deeply unbalanced trees terminate much earlier than checking all nodes.

## Key Differences at a Glance
| Aspect | Brute Force (Recursive) | Optimal (DFS + Early Exit) |
|--------|------------------------|---------------------------|
| Height Recalculation | Yes - many times | No - computed once per node |
| Imbalance Detection | Continues checking after first imbalance | Stops immediately (returns -1) |
| Traversal Approach | Top-down (recompute from top) | Bottom-up post-order (compute once) |
| Worst Case Scenario | Unbalanced tree (all nodes recalculated) | Still O(n) due to early exit |

## When to Use Which
- **Brute Force:** Educational purposes, understanding the naive recursive approach, very small trees
- **Optimal:** Production code, any real-world application, especially for handling unbalanced trees

## Important Pattern/Insight
**"Return Value as State Machine"** — This pattern uses the return value to encode both computation result (height) and state (valid/invalid). By returning -1 instead of false, you turn the solution into a state-aware early-termination algorithm. This is crucial for tree problems: instead of having separate validation and calculation functions, combine them into one that returns a meaningful value (height) when valid and a sentinel value (-1) when invalid. This immediately stops traversal because any parent receiving -1 knows it's invalid and can return -1 without further computation.

## Edge Cases to Remember
- **Null tree:** Is balanced (height = 0)
- **Single node:** Is balanced
- **Completely unbalanced (linked-list structure):** Brute force recalculates O(n²) times; optimal detects immediately
- **Perfectly balanced binary tree:** Both approaches traverse all nodes, but optimal still wins on real-world unbalanced trees
- **Height difference exactly 1:** Still balanced (allow difference of AT MOST 1, not strictly less than)
