# Problem 347: Top K Frequent Elements

## Problem Overview
Given an array of integers and an integer k, find the k most frequent elements in the array and return them. You may assume k is always valid (1 ≤ k ≤ number of unique elements).

## Solution Approach: HashMap + Bucket Sorting (Counting Sort)

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Frequency Counting + Bucket Sort

## Core Concept
**Step 1:** Count frequencies of all elements using a HashMap. **Step 2:** Create buckets indexed by frequency (bucket[i] contains all numbers with frequency i). **Step 3:** Iterate from the highest frequency bucket backward, collecting elements until you have k elements.

## Why This Works
This approach exploits the constraint that frequencies range from 1 to n. Instead of sorting by frequency (O(n log n)), you use counting sort where buckets represent frequency values. Frequencies are bounded and small relative to the array size, making bucket sort O(n).

## Important Insights
- **Frequency bounds:** Frequencies range from 1 to n; this bounded range enables counting sort
- **Bucket indexing:** Bucket index i contains elements appearing exactly i times
- **Reverse iteration:** Iterate from highest frequency backward to get most frequent elements first
- **Early termination:** Once you collect k elements, stop; no need to process all buckets
- **Why not heap?** Could use a min-heap of size k, but bucket sort is O(n) versus heap's O(n log k)
- **Why not HashMap sort?** Sorting HashMap entries would be O(n log n); bucket sort is O(n)

## Key Technique: Bucket Sort for Bounded Values
When values fall in a known, bounded range (like frequencies from 1 to n), use bucket sort instead of comparison-based sorting. This pattern applies to: top-k frequent elements, sort by frequency, and any counting-sort scenarios.

## Edge Cases to Remember
- **k equals number of unique elements:** Return all elements
- **Single unique element with frequency n:** Return that one element
- **All elements have same frequency:** Return any k elements; algorithm returns highest indices
- **k = 1:** Return the most frequent element
- **Multiple elements with same frequency:** All are valid as top-k candidates
