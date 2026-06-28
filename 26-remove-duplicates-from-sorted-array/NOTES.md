# Problem 26: Remove Duplicates from Sorted Array

## Problem Overview
Remove duplicates from a sorted array in-place so that each unique element appears only once, and return the new length of the modified array.

## Solution Approach: Two Pointers

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers, In-Place Array Modification

## Core Concept
The sorted property ensures that duplicates appear consecutively. Use a slow pointer to track the position of the next unique element and a fast pointer to scan through the array. When the fast pointer sees a new value, write it to the slow pointer and increment the slow pointer.

## Why This Works
Because the array is sorted, duplicates are adjacent. The fast pointer discovers each new unique value only once, and the slow pointer maintains the boundary of the de-duplicated prefix. Writing the next unique element into the slow pointer position preserves the array order and ensures the first part of the array contains the unique values.

## Important Insights
- **Sorted input:** This is what makes the two-pointer approach possible and efficient.
- **In-place modification:** No extra array is needed; you only overwrite the input array.
- **Slow pointer as boundary:** The slow pointer always points to the next insert position for a unique element.
- **Duplicates are skipped:** When the current value equals the previous value, the fast pointer simply moves on.

## Key Technique: Two Pointers for In-Place Deduplication
This pattern works well when you need to deduplicate or reorder elements while preserving relative order in a sorted array. Use one pointer to scan and another pointer to build the result in place.

## Edge Cases to Remember
- **Empty array:** Return 0.
- **Single-element array:** Return 1 and leave the array unchanged.
- **All unique elements:** The algorithm should return the original length.
- **All duplicates:** The algorithm should return 1.
