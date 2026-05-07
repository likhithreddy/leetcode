# Problem 11: Container With Most Water

## Problem Overview
Given an array representing heights of vertical lines, find two lines that together with the x-axis form a container that holds the maximum amount of water. Water capacity is determined by the height of the shorter line and the distance between them.

## Solution Approach: Two Pointers from Ends

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers with Greedy Movement

## Core Concept
Start with pointers at both ends of the array (maximum width). Calculate the water area: width × min(height[left], height[right]). Track the maximum area seen. Then move the pointer pointing to the smaller height inward (decrement left pointer if left height is smaller, increment right if right is smaller). Continue until pointers meet.

## Why This Works
The critical insight is movement direction: moving the pointer with the larger height inward can never improve the area because the width decreases and the limiting factor (minimum height) can only stay the same or decrease. Moving the smaller pointer gives us a chance to find a taller line that might compensate for the lost width. This greedy approach guarantees we won't miss the optimal solution: every potential container area is either evaluated or provably cannot be better than what we've already seen.

## Important Insights
- **Width always decreases:** Each iteration reduces the gap between pointers by 1, so area can only improve if height increases significantly
- **Height is the bottleneck:** Water level is determined by the shorter line, so improving the shorter line is the only way to improve area
- **Greedy is safe:** We're not looking for all containers, just the maximum. Moving away from a smaller line is always safe because width is already decreasing
- **Early termination:** Unlike nested loop that checks all pairs, this checks only O(n) pairs
- **Visual intuition:** Imagine pointers as moving boundaries; you shrink from outside because middle areas are guaranteed to be worse (smaller width)

## Key Technique: Greedy Two-Pointer Movement
When you have a two-pointer scenario with one dimension (width) always decreasing, use a greedy strategy: move the pointer associated with the limiting factor (smaller height). This reduces O(n²) pair checking to O(n) linear traversal.

## Edge Cases to Remember
- **Two elements only:** Returns max area (only one possible container)
- **All same height:** Maximum area is at the widest span (first and last)
- **Strictly increasing heights:** Optimal area is at the ends despite lower heights elsewhere due to width advantage
- **Strictly decreasing heights:** Optimal area is still at the ends
- **Multiple identical max areas:** Algorithm finds one of them (correctness of area value, not index)
