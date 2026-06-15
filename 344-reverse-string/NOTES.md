# Problem 344: Reverse String

## Problem Overview
Given a string represented as an array of characters, reverse the string in-place with O(1) extra memory.

## Solution Approach: Two Pointers

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers

## Core Concept
Use two pointers starting from both ends of the array and move them towards the center. At each step, swap the characters at the two pointer positions. Continue until the pointers meet or cross in the middle. This in-place approach swaps elements without using extra space.

## Why This Works
The two-pointer technique works because we need to reverse the array, which means the first element should become the last, the second element should become second-to-last, and so on. By swapping pairs from the outside moving inward, we systematically reverse the entire array. The algorithm terminates when the pointers meet (odd-length arrays) or cross (even-length arrays).

## Important Insights
- **In-place modification:** Swapping directly in the array requires O(1) extra space
- **Two-pointer pattern:** Moving pointers from opposite ends towards the center is efficient for symmetric operations
- **Early termination:** When first >= last, we've completed the reversal since the middle element (or between two middle elements) doesn't need to move
- **No extra data structures:** Unlike using a stack or recursion, the two-pointer approach avoids extra space entirely

## Key Technique: Two Pointers for In-Place Transformations
The two-pointer technique is ideal for in-place array transformations where you need to swap or rearrange elements symmetrically. This pattern applies to reversing arrays, partitioning (like in quicksort), and other operations that modify arrays without auxiliary data structures.

## Edge Cases to Remember
- **Empty string:** No characters to reverse, returns immediately
- **Single character:** A single character is already reversed
- **Two characters:** Simple swap of two elements
- **All same characters:** Still needs to go through the algorithm, but character values don't change
- **Large arrays:** The algorithm scales linearly with no memory overhead regardless of size
