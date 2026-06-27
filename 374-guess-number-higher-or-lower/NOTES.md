# Problem 374: Guess Number Higher or Lower

## Problem Overview
Guess a hidden integer in the range [1, n] by repeatedly calling a predefined guess API that returns whether the current guess is too high, too low, or correct.

## Solution Approach: Binary Search

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

**Technique:** Binary Search

## Core Concept
The solution uses the fact that the answer is within a sorted search space. By maintaining a low and high boundary and checking the middle value, the range can be halved on each step until the correct number is found.

## Why This Works
Each guess partitions the possible answers into two disjoint ranges: values less than the midpoint and values greater than the midpoint. Because the feedback tells us which side contains the target, the search continues only on the valid half, guaranteeing that the correct number is eventually reached.

## Important Insights
- **Sorted search space:** The problem is essentially a search in a sorted interval.
- **Halving the range:** Each comparison removes about half of the remaining candidates.
- **Efficient feedback:** The guess API provides enough information to apply binary search directly.
- **No extra memory needed:** Only a few pointers are required.

## Key Technique: Binary Search
Binary search is the standard approach whenever the solution space is ordered and can be narrowed by comparing against a midpoint. It is especially useful for problems that require finding a target value with logarithmic time complexity.

## Edge Cases to Remember
- **n = 1:** The only possible answer is 1.
- **Target at the boundary:** The leftmost or rightmost value should still be found correctly.
- **Repeated feedback:** The algorithm should handle the case where the midpoint is guessed multiple times across iterations.
