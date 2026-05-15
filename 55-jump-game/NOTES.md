# Problem 55: Jump Game

## Problem Overview
Determine if you can jump to the last index of an array starting from the first index, where each element represents the maximum length of a forward jump you can take.

## Solution Approaches Comparison

### Approach 1: Dynamic Programming (Bottom-Up)
**Time Complexity:** O(n²)  
**Space Complexity:** O(n)

**Key Idea:** Build a boolean dp array from the end backwards where dp[i] represents whether position i can reach the end. For each position, check all possible jumps from that position (1 to nums[i] steps forward) and mark the current position as true if any of those jumps reach a position marked as true.

**Why it's brute force:** For every position, we iterate through all possible jumps we can make from that position. In the worst case, this creates a nested loop structure that checks every reachable position from every index, leading to quadratic time complexity with unnecessary redundant checks.

### Approach 2: Greedy Strategy (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Key Idea:** Maintain a `max` variable that tracks the furthest index we can currently reach. Iterate through the array once, and for each index, update the maximum reachable index by comparing it with the current jump distance (i + nums[i]). If at any point the current index exceeds the maximum reachable distance, we cannot proceed.

**Why it's optimal:** The greedy approach processes each element exactly once with a single forward pass. By tracking only the maximum reach as we go, we avoid checking all possible jumps from each position. The key insight is that if we can reach a position, we can also reach any position before it, so we only need to know the furthest point we can reach.

## Key Differences at a Glance
| Aspect | DP Approach | Greedy Approach |
|--------|------------|---------|
| **Approach** | Bottom-up dynamic programming working backward | Single-pass greedy forward iteration |
| **Time Complexity** | O(n²) due to nested loops | O(n) with single iteration |
| **Space Complexity** | O(n) for dp array | O(1) constant space |
| **Key Variable** | Boolean array tracking reachability | Single integer tracking max reach |

## When to Use Which
- **DP Approach:** When learning/understanding the reachability concept for the first time or when you need to reconstruct the actual jump path taken.
- **Greedy Approach:** In production code or interviews when you need optimal time and space complexity with the simplest logic.

## Important Pattern/Insight
**"Furthest Reach Greedy"** — This pattern applies to jump problems where you only care about whether you can reach the end or the optimal outcome (not the path itself). Instead of exploring all possibilities, maintain a running maximum of the furthest position reachable. This transforms problems that seem to require exponential exploration into linear-time solutions. Apply this when the question is "can we reach X?" or "what's the maximum we can achieve?" rather than "which specific path should we take?".

## Edge Cases to Remember
- **[Array of length 1]:** Both approaches return true immediately since you're already at the end. DP marks the last position as true, greedy returns true without entering the loop.
- **[Zero at first position]:** Both approaches handle correctly. DP marks position 0 as false (can't jump anywhere), greedy returns false since max stays 0 and condition i > max triggers at position 1.
- **[Large jumps]:** Both approaches work correctly. DP marks multiple positions as true, greedy updates max to a larger value and continues.
- **[Alternating high/low values]:** Greedy shines here by only needing to track max reach, while DP must check all possibilities for each position, showing the efficiency difference.
