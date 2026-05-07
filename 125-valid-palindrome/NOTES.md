# Problem 125: Valid Palindrome

## Problem Overview
Determine whether a string is a valid palindrome when considering only alphanumeric characters (ignoring spaces, punctuation, etc.) and treating uppercase and lowercase as equivalent.

## Solution Approaches Comparison

### Approach 1: String Cleanup Then Two Pointers (Brute Force)
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Key Idea:** First pass through the string, build a new cleaned string containing only alphanumeric characters in lowercase. Second pass, use two pointers from both ends of the cleaned string to verify palindrome property. The problem is cleanly separated into two distinct phases: filtering then validation.

**Why it's brute force:** Creates an entirely new string in memory before performing the palindrome check. This uses extra space and requires traversing the string twice—once to build the cleaned string, once to validate. You're materializing an intermediate data structure (the cleaned string) that you don't fundamentally need to solve the problem.

### Approach 2: Two Pointers with On-the-Fly Validation (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Key Idea:** Use two pointers starting from both ends of the original string. Skip non-alphanumeric characters dynamically by advancing pointers. When both pointers land on alphanumeric characters, compare their lowercase versions. Continue until pointers meet. This performs validation and character filtering in a single pass without creating new data structures.

**Why it's optimal:** Eliminates the O(n) space overhead of building a new string. The string is scanned exactly once (two pointers approach each other), and decisions are made in-place. The pointer advancement logic handles non-alphanumeric skipping naturally without needing to build an intermediate structure.

## Key Differences at a Glance
| Aspect | String Cleanup (Brute Force) | Two Pointers (Optimal) |
|--------|------------------------------|----------------------|
| Space Usage | O(n) for cleaned string | O(1) constant space |
| Data Structure | Creates StringBuilder/String | No intermediate storage |
| Passes | Two passes (build + validate) | One pass (simultaneous) |
| Pointer Logic | Simple (clean string indices) | More complex (skip non-alphanumeric) |

## When to Use Which
- **String Cleanup:** When code clarity/readability is prioritized over space, teaching purposes, or when the problem explicitly asks for a cleaned string
- **Two Pointers:** Production environments, memory-constrained systems, technical interviews, any space-efficient requirement

## Important Pattern/Insight
**"Skip Logic in Two-Pointer Traversal"** — The critical technique here is the while loop that advances pointers past non-alphanumeric characters before comparison. This inline filtering is the key to achieving O(1) space. Pattern: When two-pointer validation seems to require pre-processing or a cleaned version of data, consider adding conditional advancement logic to handle filtering during the traversal itself. This converts "two separate operations" into "one integrated operation," reducing space complexity and often simplifying code once you understand the pattern.

## Edge Cases to Remember
- **No alphanumeric characters:** Returns true (empty palindrome is valid)
- **Single alphanumeric character:** Returns true
- **All spaces/punctuation:** Returns true
- **Mixed case:** Must convert to same case before comparison (handle in comparison logic)
- **Palindrome with many non-alphanumeric interspersed:** Two-pointer approach shines here (fewer duplicated checks)
- **Very long string with few alphanumeric:** Two-pointer still O(n) due to skipping logic
