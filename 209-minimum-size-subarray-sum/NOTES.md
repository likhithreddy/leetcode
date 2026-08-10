# Problem 209: Minimum Size Subarray Sum

## Problem Overview
Given an array of positive integers `nums` and a positive integer `target`, find the minimal length of a contiguous subarray of which the sum is at least `target`. If there is no such subarray, return `0`.

## Solution Approach: Sliding Window (Two Pointers)

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Sliding Window / Two Pointers

## Core Concept
Use a variable-size sliding window with two indices `left` and `right`. Expand `right` to increase the running sum until it meets or exceeds `target`. Then advance `left` to shrink the window as much as possible while the sum stays ≥ `target`, updating the minimal length along the way. Because all numbers are positive, shrinking the window always decreases the sum, so this process is correct and each element is visited at most twice.

## Why This Works
With positive integers, increasing the right pointer only increases the sum and moving the left pointer only decreases it. Therefore, once the running sum reaches or exceeds `target`, contracting from the left can only reduce the window length while we still maintain the sum constraint. This monotonic behavior guarantees correctness and linear time.

## Important Insights
- **Positive values guarantee monotonicity:** Sliding-window shrinking is safe only because nums[i] > 0; otherwise additional checks are required.
- **Two-pointer amortized visits:** Each element is added once and removed once — O(n) total operations.
- **Update answer when condition met:** Always record the window size as soon as sum ≥ target before attempting to shrink.
- **Early exit when minimal possible reached:** If you find a window of size 1 that satisfies the target, you can return 1 immediately.

## Key Technique: Sliding Window
This pattern applies when you need a subarray (contiguous block) meeting a cumulative constraint (sum, product, distinct count). Use two pointers to expand until the constraint is satisfied, and then contract greedily to restore minimality; maintain running aggregate values to avoid re-scanning.

## Edge Cases to Remember
- **Empty array:** Return `0`.
- **No valid subarray:** Return `0` if the total sum of `nums` < `target`.
- **Single element equals/greater than `target`:** Return `1`.
- **All elements greater than `target`:** Handled by immediate window checks when expanding.
- **Large `target`:** If `target` is larger than total sum, return `0` without much work.

---

Place this `NOTES.md` alongside `MinimumSizeSubarraySum.java` in the problem folder.
