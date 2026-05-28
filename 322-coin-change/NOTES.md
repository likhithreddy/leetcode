# Problem 322: Coin Change

## Problem Overview
Given an integer array `coins` of distinct denominations and an integer `amount`, return the fewest number of coins needed to make up that amount. If the amount cannot be made up by any combination of coins, return `-1`. You may assume an infinite supply of each coin.

## Solution Approach: Dynamic Programming

**Time Complexity:** O(amount × n) where n is the number of coin denominations  
**Space Complexity:** O(amount)

**Technique:** Dynamic Programming (Bottom-Up Tabulation, Unbounded Knapsack variant)

## Core Concept
Define `dp[i]` as the minimum number of coins needed to make amount `i`. For every amount from `1` to `amount`, try each coin `c`: if `i - c >= 0`, then making `i` requires `1 + dp[i - c]` coins (one current coin plus the best way to make the remainder). The recurrence `dp[i] = min(dp[i], 1 + dp[i - c])` over all coins finds the optimum, with `dp[0] = 0` (zero coins make zero amount) and all other entries initialized to a sentinel `amount + 1` representing "unreachable."

## Why This Works
Coin Change has optimal substructure — the best way to make amount `i` using a final coin `c` is exactly `1 + (best way to make i - c)`, since each coin choice is independent and unlimited. By trying every coin as the last one used and taking the minimum, we exhaustively consider all final-coin choices without missing any combination. Building up from `dp[0]` ensures that every `dp[i - c]` is already optimal when we need it, so the running minimum at `dp[i]` is provably the global optimum for that amount.

## Important Insights
- **Sentinel value `amount + 1`:** Acts as "infinity" — guaranteed larger than any valid answer (at most `amount` coins of denomination 1), and chosen over `Integer.MAX_VALUE` to avoid overflow in `1 + dp[i - coin]`
- **Order of loops:** Outer loop over amounts, inner loop over coins — this counts combinations correctly because each `dp[i]` only depends on smaller amounts already computed; the coin order doesn't matter since we want a count of coins, not number of ways
- **Unbounded reuse:** Unlike 0/1 knapsack, the same coin can be used multiple times — the recurrence naturally allows this because `dp[i - c]` may itself have already used coin `c`
- **Final check for unreachability:** If `dp[amount]` still equals the sentinel after the loop, no combination produces `amount`, so return `-1`

## Key Technique: Unbounded Knapsack / Minimum-Cost DP
This is the canonical "minimum items to reach a target" DP pattern where items can be reused: define `dp[target]` as the optimum to reach that target, then for each item, relax `dp[target] = min(dp[target], cost + dp[target - weight])`. The same template solves problems like Perfect Squares, Minimum Number of Refueling Stops, and Word Break (with count). The "outer over targets, inner over items" loop order is the giveaway that the same item can be reused unboundedly — flipping the loop order would count distinct combinations instead.

## Edge Cases to Remember
- **Amount is 0:** `dp[0] = 0` directly; the inner loop never runs and we return `0` (zero coins make zero amount)
- **No valid combination (e.g., `coins=[2], amount=3`):** `dp[3]` remains at `amount + 1`, triggering the `-1` return path
- **Coin larger than amount:** The `i - coin >= 0` guard skips it entirely, so large denominations never corrupt smaller dp entries
- **Single coin of denomination 1:** Always reachable — `dp[i] = i` for all i, giving a trivial linear answer
