# Problem 1929: Concatenation of Array

## Problem Overview
Given an integer array `nums` of length `n`, create a new array `ans` of length `2n` where `ans[i] == nums[i]` and `ans[i + n] == nums[i]` for all indices `0 <= i < n`.

## Solution Approach: Direct Concatenation

**Time Complexity:** O(n)  
**Space Complexity:** O(1) (excluding the output array)

**Technique:** Array Manipulation, Single Pass

## Core Concept
The problem requires concatenating an array with itself. We iterate through the original array once and place each element at two positions: its original index and at index offset by the array length. This straightforward approach efficiently builds the concatenated result in a single pass.

## Why This Works
Since we need to create a new array of size 2n containing the original array twice, iterating through the original array and directly copying elements to their destination positions in the result array ensures correctness. We visit each element exactly once, so the linear time complexity is optimal.

## Important Insights
- **Array Concatenation Pattern:** When concatenating an array with itself, the pattern is `[nums[0], nums[1], ..., nums[n-1], nums[0], nums[1], ..., nums[n-1]]`
- **Index Mapping:** Element at index `i` goes to positions `i` and `i + n` in the result array
- **Single Pass Efficiency:** All operations can be completed in one loop without requiring additional space or sorting
- **Output Array Size:** The result array must be exactly twice the size of the input array

## Key Technique: Array Element Placement
This technique is fundamental for array construction problems. When you need to build a new array from elements following a specific pattern, directly computing the destination indices and writing elements in a single pass is often the most efficient approach. This pattern applies to problems involving array concatenation, interleaving, or any positional reorganization of elements.

## Edge Cases to Remember
- **Empty Array:** Input `nums = []` should return `[]` (empty concatenation)
- **Single Element:** Input `nums = [1]` should return `[1, 1]`
- **Negative Numbers:** Array can contain negative integers; they are handled the same way as positive integers
- **Duplicate Elements:** Multiple identical elements are concatenated correctly without any special handling
