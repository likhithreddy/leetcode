# Problem 198: House Robber

## Problem Overview
You are given an integer array `nums` representing the amount of money in each house on a street. You cannot rob two adjacent houses (the alarm will trigger). Return the maximum amount of money you can rob without alerting the police.

## Solution Approach: Dynamic Programming

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Dynamic Programming (Bottom-Up Tabulation)

## Core Concept
At each house i, you have two choices: rob it (and add `nums[i]` to the best total from house i-2) or skip it (and keep the best total from house i-1). The recurrence `dp[i] = max(dp[i-2] + nums[i], dp[i-1])` captures both possibilities, and `dp[n-1]` holds the maximum money obtainable across the entire street. Base cases anchor the recurrence: `dp[0] = nums[0]` (rob the only house) and `dp[1] = max(nums[0], nums[1])` (pick the richer of the first two).

## Why This Works
The problem has optimal substructure — the best solution for houses `[0..i]` depends only on the best solutions for `[0..i-1]` and `[0..i-2]`. Since adjacency is the only constraint, every decision at house i is independent given the two previous best totals; we never need to track *which* houses were robbed, only the running maximum. Taking the max at each step guarantees we never lock ourselves into a suboptimal prefix, and induction over i proves `dp[i]` is the true maximum for the first i+1 houses.

## Important Insights
- **Decision per house:** At every index, the choice collapses to "rob and skip the neighbor" vs. "skip this one"; no other states matter
- **Why i-2, not i-1, when robbing:** Robbing house i forbids house i-1, so the previous compatible total comes from `dp[i-2]`
- **Base case dp[1]:** Must be `max(nums[0], nums[1])` rather than `nums[1]` — you are free to skip house 1 entirely if house 0 is richer
- **No need to track which houses:** The DP value alone is sufficient; reconstruction of the actual robbed set is unnecessary for this problem

## Key Technique: Linear DP with "Take or Skip" Recurrence
This is the canonical "non-adjacent selection" DP pattern: whenever you must pick elements from a sequence under an adjacency or distance constraint, define `dp[i]` as the best answer using the prefix ending at i and choose between including `nums[i]` (jumping back over the forbidden gap) or excluding it. The same template solves problems like Min Cost Climbing Stairs, Delete and Earn, and House Robber II. Space can be further optimized to O(1) by keeping only the last two values, since the recurrence has depth 2.

## Edge Cases to Remember
- **Single house (n == 1):** Return `nums[0]` directly; the DP loop never runs
- **Two houses (n == 2):** Return `max(nums[0], nums[1])`; you can only rob one of them
- **All houses equal:** DP still picks every other house correctly — the recurrence is value-agnostic
- **Zero values in array:** Treated like any other value; the max comparison naturally avoids picking them when a better alternative exists
