# Problem 1137: N-th Tribonacci Number

## Problem Overview
You are asked to compute the nth Tribonacci number, where the sequence starts with `T0 = 0`, `T1 = 1`, `T2 = 1`, and every later term is the sum of the previous three terms.

## Solution Approach: Space-Optimized Dynamic Programming

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Dynamic Programming with Rolling Variables

## Core Concept
The Tribonacci sequence is defined entirely by the previous three values, so we only need to keep a sliding window of those states. Start with `0, 1, 1`, then iteratively compute the next value as their sum and shift the window forward. This produces the answer in one pass without storing the full sequence.

## Why This Works
Each Tribonacci term depends only on the three immediately preceding terms, so the recurrence has fixed depth and no branching choice. Because the sequence is deterministic, preserving the last three values is sufficient to reconstruct the next one exactly. Induction on n shows that after each loop iteration, the rolling variables hold the correct consecutive Tribonacci values.

## Important Insights
- **Base cases drive everything:** `T0 = 0`, `T1 = 1`, and `T2 = 1` must be handled directly before the loop.
- **Only three states matter:** Unlike full DP arrays, no earlier term can affect future values once the last three are known.
- **Rolling update order matters:** Shift the variables after computing the new term so the previous values are not lost too early.
- **Sequence grows predictably:** The recurrence is linear and monotonic for n >= 2, so the algorithm is straightforward and stable.

## Key Technique: Rolling DP for Fixed-Width Recurrences
When a recurrence depends on a small, fixed number of prior states, replace the array with a few variables that roll forward each step. This pattern appears in Fibonacci-style problems, staircase counting variants, and other sequences with bounded lookback.

## Edge Cases to Remember
- **n = 0:** Return 0 directly.
- **n = 1:** Return 1 directly.
- **n = 2:** Return 1 directly.
- **Small n in general:** The loop should start at 3 so the base terms are never overwritten.