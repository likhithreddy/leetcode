# Problem 128: Longest Consecutive Sequence

## Problem Overview
Given an unsorted array of integers, find the length of the longest consecutive sequence of numbers. The consecutive sequence can be formed from any order of elements in the array.

## Solution Approach: HashSet with Smart Counting

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Hash Set with Sequence Starting Point Optimization

## Core Concept
Store all numbers in a HashSet. Iterate through the set. For each number, check if it's the start of a sequence (number - 1 not in set). If it is a start, count upward from that number to find the sequence length (number + 1, number + 2, etc. in set). Update maximum length. This avoids counting the same sequence multiple times.

## Why This Works
By only counting sequences that start at their beginning (where number-1 doesn't exist), you count each sequence exactly once. Without this optimization, you'd count consecutive sequences multiple times from different starting points. The HashSet enables O(1) lookup for the existence of each number in the sequence, making the sequence-following operation fast.

## Important Insights
- **Starting point identification:** A number is a starting point if (number - 1) is NOT in the set; this prevents counting sequences multiple times
- **Sequence following:** Once at a starting point, count forward by checking (number+1), (number+2), etc.
- **Why not sorting?** Sorting is O(n log n); HashSet approach is strictly O(n) despite seeming to iterate multiple times
- **Duplicate handling:** HashSet automatically eliminates duplicates; counting logic remains unchanged
- **Efficiency vs. intuition:** Intuition might suggest checking every number, but optimization to count only from starting points makes it efficient

## Key Technique: Starting Point Optimization for Duplicate-Free Iteration
When iterating through data and processing sequences/groups, identify starting points to avoid redundant processing. Check if current element is the beginning of a group (previous element not present), and only then process the full group. This pattern applies to: consecutive sequences, grouping related elements, and range processing.

## Edge Cases to Remember
- **Empty array:** Return 0
- **Single element:** Return 1
- **All identical numbers:** Return 1 (only one value, not a sequence)
- **Unsorted array:** HashSet handles any order
- **Negative numbers:** Algorithm handles naturally; consecutive arithmetic works the same
