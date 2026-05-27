# Problem 91: Decode Ways

## Problem Overview
Given a string `s` of digits, each digit (or pair of digits) maps to a letter using the encoding `'A' -> "1"`, `'B' -> "2"`, ..., `'Z' -> "26"`. Return the number of distinct ways to decode `s` into a valid letter string.

## Solution Approach: Dynamic Programming

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Dynamic Programming (Bottom-Up Tabulation)

## Core Concept
At each position i, the number of ways to decode the prefix `s[0..i-1]` equals the sum of two independent contributions: decode the last single digit `s[i-1]` (valid only if it is between `1` and `9`) and add `dp[i-1]`, plus decode the last two digits `s[i-2..i-1]` as one letter (valid only if the pair is between `10` and `26`) and add `dp[i-2]`. The recurrence `dp[i] = (valid single ? dp[i-1] : 0) + (valid double ? dp[i-2] : 0)` builds the count incrementally, with `dp[0] = dp[1] = 1` anchoring the empty prefix and the first valid character.

## Why This Works
Every valid decoding of `s[0..i-1]` ends in either a one-digit letter or a two-digit letter, and these two cases are mutually exclusive and exhaustive. Counting decodings that end in a single digit reduces the problem to counting decodings of `s[0..i-2]`, and counting those ending in a two-digit letter reduces it to `s[0..i-3]`; summing both gives the total without double-counting because the final letter's length partitions the decoding space. The validity checks (`1-9` for singles, `10-26` for pairs) prune impossible suffixes, so a leading zero in either position contributes nothing — preserving correctness for strings like `"06"` or `"100"`.

## Important Insights
- **Leading zero kills the string:** If `s[0] == '0'`, no decoding exists since no letter maps to `0`, so return `0` immediately
- **Zero is only valid as the second digit of a pair (`10` or `20`):** A standalone `0` contributes nothing via the single-digit branch; it must be absorbed into a `10`-`20` pair or the count drops to `0`
- **Two independent branches, additive:** Unlike Climbing Stairs where both branches always contribute, here each branch is gated by its own validity check — either or both can be zero
- **Base case `dp[0] = 1`:** Represents the empty prefix having exactly one decoding (the empty string); this is what lets the two-digit branch correctly seed the count when the first two characters form a valid pair like `"12"`

## Key Technique: Constrained "Take 1 or Take 2" DP
This is the Climbing Stairs / Fibonacci-style recurrence with validity gates: when a problem asks "how many ways to partition a sequence into chunks of size 1 or 2," define `dp[i]` as the count for the prefix of length i and add contributions from each chunk size only when that chunk is legal. The pattern generalizes to any problem where decisions chunk the input with constraints — tile placement, word segmentation with a small dictionary, or staircase variants with forbidden steps. Space can be reduced to O(1) by keeping only `dp[i-1]` and `dp[i-2]`, since the recurrence has depth 2.

## Edge Cases to Remember
- **Empty string:** Guarded by the `n == 0` check; returns `0` (problem typically guarantees non-empty, but the check is defensive)
- **String starting with `'0'`:** Returns `0` immediately — no valid decoding can begin with a zero
- **Standalone zero mid-string (e.g., `"103"`):** The `0` fails the single-digit check, so the only way forward is the `"10"` pair; if the preceding digit isn't `1` or `2`, total becomes `0` (e.g., `"301"` returns `0`)
- **Pairs above 26 (e.g., `"27"`):** Two-digit branch contributes `0`; only the single-digit decomposition survives, yielding `1` way
