# Problem 74: Search a 2D Matrix

## Problem Overview
Given an m × n matrix where each row is sorted and the last element of each row is less than the first element of the next row, determine if a target value exists in the matrix.

## Solution Approach: Search from Top-Right Corner

**Time Complexity:** O(m + n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers / Smart Search

## Core Concept
Start from the top-right corner of the matrix and move towards the bottom-left. If the current element is greater than the target, move left (eliminate the column). If the current element is less than the target, move down (eliminate the row). This eliminates one entire row or column with each comparison, avoiding the need for binary search.

## Why This Works
The matrix has a special property: each row is sorted, and the last element of one row is less than the first element of the next row. This creates a "staircase" property when viewed from the top-right corner. From the top-right, larger values are to the right and below, while smaller values are to the left and above, allowing us to eliminate entire rows/columns efficiently.

## Important Insights
- **Top-Right Starting Point:** Starting from the top-right corner creates a natural ordering where you can eliminate either a row or column based on a single comparison.
- **Linear Time Complexity:** Although the matrix is sorted, a 2D binary search is unnecessary. The staircase property allows a linear scan from the top-right corner in O(m + n) time.
- **Avoids Overcomplication:** Unlike flattening the matrix into 1D and doing binary search, this approach respects the 2D structure and works efficiently with the staircase property.
- **Directional Movement:** Moving only left or down ensures you never revisit elements and always move toward the target or complete elimination of search space.

## Key Technique: Two-Pointer Search in 2D
This "staircase search" technique applies to any sorted 2D matrix with the specified property. Start from a corner where ordering is clear (top-right or bottom-left), and use single comparisons to eliminate entire rows or columns. This pattern is more efficient than nested binary searches and works well for range-based 2D searches.

## Edge Cases to Remember
- **Single Element Matrix:** Works correctly—one comparison determines if element matches.
- **Target at Corners:** Top-left and bottom-right are handled naturally by the algorithm's movement pattern.
- **Target Not in Matrix:** Correctly returns false after traversing to the boundary.
- **Entire Row/Column Comparison:** The algorithm efficiently handles cases where the target is larger or smaller than all elements in a row or column.
