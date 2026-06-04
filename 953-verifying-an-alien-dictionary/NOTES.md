# Problem 953: Verifying an Alien Dictionary

## Problem Overview
Given a list of words and an order of letters in an alien dictionary, verify if the words are sorted according to the alien dictionary's order.

## Solution Approach: Character Mapping with Order Comparison

**Time Complexity:** O(m × n) where m is the number of words and n is the average length of words  
**Space Complexity:** O(1) (constant space for the 26-letter alphabet mapping)

**Technique:** Hash Map/Array Mapping, Two Pointers

## Core Concept
The algorithm first creates a mapping from each character to its position in the alien dictionary order. Then it compares adjacent words by iterating through their characters and checking if they follow the alien dictionary order using this mapping. If at any point a character in the first word has a higher position than the corresponding character in the second word, the words are not sorted. The algorithm handles the edge case where one word is a prefix of another (the longer word should not come before the shorter one).

## Why This Works
By precomputing a position mapping for each character (0-25), we can instantly determine the order relationship between any two characters in O(1) time. This reduces the problem to a straightforward comparison of adjacent words using their character positions. The key insight is that for words to be sorted in an alien dictionary, each adjacent pair must satisfy the ordering constraint, which is sufficient to verify the entire list is sorted.

## Important Insights
- **Character Mapping:** Creating an array that maps each character to its position in the alien order allows constant-time lookups for character comparisons.
- **Adjacent Word Comparison:** We only need to verify that each adjacent pair of words is in correct order. If all adjacent pairs are ordered correctly, the entire list is sorted.
- **Prefix Check:** A critical edge case is when one word is a prefix of another. For example, "apple" and "app"—the shorter word should come first. If we find they match up to the shorter word's length and the first word is longer, the list is invalid.
- **Early Termination:** As soon as we find an incorrect ordering between any character pair, we can return false immediately.

## Key Technique: Character Position Mapping
This technique is useful whenever you need to establish a custom ordering of elements. Instead of comparing characters directly (which uses lexicographic ordering), we map them to positions in a custom order and compare positions. This pattern generalizes to custom sorting problems where elements have a defined priority or order that differs from the standard ordering.

## Edge Cases to Remember
- **Empty list or single word:** A list with zero or one word is always sorted and should return true.
- **Identical words:** Words that are identical should be considered in correct order and should return true.
- **Prefix ordering:** A word cannot come after its prefix in a valid sort order (e.g., "app" must come before "apple").
- **Different character orders:** Even if two words differ at their first character, the comparison is correct as long as the first differing character respects the alien dictionary order.
