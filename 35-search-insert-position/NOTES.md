# Problem 35: Search Insert Position

## Problem Overview
Given a sorted array and a target value, return the index where the target exists or the position where it should be inserted to keep the array sorted.

## Solution Approach: Recursive Binary Search

**Time Complexity:** O(log n)  
**Space Complexity:** O(log n)

**Technique:** Binary Search, Recursion

## Core Concept
The sorted order lets us discard half of the search space on each step. If the middle value matches the target, we return that index immediately; otherwise, we recurse into the half that could still contain the target.

If the search range becomes invalid, the low pointer already marks the first position where the target can be inserted without breaking the sorted order.

## Why This Works
Binary search preserves the invariant that the target, if present, must lie within the current range. Once the range collapses, the low index is exactly the insertion point because everything to the left is smaller and everything to the right is larger.

This makes the base case more useful than a simple failure return: it produces the correct insertion index even when the value is absent.

## Important Insights
- **Sorted input is essential:** The half-elimination logic only works because values are ordered.
- **Insertion point from low:** When the range is empty, low is the first valid slot for the target.
- **Exact match short-circuits early:** If the middle equals the target, no further search is needed.
- **Recursion adds stack cost:** The algorithm is still logarithmic in work, but recursive calls add O(log n) space.

## Key Technique: Binary Search for Lower Bound
This pattern is useful whenever you need either the position of a value or the first place it could be inserted. The same idea generalizes to lower-bound and upper-bound searches in sorted collections.

## Edge Cases to Remember
- **Empty array:** Return 0 because the target would be inserted at the start.
- **Target smaller than all values:** Return 0.
- **Target larger than all values:** Return nums.length.
- **Target already present:** Return its exact index, not an insertion point.