# Problem 767: Reorganize String

## Problem Overview
Rearrange the characters in a string so that no two adjacent characters are the same, or return an empty string if that is impossible.

## Solution Approach: Greedy With Max Heap

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Greedy, Max Heap, Frequency Counting

## Core Concept
Count how many times each character appears, then always place the currently most frequent character into the next available slot. Filling the result at even indices first, then odd indices, keeps repeated characters separated as much as possible.

Before building the answer, check the feasibility bound: if the most frequent character appears more than half the string length rounded up, no valid reorganization exists.

## Why This Works
The character with the highest frequency is the limiting factor, because it needs enough spacing to avoid adjacency conflicts. By distributing that character across alternating positions first, we guarantee it is separated from itself as long as the feasibility bound holds.

Once the highest-frequency characters are placed safely, the remaining characters fit into the leftover slots without breaking the adjacency rule.

## Important Insights
- **Feasibility check first:** If the max frequency exceeds \((n + 1) / 2\), the problem has no solution.
- **Even positions first:** Spreading characters across indices 0, 2, 4, ... maximizes separation.
- **Odd positions as fallback:** After even positions fill up, continue at index 1, then 3, then 5.
- **Frequency drives placement order:** Greedy placement works because the most constrained character must be handled first.

## Key Technique: Greedy Placement by Frequency
This pattern shows up when one item type can dominate the arrangement and create conflicts if placed too densely. Use frequency counts or a priority queue to repeatedly place the most constrained element first, then spread the rest around it.

## Edge Cases to Remember
- **Impossible frequency distribution:** Return an empty string when one character appears too often.
- **Single character string:** Return the string itself because it is already valid.
- **All characters unique:** Any ordering works, and the greedy fill still succeeds.
- **One dominant character near the limit:** The alternating-slot strategy should still keep copies separated.