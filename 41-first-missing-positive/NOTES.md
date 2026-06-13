# Problem 41: First Missing Positive

## Problem Overview
Given an unsorted array of integers, find the smallest missing positive integer in O(n) time and O(1) space. For example, for array [3,4,-1,1], the answer is 2.

## Solution Approach: In-Place Array Indexing

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** In-Place Array Manipulation / Index-Based Placement

## Core Concept
Use the array itself as a hash table by placing each number in its "correct" position: number k should be at index k-1. First, for each position, swap the value at index i with its correct position (nums[i] is placed at index nums[i]-1) if the value is in range [1, n] and not already in the correct position. After rearrangement, scan the array to find the first index where the value doesn't match the expected index+1; that index+1 is the answer. If all positions are correct, return n+1.

## Why This Works
The insight is that for an array of length n, the first missing positive must be in range [1, n+1]. If we successfully place each number in [1, n] at its correct index, any missing number in that range appears as a mismatch. This uses the pigeonhole principle: with n positions and n numbers, we can detect exactly which number is missing by finding the first position that doesn't have its expected value.

## Important Insights
- **Range constraint [1, n]:** Only values in this range matter for finding the answer; larger values and negatives can be ignored
- **In-place rearrangement possible:** By swapping elements to their correct positions, we avoid using extra space for a hash set
- **Two-phase approach:** First phase places numbers correctly, second phase scans for first mismatch—both O(n)
- **While loop with swapping:** Each element moves to its correct position at most once; amortizes to O(n) despite nested loops
- **Edge case awareness:** Empty positions, out-of-range values, and duplicates all handled by the rearrangement logic

## Key Technique: Index-Based In-Place Hashing
The pattern: when you need to detect missing elements in a range [1, n] with O(1) space, use the array indices as a hash table. Place each value at index value-1. This technique works for any problem requiring O(1) space detection of missing/duplicate values in a bounded range. It's particularly elegant because it avoids external data structures while achieving optimal complexity.

## Edge Cases to Remember
- **Single element array [1]:** No missing positive, returns 2
- **Array [1]:** Already in correct position, returns 2
- **Negative numbers:** Can be swapped over (ignored if they end up at wrong position)
- **Duplicates:** Multiple copies of same number—only one goes to correct position, others occupy incorrect slots naturally
- **All range values present:** If array has [1,2,3,...,n] in some order, returns n+1
- **Large out-of-range values:** Harmlessly skip; they don't affect final answer
