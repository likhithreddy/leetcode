# Problem 70: Climbing Stairs

## Problem Overview
You are climbing a staircase with n steps. Each time you can climb either 1 or 2 steps. Find the total number of distinct ways to reach the top.

## Solution Approach: Space-Optimized Dynamic Programming

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Dynamic Programming with Space Optimization

## Core Concept
Recognize that the number of ways to reach step n is the sum of ways to reach step n-1 and step n-2 (since you can climb 1 or 2 steps to reach n). This creates a Fibonacci-like recurrence relation: ways(n) = ways(n-1) + ways(n-2). Instead of storing all previous results in an array, we use two variables to track only the last two values, eliminating the need for extra space beyond O(1).

## Why This Works
The recurrence relation works because every path to step n must come from either step n-1 or step n-2. By the fundamental principle of counting, the total number of distinct ways to reach n is the sum of distinct ways to reach the two positions just before it. The base cases are: ways(1) = 1 (one way: climb 1 step) and ways(2) = 2 (two ways: climb 1+1 or climb 2). From there, each subsequent step follows the recurrence naturally. We only need the previous two values at any given time, so we can use variables prev1 and prev2 instead of a full array.

## Important Insights
- **Fibonacci pattern:** The climbing stairs problem creates a Fibonacci sequence in the answer. This is a classic DP optimization pattern.
- **Base cases matter:** For n=1, answer is 1; for n=2, answer is 2. These seed the recurrence.
- **Space optimization:** While we could use an array of size n, storing only the last two values reduces space from O(n) to O(1).
- **Variable naming:** Using prev2 (steps back two positions) and prev1 (steps back one position) makes the logic clear and maintainable.
- **Boundary condition:** The special case n <= 2 is handled separately since we directly return n for these small inputs.

## Key Technique: Fibonacci DP Pattern
Whenever you have a recurrence that depends on a fixed number of previous states (typically the last 1-2 values), you can optimize from O(n) space to O(1) space by using variables instead of arrays. This pattern extends to many problems: house robber, best time to buy/sell stock (with cooldown), and more. Recognize when a DP problem has this structure and apply variable-based space optimization.

## Edge Cases to Remember
- **n = 1:** Returns 1 (one way: take 1 step)
- **n = 2:** Returns 2 (two ways: take 1+1 steps or take 2 steps)
- **n = 3:** Returns 3 (three ways: 1+1+1, 1+2, 2+1)
- **Large n:** The algorithm remains O(n) time with O(1) space, scaling efficiently even for large inputs
