# Problem 567: Permutation in String

## Problem Overview
Given two strings s1 and s2, determine if a permutation of s1 exists as a substring in s2. A permutation has the same characters with the same frequencies, regardless of order.

## Solution Approach: Sliding Window with Character Frequency Matching

**Time Complexity:** O(n) where n is length of s2  
**Space Complexity:** O(1) - fixed size alphabet

**Technique:** Sliding Window + Frequency Comparison

## Core Concept
Create a sliding window of size len(s1) over s2. For each window position, check if character frequencies in the window match frequencies in s1. If they match, s1's permutation is found. Use a HashMap or frequency array to track character frequencies.

## Why This Works
A permutation of s1 has identical character frequencies as s1. By comparing frequencies of a window (same size as s1) in s2 with frequencies of s1, you can detect if that window is a permutation. The sliding window ensures you check every possible substring of the required length.

## Important Insights
- **Window size:** Must be exactly len(s1); no need to check windows of other sizes
- **Frequency matching:** Only frequencies matter, not order; two windows with same frequencies are permutations of each other
- **Efficient frequency updates:** Instead of recalculating frequencies for each window, update incrementally as you slide
- **Early termination:** Once a match is found, return true; no need to continue sliding
- **Edge case: s1 longer than s2:** No permutation possible; return false immediately
- **Character set:** Frequency comparison is simpler than substring comparison

## Key Technique: Frequency-Based Substring Matching
When matching substrings based on character composition (permutation, anagram), compare frequencies rather than exact order. Sliding window enables efficient frequency updates as you progress.

## Edge Cases to Remember
- **s1 longer than s2:** Returns false
- **s1 equals s2:** Returns true (entire string is a permutation of itself)
- **s1 is empty:** Empty string's permutation exists everywhere (return true)
- **Single character s1:** Check if character exists in s2
- **All same characters in s1:** Any substring of same length with all same characters matches
