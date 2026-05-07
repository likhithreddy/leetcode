# Problem 15: 3Sum

## Problem Overview
Find all unique triplets in an array that sum to zero. Each triplet must be unique (no duplicate triplets in results), and you cannot use the same element more than once.

## Solution Approach: Sorting + Two Pointers with Duplicate Handling

**Time Complexity:** O(n²)  
**Space Complexity:** O(1) or O(n) depending on sorting algorithm

**Technique:** Sort then Two-Pointer for Pairs

## Core Concept
Sort the array first. Then, for each element at index i (treating it as first element of triplet), use two pointers to find pairs that sum to -nums[i] in the remaining array. The two-pointer technique works on sorted data: if sum is too small, move left pointer right; if sum is too large, move right pointer left. Include duplicate-skipping logic at three levels: after picking first element, after moving left pointer, and after moving right pointer.

## Why This Works
Sorting enables two-pointer linear scanning for pairs. Without sorting, finding pairs would require a HashMap (additional space) or nested loops (worse time). Duplicate skipping requires sorted array to identify consecutive equal elements. The method guarantees no duplicate triplets: we process each unique first element only once, and within each first element's processing, each unique pair is found only once.

## Important Insights
- **Three layers of duplicate handling:** Skip duplicate first elements, skip consecutive equal left pointer values, skip consecutive equal right pointer values
- **Two pointers on sorted data:** Moving from outside inward after sorting is how you get O(n²) instead of O(n³)
- **Why not HashMap?** A HashMap approach would need to track which elements have been paired to avoid duplicates—more complex than sorted approach
- **Negative numbers and zero:** Work naturally in the algorithm; -nums[i] can be any value (positive, negative, zero)
- **Early termination:** If nums[i] > 0, no triplets possible (all remaining sums will be positive)

## Key Technique: Sorted + Two-Pointer for Duplicate-Free Results
When finding multiple pairs with duplicate avoidance, sort first. Sorting naturally clusters duplicates together, making duplicate-skipping simple (check if consecutive elements are equal). Two pointers on sorted array avoid O(n³) or complex HashMap logic.

## Edge Cases to Remember
- **Array with negative numbers:** Works correctly; sorting handles order
- **All zeros:** Returns [[0,0,0]] (one valid triplet)
- **Single triplet that's zero:** Must be returned
- **Very large arrays:** O(n²) dominates; sorting is negligible
- **Duplicate handling:** At target=-nums[i], may encounter same number; skip duplicates properly
