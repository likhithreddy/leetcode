# Problem 881: Boats to Save People

## Problem Overview
You are given an array `people` where `people[i]` is the weight of the i-th person, and an unlimited number of boats where each boat can carry at most `limit` weight capacity. Each boat carries at most 2 people and the sum of the weight of people in the boat is at most `limit`. Find the minimum number of boats needed to save everyone.

## Solution Approach: Two Pointers Greedy

**Time Complexity:** O(n log n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers, Greedy Algorithm, Sorting

## Core Concept
The key insight is to use a greedy two-pointer approach: sort the array and try to pair the lightest person with the heaviest person. If they can fit together in a boat, pair them and move both pointers inward. If the heaviest person cannot fit with the lightest, the heaviest person must take a boat alone. This strategy minimizes boats because we're maximizing the utilization of each boat by always attempting to pair people.

## Why This Works
By sorting the array, we ensure that the lightest remaining people are at the left and the heaviest remaining people are at the right. The greedy approach of trying to pair the lightest with the heaviest works because if the heaviest person cannot fit with the lightest, they cannot fit with anyone else either, so they must go alone. This ensures optimal boat allocation. If they do fit together, we save a boat that would have been needed for one of them separately.

## Important Insights
- **Sorting enables efficient pairing:** Once sorted, we know the lightest person is at the start and heaviest at the end, allowing O(1) identification of potential pairs.
- **Greedy pairing maximizes efficiency:** Pairing the lightest with the heaviest is optimal because if the heaviest person can't fit with the lightest, they can't fit with anyone.
- **Two pointers converge efficiently:** The two-pointer approach ensures we process each person exactly once, visiting all possibilities in O(n) time.
- **Edge case handling:** When first == last (one person left), that person needs one more boat. When first > last, all people have been processed.

## Key Technique: Two Pointers with Greedy Selection
The two-pointer technique is powerful when you need to find pairs or compare elements from opposite ends of a sorted array. Combined with a greedy selection strategy, it solves pairing problems optimally. This pattern applies to problems like "Container With Most Water," "Two Sum II," and other problems where you need to find optimal pairs from a sorted sequence.

## Edge Cases to Remember
- **Single person:** If the array has one person, they need one boat.
- **Everyone fits in one boat:** If the sum of all weights is within the limit, technically they all fit, but the algorithm still pairs them correctly.
- **Lightest + heaviest exceeds limit:** The heaviest person takes a boat alone and we move the last pointer only.
- **All people same weight:** Pairing still works correctly; pairs are formed until one or zero people remain.
