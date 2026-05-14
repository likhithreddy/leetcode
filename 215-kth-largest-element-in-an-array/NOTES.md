# Problem 215: Kth Largest Element in an Array

## Problem Overview
Find the kth largest element in an unsorted array of integers. The kth largest element is the element at the kth position when the array is sorted in descending order.

## Solution Approach: Min Heap

**Time Complexity:** O(N log K)  
**Space Complexity:** O(K)

**Technique:** Min Heap (Priority Queue)

## Core Concept
We maintain a min heap of size k that always contains the k largest elements seen so far. As we iterate through the array, we add each element to the heap. If the heap size exceeds k, we remove the smallest element (the root of the min heap). After processing all elements, the root of the heap is guaranteed to be the kth largest element.

## Why This Works
A min heap with size k ensures that the smallest element in the heap is larger than all elements outside the heap that we've already processed. This means the top of the heap at the end represents the threshold: all larger elements are in the heap, and all smaller elements have been discarded.

## Important Insights
- **Min Heap Property:** We use a min heap rather than a max heap because we want quick access to the smallest of the k largest elements, which we might need to remove if we find a larger candidate.
- **Size Constraint:** By keeping the heap size at most k, we maintain O(K) space complexity and avoid storing unnecessary elements.
- **Quick Select Alternative:** While this solution is O(N log K) on average, QuickSelect is theoretically more optimal with O(N) average-case complexity, but O(N²) worst-case when pivot selection is poor. This heap approach has a consistent O(N log K) guarantee.
- **Tradeoff:** The min heap solution trades slightly worse average-case performance for guaranteed, consistent performance without the risk of quadratic worst-case behavior.

## Key Technique: Priority Queue / Heap
A Priority Queue (or Heap) is a fundamental data structure where elements are organized by priority. In Java, `PriorityQueue` implements a min-heap by default. This technique is invaluable for problems requiring quick access to the minimum (or maximum with a custom comparator) element, and applies to many problems including finding kth smallest/largest, median in a stream, and scheduling tasks.

## Edge Cases to Remember
- **Single Element:** If k equals 1, the kth largest is simply the maximum element in the array.
- **k Equals Array Length:** The kth largest element is the smallest element in the array.
- **Duplicate Elements:** The algorithm correctly handles duplicates; they are treated as separate occurrences.
- **Negative Numbers:** The algorithm works with negative numbers; the heap comparison is purely based on numeric value regardless of sign.
