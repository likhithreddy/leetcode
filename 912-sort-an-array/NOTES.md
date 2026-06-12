# Problem 912: Sort an Array

## Problem Overview
Given an array of integers, sort the array in ascending order and return it.

## Solution Approach: Heap Sort

**Time Complexity:** O(n log n)  
**Space Complexity:** O(1)

**Technique:** Heap Sort, Max Heap, Array Manipulation

## Core Concept
Heap Sort works by first building a max heap from the input array in O(n) time, then repeatedly extracting the maximum element from the heap and placing it at the end of the array. This divides-and-conquers by gradually moving the largest elements to their correct positions. The heapify operation maintains the heap property by ensuring each parent is greater than its children, allowing efficient extraction of the maximum.

## Why This Works
Heap Sort is valid because it systematically places each element in its correct final position through the properties of the binary heap. By extracting the maximum repeatedly and placing it at the end, we ensure the array is sorted in ascending order. The heap property guarantees that the largest remaining element is always at the root, making O(log n) extraction operations sufficient for n elements.

## Important Insights
- **Max Heap Construction:** Building the heap from bottom-up (from index n/2-1 downwards) is more efficient than inserting elements one by one, taking O(n) instead of O(n log n).
- **In-Place Sorting:** Unlike merge sort, heap sort sorts in-place without requiring extra array space, making it memory-efficient.
- **Heapify Operation:** The heapify function maintains the max heap property by comparing a node with its children and swapping with the larger child if necessary, then recursively fixing the affected subtree.
- **Stability:** Heap sort is not a stable sort—equal elements may not maintain their original relative order due to the nature of heap operations.

## Key Technique: Heapify and Heap Property
The heapify technique is fundamental to heap-based algorithms. In a max heap, each parent node must be greater than or equal to its children. By recursively applying heapify starting from the last non-leaf node (index n/2-1), we can build a valid max heap in linear time. This pattern appears in priority queues, heap-based sorting, and k-largest/smallest element problems. When dealing with complete binary trees represented as arrays, remember that for index i: left child is at 2i+1 and right child is at 2i+2.

## Edge Cases to Remember
- **Single Element Array:** Arrays with one element are already sorted and return immediately after heap construction.
- **Already Sorted Array:** The algorithm still requires O(n log n) time even if the array is already sorted, as it goes through the complete sorting process.
- **Reverse Sorted Array:** This is the worst-case scenario for comparisons but still maintains O(n log n) time complexity due to the heap structure.
- **Duplicate Elements:** Heap sort handles duplicates correctly; the heapify operation doesn't assume unique elements and works with equal values.
