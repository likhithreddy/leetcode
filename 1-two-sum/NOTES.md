# Problem 1: Two Sum

## Problem Overview
Given an array of integers and a target sum, find the indices of two numbers that add up to the target. You may assume each input has exactly one solution and cannot use the same element twice.

## Solution Approach: HashMap Single Pass

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Hash Map with Complement Lookup

## Core Concept
Iterate through the array exactly once while maintaining a HashMap of previously seen numbers mapped to their indices. For each number, immediately check if its complement (target - current number) exists in the HashMap. If found, return both indices. If not, add the current number to the HashMap and continue. This trading of space for time avoids the O(n²) nested loop approach.

## Why This Works
The key insight is complement arithmetic: if we need two numbers that sum to target, and we see number X, then we need to find (target - X). By keeping a HashMap of seen numbers, we answer "does the complement exist?" in O(1) time. We only make one pass through the array because we've already stored all previous values in the HashMap.

## Important Insights
- **Order matters in HashMap check:** Must check for complement before adding current number to avoid using the same index twice
- **Complement existence requires prior occurrence:** By only checking against previously seen elements, you ensure you never use the same index twice
- **Early termination:** Once first valid pair is found, return immediately (guaranteed to exist per problem statement)
- **Why not sort+twoPointer?** That approach is O(n log n) due to sorting; HashMap approach is strictly O(n)

## Key Technique: Hash Map for O(1) Lookup
The fundamental pattern: when you need to check existence of a complement or matching value, use a HashMap to store previous values. This transforms "search through previous elements" from O(n) into O(1), enabling linear time for problems that would otherwise require nested loops.

## Edge Cases to Remember
- **Duplicate numbers in array:** HashMap handles by storing the most recent index; fine since we process left to right
- **Negative numbers:** No special handling needed; arithmetic works the same
- **Target is zero:** Works fine (e.g., [0,0] with target 0, but can't use same index)
- **Only two elements:** Works correctly; one passes, other found in HashMap
- **Large numbers:** No overflow issues in Java's integer arithmetic within problem constraints
