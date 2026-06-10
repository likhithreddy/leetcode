# Problem 219: Contains Duplicate II

## Problem Overview
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.

## Solution Approach: Hash Map with Index Tracking

**Time Complexity:** O(n)  
**Space Complexity:** O(min(n, k))

**Technique:** Hash Map (Hash Table)

## Core Concept
This approach maintains a hash map that stores the most recent index of each number encountered. As we iterate through the array, for each number we check if it already exists in the map and if the distance between the current index and its stored index is within `k`. If both conditions are true, we found our duplicate within the constraint. Otherwise, we update the hash map with the current index, ensuring we always have the most recent position for quick lookup.

## Why This Works
The hash map acts as a sliding window of sorts, tracking elements within our range of interest. By storing only the most recent index of each element, we can instantly determine if a duplicate exists within the distance constraint. The key insight is that we only care about the most recent position—older occurrences of the same number are irrelevant once we find a closer one.

## Important Insights
- **Hash Map Efficiency:** Using a hash map allows O(1) lookups, making duplicate detection instantaneous rather than scanning through past elements.
- **Index Tracking:** Storing indices rather than just presence/absence allows us to enforce the distance constraint `k`, making this solution different from simple "contains duplicate" problems.
- **Rolling Window:** Implicitly, we maintain a sliding window of size `k+1` by only caring about elements within distance `k` of the current position.
- **Space Optimization:** The space complexity is O(min(n, k)) because we only need to keep track of at most `k+1` unique elements at any time in an optimized version.

## Key Technique: Hash Map for Constraint Validation
Hash maps are incredibly useful when you need to track properties of elements (like their positions) and validate constraints against them. This pattern appears in many problems: detecting duplicates within a range, finding pairs with specific properties, or maintaining recent history. When a problem asks "do two elements satisfy a condition relative to their positions," think hash map for instant validation.

## Edge Cases to Remember
- **Array with duplicates at distance > k:** The algorithm correctly returns false if duplicates exist but are too far apart.
- **Array with single element:** Returns false since we can't find two distinct indices.
- **k = 0:** Returns false unless duplicates are at the exact same index (impossible for distinct indices).
- **k >= n:** All pairs within the array are within range; any duplicate means true.
