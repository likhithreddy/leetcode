# Problem 100: Same Tree

## Problem Overview
Given two binary trees, determine if they are the same. Two trees are the same if they have identical structure and node values at each corresponding position.

## Solution Approach: Recursive DFS Comparison

**Time Complexity:** O(min(n, m)) where n and m are number of nodes in each tree  
**Space Complexity:** O(min(h₁, h₂)) for recursion stack, where h₁ and h₂ are tree heights

**Technique:** Depth-First Search (Recursive)

## Core Concept
Recursively compare two trees by: (1) checking if both nodes are null (base case: both trees end here, they're equal), (2) checking if one is null and other isn't (different structures), (3) checking if node values differ (different values), (4) recursively checking that left subtrees match AND right subtrees match. Return true only if all checks pass.

## Why This Works
Tree comparison is fundamentally a structural matching problem that naturally maps to recursion. Each recursive call handles a subtree comparison, moving down the tree. Base cases (both null, one null, values differ) provide natural termination. The recursive structure mirrors the tree structure, making the code intuitive and easy to verify.

## Important Insights
- **Early termination on mismatch:** As soon as a mismatch is found, return false; no need to continue traversing
- **Order of checks matters:** Check nullability first (avoid NullPointerException on value access)
- **Traversal efficiency:** Only visits nodes until a difference is found; doesn't necessarily traverse entire trees
- **Why recursion?** Recursion naturally expresses tree structure; iterative approach would require explicit stack management
- **Comparison operation:** This pattern extends to many tree problems: valid BST, merge trees, copy tree, etc.

## Key Technique: Recursive Tree Traversal for Structural Validation
When comparing or validating tree structures, recursion is the natural fit. Each call validates one node and delegates subtree validation to recursive calls. This pattern is fundamental to tree programming.

## Edge Cases to Remember
- **Both trees null:** Same (both empty)
- **One tree null, other not:** Different
- **Single node trees:** Compares node values
- **Trees with negative values:** No special handling; comparison works normally
- **Duplicate values in different positions:** Algorithm correctly identifies as different if structure differs
