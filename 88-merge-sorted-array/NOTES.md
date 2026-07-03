# Problem 88: Merge Sorted Array

## Problem Overview
You are given two sorted integer arrays, `nums1` and `nums2`, where `nums1` has enough trailing space to hold all elements of `nums2`. Merge `nums2` into `nums1` so that `nums1` ends up sorted in nondecreasing order.

## Solution Approach: Two Pointers from the End

**Time Complexity:** O(m + n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers / In-Place Merge

## Core Concept
Because `nums1` already has spare capacity at the end, the safest way to merge in place is to fill it from right to left. Compare the largest remaining elements at the ends of both arrays, place the larger one into the last open slot in `nums1`, and move that pointer backward. This prevents overwriting values in `nums1` that have not been processed yet.

## Why This Works
At every step, the largest unplaced value among the two sorted suffixes must belong at the current end of `nums1`. That makes the rightmost position a locally correct choice that never needs to be revisited. Filling from the back preserves all unread values in `nums1`, so the merge completes without extra storage.

## Important Insights
- **Merge from the back:** Writing from the end avoids clobbering values in `nums1` that still need to be compared.
- **Drain `nums2` if needed:** If `nums2` still has values after the main loop, they all need to be copied into the front of `nums1`.
- **No need to copy leftover `nums1`:** If `nums2` is exhausted first, the remaining `nums1` prefix is already in the correct place.
- **Sorted suffix invariant:** The tail of `nums1` always contains the largest values in final sorted order.

## Key Technique: In-Place Two-Pointer Merge
This is the standard pattern for merging sorted sequences when one container has spare trailing capacity. It shows up whenever you need to combine ordered data without allocating a third array, and the key idea is always the same: consume from the end so earlier values remain undisturbed.

## Edge Cases to Remember
- **`nums2` is empty:** `nums1` should stay unchanged.
- **`nums1` is empty except for padding:** The algorithm should copy all of `nums2` into `nums1`.
- **One array finishes early:** The remaining elements from the other array are already sorted and can be copied directly.
- **Duplicate values:** Equal values still preserve nondecreasing order because either side can be placed first.