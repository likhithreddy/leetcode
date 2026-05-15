# Problem 76: Minimum Window Substring

## Problem Overview
Given two strings s and t, find the minimum window substring in s that contains all characters in t. A window substring must contain all the characters in t (including duplicates), and you need to return the smallest such substring. If no such substring exists, return an empty string.

## Solution Approach: Sliding Window with Character Frequency Counter

**Time Complexity:** O(|s| + |t|) where |s| and |t| are the lengths of strings s and t  
**Space Complexity:** O(|t|) for the character frequency array (fixed at 128 for ASCII characters)

**Technique:** Sliding Window with Array-based Frequency Counter

## Core Concept
Use a two-pointer sliding window technique combined with a frequency counter. Expand the right pointer to include more characters until all required characters from t are present in the window (formed == t.length()). Once you have a valid window, contract from the left to find the minimum window while maintaining the valid condition. The key insight is to use a character frequency array instead of a HashMap for O(1) lookups and updates, and track "formed" count (number of characters we've included) to quickly check if the window is valid.

## Why This Works
The sliding window approach works because: (1) we expand the window by moving right until we have all required characters; (2) we shrink from the left while the window remains valid to find the smallest valid window; (3) we never need to move left backwards because if a window [left, right] is invalid, then [left-1, right] would also be invalid for the same character constraint. The frequency counter tracks character requirements from t and lets us know when we've satisfied all constraints.

## Important Insights
- **Frequency Counter Pattern:** Using an array indexed by character ASCII value (need[c]) allows O(1) access and modification. Incrementing/decrementing happens as we add/remove characters from the window.
- **Two-Phase Window Expansion and Contraction:** The algorithm alternates between expanding the window (right pointer) to find valid windows and contracting it (left pointer) to minimize size. This ensures we never miss the optimal answer.
- **"Formed" Counter:** Tracking formed (number of required characters we've collected) lets us check validity in O(1) time instead of re-scanning the entire window. Each character contributes 1 to formed when its requirement changes from unmet to met.
- **Decrement-First Logic:** The key operation is need[c]-- > 0, which decrements FIRST, then checks. This works because: if need[c] > 0 before decrement, the character was required; if it becomes 0 or negative after decrement, we've satisfied that character's requirement.

## Key Technique: Sliding Window with Frequency Counter
The sliding window pattern is foundational for substring/subarray problems. The critical optimization here is recognizing that you can use a simple array counter instead of a HashMap (for ASCII characters), making lookups and updates truly O(1) with minimal overhead. When a character count goes from positive to zero (or vice versa during contraction), it affects the "formed" count directly. This technique extends to similar problems like "Permutation in String" and "Contains Duplicate II" where you need to track character frequencies within a window.

## Edge Cases to Remember
- **Empty strings:** If either s or t is empty, handle appropriately (return empty string if t is empty, or "" if s is too short)
- **t longer than s:** No valid window exists, return empty string
- **Single character:** If t has length 1, find that character in s and return it
- **Entire string is window:** The whole string s might be the minimum window (e.g., s="aab", t="aab")
- **Duplicate characters in t:** The need array must account for duplicates. If t="aa", we need 2 'a's in the window, not just 1
- **No valid window:** If s doesn't contain all characters from t, return empty string ""
