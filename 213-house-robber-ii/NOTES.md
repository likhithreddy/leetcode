# Problem 213: House Robber II

## Problem Overview
You are given an integer array `nums` representing money in houses arranged in a **circle**, where the first and last houses are adjacent. You cannot rob two adjacent houses. Return the maximum amount of money you can rob without alerting the police.

## Solution Approach: Two-Pass Linear DP with Space Optimization

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Dynamic Programming reduced to two House-Robber-I subproblems

## Core Concept
The circular adjacency between house 0 and house n-1 means at most one of them can be robbed. Split the problem into two independent linear subproblems: rob the range `[0..n-2]` (skip the last house) or rob the range `[1..n-1]` (skip the first house). Each subproblem is solved with the standard House Robber I recurrence `current = max(prev2 + nums[i], prev1)` using two rolling variables, and the final answer is the larger of the two results.

## Why This Works
The only difference from House Robber I is the circular constraint, which forbids picking both ends simultaneously. By enumerating the two mutually exclusive cases — "house 0 is available, house n-1 is not" vs. "house n-1 is available, house 0 is not" — we guarantee at least one branch matches the optimal solution, since any valid robbery either includes house 0 or it doesn't, and excluding it covers the case where house n-1 is robbed. Within each subproblem the array is now linear, so the proven House Robber I DP applies directly. Taking the max across both branches yields the global optimum.

## Important Insights
- **Reduce to a known problem:** The circular twist disappears once you split on whether house 0 is in the robbery set; both halves become House Robber I
- **Rolling variables suffice:** `prev1` (best up to i-1) and `prev2` (best up to i-2) replace the DP array, giving O(1) space per pass
- **Inclusive range matters:** `robOption(nums, 0, n-2)` and `robOption(nums, 1, n-1)` must be inclusive on both ends so the two passes together cover every position exactly once across the two cases
- **n ≤ 2 must short-circuit:** With one or two houses the "circle" degenerates — both ends are the same or adjacent — so the split would produce empty/overlapping ranges; handle directly

## Key Technique: Case Splitting to Remove a Global Constraint
When a constraint links two endpoints (circular arrays, paired choices, mutually exclusive picks), enumerate the small set of cases that resolve the constraint and solve each case as an unconstrained subproblem. Here, "circle → two linear arrays" is the canonical transform; the same pattern shows up in problems like "Maximum Sum Circular Subarray" (handled via wrap vs. non-wrap cases) and "Binary Tree Cameras" with paired states. The win is converting one hard problem into k easy ones, where k is the number of constraint resolutions.

## Edge Cases to Remember
- **Single house (n == 1):** Return `nums[0]`; the circle is a self-loop with nothing to skip
- **Two houses (n == 2):** Return `max(nums[0], nums[1])`; they're adjacent in the circle so only one can be robbed
- **Three houses:** Splits into ranges `[0..1]` and `[1..2]`, each producing a single rob; max of the three values wins
- **All zeros:** Both passes return 0; the max comparison is still correct
