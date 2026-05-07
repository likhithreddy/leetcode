# Problem 242: Valid Anagram

## Problem Overview
Determine whether two strings are anagrams of each other (contain exactly the same characters with the same frequencies, regardless of order).

## Solution Approaches Comparison

### Approach 1: HashMap with Character Frequency (Brute Force)
**Time Complexity:** O(n)  
**Space Complexity:** O(1) - bounded by character set (26 lowercase letters)

**Key Idea:** Create a HashMap to count character frequencies in the first string. Then iterate through the second string, decrementing counts for each character found. Finally, verify all counts are zero. The approach is general-purpose and works for any character set size.

**Why it's brute force:** Uses a HashMap, a more complex data structure, when the problem domain is restricted (lowercase English letters only). The HashMap involves hash function calculations, potential collisions, and O(1) average-case complexity that still has overhead. You're using a general-purpose tool for a specific problem.

### Approach 2: Fixed-Size Array with Alphabet Indices (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(1) - always 26 elements for 26 letters

**Key Idea:** Use an integer array of size 26, where index 0 represents 'a', index 1 represents 'b', etc. Increment counts for characters in first string, decrement for second string. Check if all counts are zero. Directly indexes the array using `character - 'a'` instead of hash-based lookup.

**Why it's optimal:** Array access is faster than HashMap operations (direct index vs. hash calculation). No collision handling overhead. Fixed space of exactly 26 elements is predictable and minimal. Direct character-to-index mapping (char - 'a') is O(1) with zero overhead compared to HashMap's hash function.

## Key Differences at a Glance
| Aspect | HashMap | Fixed-Size Array |
|--------|---------|-----------------|
| Data Structure | Hash map (general) | Integer array (specific) |
| Access Time | O(1) average, with hash overhead | O(1) direct, no overhead |
| Space | Variable with load factor | Fixed 26 elements |
| Scalability | Works for any character set | Optimized for English lowercase |
| Cache Efficiency | Poorer (hash table layout) | Better (contiguous array) |

## When to Use Which
- **HashMap:** When character set is unknown/large, code generality is needed, or problem may extend to Unicode/arbitrary characters
- **Fixed Array:** Lowercase English letters, performance-critical code, embedded systems, technical interview when constraints are given

## Important Pattern/Insight
**"Domain-Specific Optimization"** — This pattern teaches that general-purpose data structures (HashMap) aren't always optimal for specific domains. When you have explicit constraints (only 26 letters), leverage them. The lesson: Identify constraints in the problem and use specialized data structures that exploit those constraints. Array indexing via `char - 'a'` is a classic technique—it transforms a character comparison problem into direct array indexing. Always ask: "Can I use a smaller, simpler structure that's optimized for my specific domain?" This principle applies beyond just arrays: if you know maximum values, use bounded data structures.

## Edge Cases to Remember
- **Empty strings:** Both empty strings are anagrams (return true)
- **Different lengths:** Cannot be anagrams (return false immediately)
- **Same string:** Always anagrams (all frequencies match perfectly)
- **One character repeated:** Both algorithms handle efficiently
- **Frequency edge case:** Character appears multiple times (array increments correctly, HashMap key-value associations preserved)
