# Problem 217: Contains Duplicate

## Problem Overview
Given an array of integers, determine whether the array contains any duplicate values.

## Solution Approach: HashSet Single Pass

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Hash Set for Membership Testing

## Core Concept
Iterate through the array once. For each element, check if it's already in a HashSet. If yes, return true immediately (found a duplicate). If no, add it to the set and continue. If you finish iterating without finding a duplicate, return false.

## Why This Works
A HashSet provides O(1) average-case membership testing. By checking each element against previously seen elements, you can detect the first duplicate in a single pass. Early termination when a duplicate is found avoids processing the rest of the array.

## Important Insights
- **Early termination:** As soon as a duplicate is found, return true; no need to continue
- **HashSet vs. HashMap:** HashMap would track frequencies (unnecessary here); HashSet only needs presence information
- **Time efficiency:** O(n) single pass is optimal; you must check each element at least once
- **Space-time tradeoff:** Use O(n) space to achieve O(n) time; without extra space, best you can do is O(n log n) with sorting
- **Duplicate detection:** Finding the first duplicate is sufficient; you don't need to count duplicates or find all of them

## Key Technique: Hash Set for Presence Testing
When you need to track which elements you've seen and check for duplicates or intersections, use a HashSet. This pattern applies to: duplicate detection, membership testing, intersection problems, and presence verification.

## Edge Cases to Remember
- **Empty array:** No duplicates (return false)
- **Single element:** No duplicates
- **Two identical elements:** Returns true immediately on second element
- **All unique elements:** Returns false (processes all elements)
- **Multiple duplicates:** Returns true on first duplicate found; doesn't matter which duplicate
