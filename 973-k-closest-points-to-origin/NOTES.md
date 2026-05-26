# Problem 973: K Closest Points to Origin

## Problem Overview
Given an array of points in 2D space and an integer k, return the k points that are closest to the origin (0, 0). The distance between two points is measured using Euclidean distance.

## Solution Approach: Max Heap

**Time Complexity:** O(n log k)  
**Space Complexity:** O(k)

**Technique:** Max Heap / Priority Queue

## Core Concept
Use a max heap of size k to efficiently track the k closest points. For each point, calculate its distance from the origin and add it to the max heap. If the heap size exceeds k, remove the point with the maximum distance. This ensures that at the end, the heap contains exactly the k closest points while maintaining optimal performance.

## Why This Works
By maintaining a max heap with only k elements, we ensure that the farthest point among the k closest points is always at the root. When we encounter a new point that is closer than the root, we can replace it. This approach is optimal for finding the k smallest elements from a larger set because we don't need to sort all n points, only maintain k elements in the heap.

## Important Insights
- **Distance Calculation:** We use squared distance (x² + y²) instead of actual Euclidean distance because it preserves the relative ordering and avoids expensive square root calculations.
- **Max Heap Purpose:** A max heap allows us to quickly identify and remove the farthest point among the k closest candidates. When we add a new point that is closer, we can replace the farthest one.
- **Size Management:** By maintaining heap.size() ≤ k, we ensure O(log k) insertion and deletion operations rather than O(log n), making this more efficient than sorting all n points.
- **Space Efficiency:** The heap uses O(k) space regardless of n, and we only keep track of the k closest points without needing to store sorted results.

## Key Technique: Max Heap for K-Elements Problem
This max heap approach is a general pattern for finding k smallest (or k largest) elements in a stream or large dataset. Instead of sorting everything (O(n log n)), we maintain a heap of size k (O(n log k)), which is much more efficient when k << n. This pattern applies to problems like "Kth Largest Element", "Top K Frequent Elements", and similar k-elements selection problems.

## Edge Cases to Remember
- **k equals n:** All points are in the result; the heap will contain all points.
- **Single Point:** When k=1, only one point is returned; the algorithm correctly handles this by maintaining heap size of 1.
- **Duplicate Points:** Multiple points can have the same distance from origin; they are all handled correctly by the heap.
- **Points at Origin:** Points at (0, 0) have distance 0, which is the minimum; they will be correctly included in the result.
