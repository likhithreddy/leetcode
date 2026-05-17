# Problem 875: Koko Eating Bananas

## Problem Overview
Koko has h hours to eat bananas from n piles. She eats k bananas per hour from a pile and must finish a pile before moving to the next. Find the minimum eating speed k to eat all bananas within h hours.

## Solution Approach: Binary Search

**Time Complexity:** O(n * log(max_pile))  
**Space Complexity:** O(1)

**Technique:** Binary Search on the answer space

## Core Concept
Instead of trying every possible speed linearly, we use binary search to find the minimum speed. The key insight is that if Koko can eat all bananas at speed k, she can also eat them at any speed greater than k. This monotonic property allows us to binary search. We search between speed 1 (minimum) and the largest pile size (maximum speed needed).

## Why This Works
The problem has a monotonic property: if a speed is sufficient, all higher speeds are also sufficient. Binary search exploits this by eliminating half of the search space in each iteration. Instead of checking every speed from 1 to max_pile (which would be O(n * max_pile)), we reduce it to O(n * log(max_pile)).

## Important Insights
- **Monotonic Property:** If speed k allows completion, so does k+1. This is essential for binary search validity.
- **Search Space Boundaries:** Minimum speed is 1, maximum is max_pile. There's no need to search higher than the largest pile.
- **Ceiling Division Trick:** Use `(pile + speed - 1) / speed` instead of Math.ceil to calculate hours for a pile without floating-point arithmetic.
- **Binary Search Pattern:** Find the minimum valid value in a monotonic range using left and right boundaries.

## Key Technique: Binary Search on Answer Space
Binary search doesn't only work on sorted arrays. It's powerful for finding the optimal value in monotonic problem spaces. When you have a condition that becomes "true" at some threshold value and remains "true" beyond that, binary search can find that threshold efficiently. This pattern applies to min/max optimization problems, constraint satisfaction, and resource allocation problems.

## Edge Cases to Remember
- **Single Pile:** If there's only one pile, the minimum speed is ceil(pile_size / h). The algorithm handles this naturally.
- **Many Hours:** If h is very large (larger than number of piles), the minimum speed is 1 (eat one banana per hour).
- **Large Piles:** Maximum pile size determines the upper bound. Without the upper bound set correctly, the algorithm would search unnecessarily high.
- **Decimal Hours:** When calculating hours needed, use ceiling division `(pile + speed - 1) / speed` to properly account for partial piles.
