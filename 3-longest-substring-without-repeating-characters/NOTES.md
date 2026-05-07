# Problem 3: Longest Substring Without Repeating Characters

## Problem Overview
Find the length of the longest contiguous substring that contains no duplicate characters in a given string.

## Solution Approaches Comparison

### Approach 1: Sliding Window + HashMap (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(min(n, charset size))

**Key Idea:** Maintain a sliding window using two pointers (left and right). Store character-to-index mappings in a HashMap. When you encounter a duplicate character, directly jump the left pointer to one position after the last occurrence of that character, avoiding redundant iteration. This direct jump optimization is the critical difference from the brute force approach.

**Why it's optimal:** Eliminates the inner while loop that would otherwise iterate through multiple characters. Each character is processed exactly once, making it truly O(n) with minimal overhead. The HashMap lookup (O(1)) enables instant access to the character's last position.

### Approach 2: Sliding Window + HashSet (Brute Force)
**Time Complexity:** O(n) - but with higher constant factor  
**Space Complexity:** O(min(n, charset size))

**Key Idea:** Track characters in current window using a HashSet. When a duplicate is detected, enter a while loop that removes characters from the left one-by-one until the duplicate is eliminated. This iterative removal is inefficient because you don't know the exact position to jump to, so you might remove multiple characters unnecessarily.

**Why it's brute force:** The inner while loop can execute many times for a single duplicate, essentially performing redundant operations. In worst case (e.g., "abcdefghij" with duplicate at end), you remove characters sequentially instead of jumping directly. The problem-solving logic is correct but not optimized for efficiency.

## Key Differences at a Glance
| Aspect | HashMap (Optimal) | HashSet (Brute Force) |
|--------|------------------|----------------------|
| Position Tracking | Stores character → last index | Only tracks presence |
| On Duplicate Found | Jump left pointer directly | While loop to remove chars |
| Operations per Duplicate | 1 | Multiple (until removed) |
| Best for | Any string | Learning/understanding pattern |

## When to Use Which
- **HashMap approach:** Production code, performance-critical scenarios, large strings
- **HashSet approach:** Understanding the concept, educational purposes, when optimization is not critical

## Important Pattern/Insight
**"Sliding Window with Position Mapping"** — This is a foundational pattern for all substring/subarray problems. The key insight is: once you identify a duplicate, you don't need to check every intermediate position; you can jump directly to where the problem starts. This transforms an O(n²) naive approach into O(n) by storing positions rather than just presence. Remember that the "position-aware" data structure (HashMap vs HashSet) often makes the difference between brute force and optimal.

## Edge Cases to Remember
- **Single character string:** Returns 1
- **All unique characters:** Returns string length
- **All duplicate characters:** Returns 1
- **Duplicate at the very end:** HashSet approach must remove all characters before it; HashMap jumps directly
- **Empty string:** Returns 0 (check for null/empty before processing)
