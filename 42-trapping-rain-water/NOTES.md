# Problem 42: Trapping Rain Water

## Problem Overview
Given an array representing elevation heights at each position, calculate how much rainwater can be trapped between the heights after it rains. Water fills gaps and is bounded by the heights on both sides.

## Solution Approach: Prefix and Suffix Maximum Arrays

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Pre-computed Boundary Maximums

## Core Concept
Create two arrays: leftMax[i] stores the maximum height from index 0 to i; rightMax[i] stores the maximum height from index i to n-1. For each position i, the water level is determined by min(leftMax[i], rightMax[i]). The trapped water at position i is max(0, min(leftMax[i], rightMax[i]) - height[i]). Sum all trapped water across all positions.

## Why This Works
Water at any position is bounded by the taller wall on its left and the taller wall on its right—it rises to the height of the shorter of these two walls. By pre-computing leftMax and rightMax, you know these boundary heights instantly for each position. This transforms a problem that seems to require looking left and right (O(n²)) into a linear problem with O(n) preprocessing.

## Important Insights
- **Water level determination:** The water level at position i is NOT the immediate neighbors; it's the maximum height ever seen to the left and right
- **Negative trapped water:** If water level < ground height, trapped water is 0 (not negative); use max(0, ...)
- **Efficiency insight:** Pre-computation trades space (O(n) for two arrays) for time (enabling O(n) calculation instead of O(n²))
- **Why not two pointers?** Two-pointer approach exists but is less intuitive; pre-computation approach is more systematic
- **Building intuition:** Think of it as: "What's the tallest wall I've seen so far?" (leftMax) and "What's the tallest wall ahead?" (rightMax)

## Key Technique: Pre-computed Boundaries for Position-Based Decisions
When each position's value depends on extremes (min/max/count) of surrounding elements, consider pre-computing those extremes. This pattern works for many problems: maximum product in subarray, largest rectangle in histogram, and other boundary-dependent calculations.

## Edge Cases to Remember
- **Single element:** Traps 0 water (need at least two walls)
- **Monotonically increasing heights:** Traps 0 water (water flows off the right)
- **Monotonically decreasing heights:** Traps 0 water (water flows off the left)
- **Valley shape (low in middle):** Traps maximum water
- **Unequal heights on sides:** Water level determined by shorter wall
