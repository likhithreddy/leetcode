# Problem 746: Min Cost Climbing Stairs

## Problem Overview
You are given an integer array `cost` where `cost[i]` is the cost of the i-th step on a staircase. You can either climb 1 or 2 steps. Find the minimum cost to reach the top of the staircase, where you can start from either step 0 or step 1.

## Solution Approach: Space-Optimized Dynamic Programming

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Dynamic Programming with Space Optimization

## Core Concept
At each step i, the minimum cost to reach that step is the cost of the current step plus the minimum cost from either the previous step (i-1) or the step before that (i-2). Instead of maintaining a full DP array, we use two variables to track only the costs of the last two steps, achieving constant space complexity. We iterate through the array updating these variables, and finally return the minimum of the costs at the last two positions since we can exit from either.

## Why This Works
The problem has optimal substructure: to minimize cost at step i, we examine where we came from (step i-1 or i-2) and pick the path with lower accumulated cost. Every position can be reached from at most two previous positions. By recognizing that we only need the previous two costs at any time (not the entire history), we can replace an O(n) DP array with two variables. This works because DP computes values sequentially; once we've processed step i, we never need step i-2 again—only steps i and i-1 matter for computing step i+1. The final answer is the minimum of the last two costs because you can step off from either position.

## Important Insights
- **Space optimization pattern:** Many DP problems where recurrence depends on only the last few states can be optimized from O(n) space to O(1) space using rolling variables
- **Variable roles:** prev1 tracks the cost to reach the most recent step, prev2 tracks the cost to reach the step before that
- **Exit flexibility:** Unlike standard climbing stairs, you exit from either the last or second-to-last step, so the answer isn't just the final position
- **Current cost matters:** At each step, you must pay the cost of that step, then choose the cheaper path from the two previous positions
- **Initialization:** Start with prev2 = cost[0] and prev1 = cost[1], representing the cost to reach steps 0 and 1 respectively

## Key Technique: Minimum Cost Path DP with Space Optimization
Whenever you need to find minimum/maximum cost to reach positions with limited predecessor choices, use DP with a recurrence relation. When that recurrence depends on only the last k values, optimize space by using k variables instead of an array. This pattern applies to house robber, best time to buy/sell stock problems, and other constrained movement scenarios. The key insight: if you process sequentially and only reference recent values, you don't need to store everything.

## Edge Cases to Remember
- **Array of length 2:** You can start from step 0 or 1, so the answer is min(cost[0], cost[1])
- **Cost at first step:** Paying cost[0] is one option to start; process only step 1 next
- **Cost at second step:** Paying cost[1] is another option to start; process from step 2 onward
- **Reaching last vs second-to-last:** Both positions allow exiting, so compare their accumulated costs
