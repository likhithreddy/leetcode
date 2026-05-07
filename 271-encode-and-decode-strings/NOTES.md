# Problem 271: Encode and Decode Strings

## Problem Overview
Design an algorithm to encode a list of strings into a single string, and decode it back into the original list of strings. The strings can contain any character including whitespace, commas, and special characters.

## Solution Approach: Character Mapping with Delimiters

**Time Complexity:** O(n·k) where n is number of strings, k is average length  
**Space Complexity:** O(n·k) for encoded string

**Technique:** Delimiter-Based Encoding with ASCII Mapping

## Core Concept
**Encoding:** For each string, convert each character to its ASCII numeric value (with leading zeros for consistency), concatenate all values, and append a delimiter (e.g., "#"). Use a different delimiter (e.g., "|") to separate strings. Concatenate all encoded strings.
**Decoding:** Parse by looking for string delimiters. For each string segment, parse pairs of digits to reconstruct ASCII values, convert back to characters.

## Why This Works
By converting characters to numbers, you eliminate ambiguity about what constitutes a character (especially problematic with special characters, whitespace, and multi-byte characters). Delimiters mark boundaries between strings and characters. The encoding is unambiguous: any encoded string can be uniquely decoded because character boundaries are explicit (fixed-width ASCII codes).

## Important Insights
- **Delimiter choice:** Use characters unlikely to appear naturally (like "#" and "|") or use length-prefixed encoding instead
- **ASCII mapping:** Ensures all characters map consistently and can represent any character
- **Fixed-width digits:** Using consistent digit width (e.g., always 3 digits) enables unambiguous parsing
- **Escape handling:** Some implementations avoid ASCII mapping by using length-prefix encoding instead
- **Edge case: empty string:** Must handle strings that are empty themselves within the list
- **Alternative approach:** Use length-prefix encoding (store string length before content) instead of ASCII mapping

## Key Technique: Encoding with Explicit Boundaries
When encoding data that contains unknown/special characters, use explicit delimiters or length-prefixes rather than assuming separators will work. This pattern applies to: serialization, protocol design, and encoding problems where data integrity is critical.

## Edge Cases to Remember
- **Empty list:** Encodes to empty string
- **List with empty strings:** Must preserve the empty string in encoding
- **Strings with special characters:** All characters encode consistently
- **Strings with delimiters:** Since using ASCII mapping, delimiters in original strings don't cause issues
- **Very long strings:** Encoding length grows linearly; no overflow issues
