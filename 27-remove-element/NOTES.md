# Problem 27: Remove Element

## Problem Overview
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place and return the number of elements in the array which are not equal to `val`. The relative order of elements may be changed.

## Solution Approach: Two Pointer In-Place

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers

## Core Concept
We use two pointers to track positions in the array: one pointer (`k`) marks the position where the next non-value element should be placed, and another pointer (`i`) scans through the entire array. When we encounter an element that is not equal to `val`, we place it at position `k` and increment `k`. This allows us to remove all occurrences of `val` without using extra space.

## Why This Works
Since we only care about the number of elements not equal to `val` and their relative positions, we can modify the array in-place. By overwriting elements equal to `val` with non-value elements, we effectively "remove" them. The two-pointer approach ensures we process each element exactly once while maintaining the integrity of the non-value elements.

## Important Insights
- **In-Place Modification:** We modify the input array itself, which is more space-efficient than creating a new array
- **Two Pointer Pattern:** One pointer for writing destination, one for reading source - a common pattern for array problems
- **Return Value:** We only return the count of elements not equal to `val`, not a modified array of that size
- **Element Order:** While the relative order of remaining elements is preserved within the non-value elements, their absolute positions may shift

## Key Technique: Two Pointers
The two-pointer technique is fundamental for in-place array modifications where you need to rearrange or filter elements. One pointer typically marks the "write" position while the other marks the "read" position. This pattern applies to similar problems like removing duplicates, partitioning arrays, or moving elements to satisfy certain conditions. Understanding this technique helps optimize space usage in array manipulation problems.

## Edge Cases to Remember
- **All Elements Equal to Val:** If all elements equal `val`, the function returns 0
- **No Elements Equal to Val:** If no elements equal `val`, the function returns the array length and array remains unchanged
- **Single Element Array:** If the array has only one element equal to `val`, returns 0; if not equal, returns 1
- **Value Not in Array:** If `val` doesn't exist in the array, all elements remain unchanged and the function returns the array length
