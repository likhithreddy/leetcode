# Problem 1046: Last Stone Weight

## Problem Overview
We have stones with weights and must repeatedly take the two heaviest stones and smash them together. If they're equal, both disappear; otherwise, the difference remains. Return the weight of the last stone, or 0 if none remain.

## Solution Approach: Max Heap

**Time Complexity:** O(n log n)  
**Space Complexity:** O(n)

**Technique:** Max Heap (Priority Queue)

## Core Concept
Use a max heap to always efficiently retrieve the two heaviest stones. Compare them and place the difference (if any) back into the heap. Repeat until one stone or none remains. This greedy approach ensures we always process the heaviest stones first, which is optimal for this problem.

## Why This Works
The order in which we compare stones matters—by always comparing the two heaviest stones, we ensure that larger conflicts happen first. This greedy strategy is valid because the final result is independent of the order of comparisons; we're just finding the last remaining stone through repeated reductions.

## Important Insights
- **Max Heap for Efficiency:** A max heap lets us extract the two largest elements in O(log n) time, rather than O(n) with a linear search.
- **Insertion of Remainder:** When two stones differ, the remainder goes back into the heap as a new stone, maintaining the heap property automatically.
- **Early Termination:** Once heap size reaches 1 or 0, we can stop, as further collisions aren't possible.
- **Integer Difference:** The absolute difference naturally handles the collision outcome—larger stone minus smaller stone always yields a positive result.

## Key Technique: Greedy + Max Heap
This pattern applies whenever you need to repeatedly process the k largest/smallest elements from a dynamic set. Max/min heaps are ideal for scenarios where you need repeated access to extremes and frequent insertions of new elements. Common variations include task scheduling problems, Dijkstra's algorithm, and huffman coding.

## Edge Cases to Remember
- **Single Stone:** If the array has only one stone, return its weight immediately.
- **Two Stones:** If two stones are equal, both disappear and return 0; otherwise return their difference.
- **Empty Result:** If all stones cancel out, return 0.
- **All Equal Weights:** If all stones have the same weight and count is odd, one stone remains; if count is even, none remain.
