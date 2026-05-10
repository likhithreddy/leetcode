# Problem 703: Kth Largest Element in a Stream

## Problem Overview
Design a class that finds the kth largest element in a stream of numbers. The class should support initializing with initial numbers and adding new numbers while efficiently returning the kth largest element at any time.

## Solution Approach: Min Heap of Size K

**Time Complexity:**
- Constructor: O(n log k) where n is the number of initial elements
- Add method: O(log k)
- Space Complexity: O(k)

**Technique:** Min Heap (Priority Queue)

## Core Concept
Maintain a min heap of size k containing the k largest elements seen so far. The root of this min heap is the kth largest element. When adding a new element, if it's larger than the root, remove the root and insert the new element. This keeps only the k largest elements in the heap at any time, with the smallest of those (the kth largest) at the top for O(1) retrieval.

## Why This Works
By maintaining a heap of exactly k elements, we ensure that the minimum element in the heap is the kth largest overall. When a new element arrives that's larger than this minimum, we know it deserves to be in our top-k set, so we evict the previous minimum and insert the new element. This maintains the invariant that our heap always contains the k largest elements encountered.

## Why Max Heap Would NOT Work
A max heap would always place the largest element at the top, not the kth largest. To find the kth largest using a max heap, you'd need to extract k elements one by one, each taking O(log n) time, resulting in O(k log n) per query—much slower than our O(log k) min heap approach. Additionally, you'd lose all k largest elements after extracting them. A max heap is useful for finding the 1st largest (maximum), but for the kth largest, a min heap of size k is fundamentally more efficient.

## Important Insights
- **Heap Size Constraint:** Keep the heap exactly at size k; if it exceeds k, evict the minimum to maintain efficiency.
- **Constructor Cost:** Building the heap incrementally with n elements costs O(n log k), which is faster than heapifying all n elements upfront (O(n)) if k << n.
- **Add Method Efficiency:** O(log k) is vastly better than sorting the entire stream on each addition (O(n log n)).
- **Space Optimization:** Storing only k elements instead of all n elements saves memory, making this scalable for large streams.

## Key Technique: K-Size Heap Window
This pattern is used whenever you need to efficiently track the top k elements (largest or smallest) from a dynamic or streaming dataset. Applications include: heap sort for finding top k elements, finding medians, priority-based task scheduling, and real-time leaderboards. The key is maintaining a heap of exactly k elements and comparing new arrivals against the extremum of that heap.

## Edge Cases to Remember
- **k Equals 1:** Tracks the maximum element; heap always has size 1 with just the largest.
- **Duplicate Elements:** The heap handles duplicates naturally; multiple identical values can exist in the heap.
- **Adding Smaller Elements:** If a new element is smaller than the root (kth largest), ignore it; don't insert.
- **Stream Begins with Few Elements:** Before n reaches k, the add method still works correctly; the heap grows until it reaches size k, then maintains that size.
