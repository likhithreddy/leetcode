# Problem 1768: Merge Strings Alternately

## Problem Overview
Given two strings `word1` and `word2`, merge them by adding letters in alternating order, starting with `word1`. If one string is longer, append its remaining characters to the end of the merged result.

## Solution Approach: Single Pointer over Common Length

**Time Complexity:** O(n + m) — every character of both strings is appended exactly once  
**Space Complexity:** O(n + m) — the `StringBuilder` holds the full merged result

**Technique:** Two Pointers / Index Traversal with `StringBuilder`

## Core Concept
Iterate up to the length of the shorter string (`minLen`), appending one character from each string per step to interleave them. After the shared portion is consumed, whichever string is longer still has a tail; append that leftover slice in one shot. A single index drives both reads since they advance in lockstep over the common region.

## Why This Works
Alternating merge is only "alternating" while both strings still have characters at the current index — that region spans exactly `min(len1, len2)` positions. Beyond that, only one string contributes, so the remaining characters are simply concatenated in order. Splitting the work into "interleave the overlap, then append the tail" covers every character exactly once with no off-by-one risk.

## Important Insights
- **`minLen` bounds the interleaving:** Looping to `min(len1, len2)` guarantees both `charAt(i)` calls are in bounds, avoiding `IndexOutOfBounds`.
- **Tail handled with `substring`, not a loop:** `substring(minLen, len)` grabs the entire remainder at once, which is cleaner than a second character-by-character loop.
- **Ternary picks the longer string's tail:** Only one of the two strings can have leftover characters, so a single conditional decides which tail (if any) to append.
- **`StringBuilder` avoids O(n²) concatenation:** Repeated `String +=` would create new immutable strings each step; `StringBuilder` mutates in place for amortized O(1) appends.

## Key Technique: Lockstep Two-Pointer Merge
When merging two sequences by interleaving, process the overlapping prefix with a shared index, then handle the unmatched suffix separately. This same shape appears in merging sorted lists/arrays, zipping collections, and any "alternate until one runs out, then drain the rest" pattern. The trick is recognizing that the bounded common region and the leftover tail are two distinct phases.

## Edge Cases to Remember
- **Unequal lengths:** Loop covers only the shared prefix; the ternary appends the longer string's remaining tail.
- **One empty string:** `minLen` is 0, the loop is skipped, and the entire non-empty string is appended as the tail.
- **Equal lengths:** `len1 == len2 == minLen`, so both `substring` ranges are empty and nothing extra is appended.
- **Both empty:** `minLen` is 0 and both tails are empty, correctly returning an empty string.
