# Problem 168: Excel Sheet Column Title

## Problem Overview
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet. For example, 1 → "A", 26 → "Z", 27 → "AA", etc.

## Solution Approach: Base-26 Conversion with Adjustment

**Time Complexity:** O(log₂₆(n)) where n is the columnNumber  
**Space Complexity:** O(log₂₆(n)) for the StringBuilder output

**Technique:** Mathematical Base Conversion, String Building

## Core Concept
The problem is essentially converting a number to base-26 representation, but with a twist: the numbering is 1-indexed (A=1) rather than 0-indexed (A=0). The key insight is to subtract 1 from the columnNumber before taking the modulo operation. This adjustment ensures that the 26th column maps to 'Z' instead of wrapping around. We repeatedly extract the remainder (columnNumber % 26) to get each character, building the result from right to left by inserting at the beginning of the StringBuilder.

## Why This Works
The algorithm works because we're performing a base conversion with a 1-indexed system. By subtracting 1 before each modulo operation, we align the mathematical conversion with Excel's column naming scheme where there is no "zero" letter. The division by 26 after each iteration ensures we process all digits in the base-26 number system, moving from the least significant digit to the most significant.

## Important Insights
- **Subtract before modulo:** We must subtract 1 before taking modulo because Excel uses 1-indexing (A=1) not 0-indexing (A=0). This prevents off-by-one errors.
- **Insert at beginning:** Using `sb.insert(0, ch)` builds the string from right to left, which is natural for base conversion where we extract digits from least to most significant.
- **Character mapping:** ASCII value 65 is 'A', so `(char)(65 + remainder)` directly converts a value 0-25 to letters A-Z.
- **Loop termination:** The loop continues while columnNumber > 0. After dividing by 26, eventually the number becomes 0, and we've built the complete column title.

## Key Technique: Base-N Number System Conversion
This problem demonstrates the fundamental pattern of converting a decimal number to another base. The standard algorithm is to repeatedly take modulo with the base and divide by the base. However, this problem adds complexity by using 1-indexing instead of 0-indexing, which requires the initial subtraction adjustment. This pattern appears in many real-world problems: phone keypad letter mapping, URL shortening algorithms, and other numeral system conversions.

## Edge Cases to Remember
- **columnNumber = 1:** Should return "A". After subtracting 1, remainder is 0, which maps to 'A' (65 + 0).
- **columnNumber = 26:** Should return "Z". After subtracting 1, we get 25, modulo 26 is 25, which maps to 'Z' (65 + 25).
- **columnNumber = 27:** Should return "AA". First iteration gives 'A', then after division by 26 we have 1, subtract to get 0, which gives another 'A'.
- **Large numbers (e.g., 702):** The algorithm correctly handles multi-letter results. 702 becomes "ZZ" through multiple iterations of the conversion loop.
