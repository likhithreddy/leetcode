# Problem 981: Time Based Key-Value Store

## Problem Overview
Design a time-based key-value data structure that can store multiple values for the same key at different timestamps and retrieve the value for a key at a given timestamp (returning the value from the largest timestamp less than or equal to the given timestamp).

## Solution Approach: Binary Search with Hash Maps

**Time Complexity:** O(log n) for get() operation, O(1) for set() operation  
**Space Complexity:** O(n) where n is the total number of key-value-timestamp pairs stored

**Technique:** Hash Map with ArrayList, Binary Search

## Core Concept
The solution uses two parallel hash maps: one storing timestamps and one storing corresponding values for each key. When retrieving a value, binary search is performed on the sorted timestamps to find the largest timestamp that is less than or equal to the given timestamp. This efficiently handles the time-based retrieval requirement without needing to sort on each query.

## Why This Works
Since timestamps are always inserted in increasing order (guaranteed by the problem), the timestamps array for each key is naturally sorted. Binary search exploits this property to find the target timestamp in logarithmic time. The problem guarantees monotonically increasing timestamps, so we don't need to sort the data structure after each insertion, making set() operations O(1) and get() operations O(log n).

## Important Insights
- **Monotonically Increasing Timestamps:** The problem guarantees that timestamps are strictly increasing, which eliminates the need for sorting and allows efficient binary search.
- **Parallel Data Structures:** Storing timestamps and values separately in aligned lists maintains the index correspondence, making retrieval straightforward once the correct timestamp index is found.
- **Binary Search on Timestamps:** Finding the largest timestamp ≤ target is a classic binary search variant (lower bound search), which is more efficient than linear search through historical values.
- **No Value Updates:** When the same key is set again, a new entry is created rather than updating existing entries, preserving all historical data for time-based retrieval.

## Key Technique: Binary Search (Lower Bound Variant)
The lower bound binary search finds the largest element in a sorted array that is less than or equal to a target value. This pattern is useful for problems where you need to find the "closest smaller or equal" element, such as stock price tracking, time-based lookups, or range queries. The key adjustment is updating the result variable inside the left-half branch to track valid candidates.

## Edge Cases to Remember
- **Key Not Found:** If the key doesn't exist, return an empty string.
- **Timestamp Too Early:** If the provided timestamp is earlier than all stored timestamps for a key, return an empty string (handle via idx == -1 check).
- **Exact Timestamp Match:** When the exact timestamp exists in the data, binary search will correctly locate it.
- **Multiple Entries for Same Timestamp:** The problem guarantees unique timestamps per key, so this is not a concern.
