# Problem 153: Find Minimum in Rotated Sorted Array

## Problem Overview
Given a rotated sorted array of distinct integers, find the minimum element efficiently. A rotated array means a sorted array that has been rotated at some pivot point.

## Solution Approach: Binary Search

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

**Technique:** Binary Search

## Core Concept
The key insight is comparing the middle element with the rightmost element. If `nums[mid] > nums[right]`, the minimum must be in the right half. If `nums[mid] <= nums[right]`, the minimum is in the left half (including mid itself). This leverages the property that one half of the array is always sorted.

## Why This Works
In a rotated sorted array, one half is always completely sorted. By comparing the middle element with the right boundary, we can determine which half contains the rotation point and therefore the minimum. The sorted property of at least one half ensures we can safely eliminate half of the search space.

## Important Insights
- **Comparison with right boundary:** Always compare `nums[mid]` with `nums[right]`, not with `nums[left]`. This helps identify which side contains the rotation/minimum.
- **Mid lies in sorted half:** If `nums[mid] <= nums[right]`, the right portion is sorted and minimum is on the left; if `nums[mid] > nums[right]`, the left portion is sorted and minimum is on the right.
- **Include mid in left half:** When `nums[mid] <= nums[right]`, set `right = mid` (not `mid - 1`) because `mid` could be the minimum.
- **Exclude mid from right half:** When `nums[mid] > nums[right]`, set `left = mid + 1` because `mid` is definitely not the minimum.

## Key Technique: Binary Search on Rotated Array
Binary search on rotated arrays is a powerful technique used when one half is guaranteed to be sorted. By comparing with boundaries and determining which half is sorted, we can eliminate half the search space. This pattern applies to multiple problems: find minimum, find target, or find peak in rotated sorted arrays.

## Edge Cases to Remember
- **Single element array:** Works correctly; the while loop condition `left < right` ensures we exit immediately with the only element.
- **No rotation (sorted array):** The minimum will be at index 0; the algorithm still works by progressively moving left.
- **Array rotated at start:** The minimum is at position 0; the algorithm handles this correctly.
- **Array rotated near end:** The minimum is near the end; the algorithm efficiently navigates to it.
