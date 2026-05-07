# Problem 49: Group Anagrams

## Problem Overview
Given a list of strings, group strings that are anagrams of each other. An anagram is a word formed by rearranging letters of another word, using the exact same letters with the same frequencies.

## Solution Approach: HashMap with Character Frequency Signature

**Time Complexity:** O(n · k) where n is number of strings, k is average length  
**Space Complexity:** O(n · k)

**Technique:** Hash Map with Frequency-Based Key

## Core Concept
For each string, create a signature based on character frequencies (e.g., count each character and represent as a sorted character-frequency string or array). Use this signature as the key in a HashMap. Strings with identical signatures are anagrams and share the same HashMap key. Collect all strings under their respective signature keys.

## Why This Works
Anagrams have identical character frequency distributions by definition. If two strings have the same characters in the same quantities, their frequency signatures match exactly. By using frequency as the key, you automatically group anagrams together. The specific signature format (sorted chars, frequency map string, or array) doesn't matter as long as identical frequencies produce identical keys.

## Important Insights
- **Signature uniqueness:** Two strings are anagrams if and only if they produce the same frequency signature
- **Why not sorting strings?** You could sort each string and use sorted version as key, but frequency-based keys are equivalent and sometimes faster
- **Key format options:** Sorted character list, frequency array stringified, or custom frequency-to-string mapping all work
- **Empty string handling:** Empty string's signature is consistent; it groups with other empty strings
- **Time per string:** Creating a frequency signature takes O(k) per string; HashMap operations are O(1) average
- **Why HashMap and not sorting?** HashMap approach is O(n·k) single-pass; sorting all strings would be O(n·k·log(k)) if sorting each string or O(n·k·log(n·k)) if sorting the list

## Key Technique: Frequency Signature for Grouping
When grouping elements by equivalence under rearrangement/reordering, create a canonical form (frequency signature) and use it as a grouping key. This pattern applies to: anagram grouping, permutation grouping, and other rearrangement-based equivalence problems.

## Edge Cases to Remember
- **Empty list:** Returns empty result
- **Single string:** Returns list with one group
- **All identical strings:** Returns one group containing all
- **All unique strings:** Each string forms its own group
- **Different cases:** Problem likely specifies lowercase; handle case conversion if needed
