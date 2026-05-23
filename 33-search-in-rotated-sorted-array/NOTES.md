# Problem 33: Search in Rotated Sorted Array

## Problem Overview
Given a rotated sorted array of distinct integers, find the index of a target value. Return -1 if the target is not found.

## Solution Approach: Modified Binary Search

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

**Technique:** Binary Search with Rotation Handling

## Core Concept
The key insight is to determine which half of the array is properly sorted, then decide which half contains the target. At each step of the binary search, compare the middle element with the target and the boundaries to determine if we're on the left sorted portion or right sorted portion, then eliminate half of the search space.

## Why This Works
Since the array is rotated only once, at least one half of the array (split by the middle element) will always be properly sorted. By identifying the sorted half and checking if the target falls within the sorted half's range, we can eliminate half the remaining elements and achieve O(log n) time complexity.

## Important Insights
- **Rotation creates a pivot:** The array has a rotation point where nums[mid] > nums[right], indicating the left half is sorted.
- **Determine sorted half:** At each iteration, identify whether the left or right half is the properly sorted portion.
- **Range check:** Use value comparisons (not indices) to determine if the target is within the sorted half's range.
- **Handle edge cases:** When nums[mid] == nums[left] == nums[right], special handling may be needed, but this problem states distinct integers so it's simplified.

## Key Technique: Modified Binary Search
This technique applies whenever you need to search in a partially sorted or rotated array. The pattern is: identify which portion is sorted, verify if the target falls within that range, then eliminate the impossible half. This approach is generalizable to problems like "Search in Rotated Sorted Array II" or any scenario where you have local sortedness information.

## Edge Cases to Remember
- **Target at pivot:** If target equals nums[mid], return immediately.
- **Target in left sorted half:** When nums[mid] > nums[right], the left half is sorted; check if target is in [nums[left], nums[mid]).
- **Target in right sorted half:** When nums[mid] < nums[right], the right half is sorted; check if target is in (nums[mid], nums[right]].
- **Single element array:** Works correctly as the while loop handles it.
