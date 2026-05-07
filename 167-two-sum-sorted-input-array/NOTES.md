# Problem 167: Two Sum II - Input Array Is Sorted

## Problem Overview
Given a sorted array and a target sum, find two distinct numbers that add up to the target. Return 1-indexed positions. You are guaranteed exactly one solution and cannot use the same element twice.

## Solution Approach: Two Pointers from Both Ends

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers with Greedy Movement

## Core Concept
Position left pointer at the start (index 0) and right pointer at the end (index n-1). Calculate sum of numbers at both pointers. If sum equals target, return the indices. If sum is less than target, increment left pointer (need larger sum). If sum is greater than target, decrement right pointer (need smaller sum). Continue until target is found.

## Why This Works
The array is sorted, so you can use this property: if sum is too small, the smaller number needs to increase (move left pointer right); if sum is too large, the larger number needs to decrease (move right pointer left). Starting from both ends maximizes the initial range, and each movement eliminates values that can't possibly work (if current sum is too small, the left endpoint is too small and can be skipped entirely).

## Important Insights
- **Sorted prerequisite:** This approach requires sorted input; unsorted array needs HashMap approach
- **Space advantage:** O(1) space because you're not storing values, just tracking positions
- **Greedy movement:** Moving toward the target is safe; if current sum is too small, you'll never use the left pointer at its current position again
- **Index conversion:** If problem requires 1-indexed (as this one does), add 1 to returned indices
- **Why not binary search?** You'd still need to check pairs, making binary search less efficient than two pointers here

## Key Technique: Two-Pointer on Sorted Data
For sorted arrays with target sums or comparisons, two pointers from both ends enable O(n) solutions. The sorted property guarantees that moving inward makes progress toward the goal.

## Edge Cases to Remember
- **Target at the smallest possible sum:** Numbers are first and last elements
- **Target at the largest possible sum:** Same as above (depends on values)
- **All positive numbers:** Works correctly
- **Mixed positive and negative:** Arithmetic remains unchanged
- **Return format:** Problem requires 1-indexed; don't forget to add 1
