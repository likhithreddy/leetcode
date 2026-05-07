# Problem 704: Binary Search

## Problem Overview
Given a sorted array of integers and a target value, find the index of the target in the array using binary search. If the target doesn't exist, return -1.

## Solution Approach: Recursive Binary Search

**Time Complexity:** O(log n)  
**Space Complexity:** O(log n) for recursion stack

**Technique:** Recursive Divide and Conquer

## Core Concept
Compare the target with the middle element of the current range. If they're equal, return the index. If target is less, recursively search the left half. If target is greater, recursively search the right half. Repeat until found or search space is exhausted (left > right).

## Why This Works
Binary search halves the search space with each comparison. Starting with n elements, after one comparison you have n/2 elements to consider, then n/4, then n/8, and so on. This logarithmic reduction in search space is what makes binary search O(log n). The prerequisite is a sorted array; without sorting, you can't use the comparison result to eliminate half the data.

## Important Insights
- **Sorted prerequisite:** Binary search requires sorted data; unsorted data requires linear search (O(n))
- **Comparison gives direction:** The result of comparing target with middle element tells you which half contains the target
- **Recursive elegance:** Each recursive call processes a smaller, well-defined subproblem
- **Iterative alternative:** Iterative binary search uses a while loop instead of recursion; both are O(log n) time
- **Boundary cases:** Handle when target isn't found (left > right); return -1
- **Off-by-one errors:** Be careful with index calculations when picking mid-point and adjusting boundaries

## Key Technique: Binary Search Pattern
Whenever you have sorted data and need to find an element or position, binary search is O(log n). Extend this pattern to: rotated sorted arrays, finding boundaries (first/last occurrence), peak elements, and many other variations. The core idea remains: use comparison result to eliminate half the search space.

## Edge Cases to Remember
- **Target not in array:** Returns -1
- **Single element array:** Compare with that element; return index or -1
- **Target is smallest:** Found on left side
- **Target is largest:** Found on right side
- **Empty array:** Returns -1 (immediate condition left > right)
