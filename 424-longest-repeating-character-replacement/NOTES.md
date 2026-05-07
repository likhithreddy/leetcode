# Problem 424: Longest Repeating Character Replacement

## Problem Overview
Given a string and an integer k, find the length of the longest substring where you can make all characters the same by replacing at most k characters.

## Solution Approach: Sliding Window with Greedy Expansion

**Time Complexity:** O(n·26) ≈ O(n)  
**Space Complexity:** O(1) - fixed size alphabet

**Technique:** Sliding Window with Character Frequency Tracking

## Core Concept
Maintain a sliding window with left and right pointers. Track character frequencies within the window. For each position of the right pointer, calculate how many characters need replacement: window_length - max_frequency_in_window. If replacements needed exceed k, shrink the window from the left. Keep expanding right and track the maximum valid window size.

## Why This Works
At any window, if you convert all characters to the most frequent character in the window, you need (window_size - max_frequency) replacements. This must be ≤ k. By shrinking when the condition violates and expanding otherwise, you maintain the invariant that the current window is always valid.

## Important Insights
- **Greedy expansion:** Once you find a valid window, you don't need to shrink it fully; shrink just enough to become valid again
- **Max frequency tracking:** Only the most frequent character matters; less frequent ones might be replaced
- **Window shrinking condition:** When replacements > k, shrink from left until valid
- **Right pointer drives expansion:** Right pointer always moves forward (or stays), ensuring O(n) complexity
- **Character frequency map:** Track frequencies of 26 lowercase letters (or the relevant alphabet)
- **Sliding window pattern:** This is a classic sliding window problem where validity condition depends on window content

## Key Technique: Sliding Window for Substring Validity
When finding optimal substrings with a validity condition based on window content, use sliding window. Maintain necessary state (like character frequencies), expand right greedily, and shrink left when needed to restore validity.

## Edge Cases to Remember
- **k = 0:** Only substrings of same character are valid
- **k ≥ string length:** Entire string is valid (can replace all characters)
- **String of same character:** No replacements needed; entire string is valid
- **Very long window:** Window size capped by string length
- **All different characters:** Window can only be size k+1 (one unique char + k replacements)
