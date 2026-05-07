# Problem 136: Single Number

## Problem Overview
Given a list where every number appears exactly twice except for one number that appears once, find that single number. You must achieve this with O(1) space complexity (cannot use additional data structures to store values).

## Solution Approach: Bitwise XOR Trick

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Bitwise XOR (Exclusive OR) Operation

## Core Concept
XOR two identical numbers results in 0 (a ⊕ a = 0). XOR any number with 0 results in the number itself (a ⊕ 0 = a). Therefore, XOR all numbers together: pairs cancel out to 0, leaving only the single unpaired number. The order of XOR operations doesn't matter due to commutativity and associativity.

## Why This Works
The XOR operation has the exact properties needed: (1) identical values cancel to 0, (2) XOR with 0 preserves value, (3) operation is commutative and associative so order doesn't matter. When you XOR all elements, every number appearing twice cancels to 0, and you're left with the single number. This elegant mathematical property solves the problem without extra space.

## Important Insights
- **XOR properties:** Understand that a ⊕ a = 0 and a ⊕ 0 = a are the core
- **Commutativity:** XOR order doesn't matter; (1 ⊕ 2 ⊕ 1) = (1 ⊕ 1 ⊕ 2) = 2
- **Bit-level perspective:** XOR operates on individual bits; identical bits cancel (1⊕1=0, 0⊕0=0), different bits stay (1⊕0=1, 0⊕1=1)
- **Why O(1) space?:** No additional data structures; just a single variable for the running XOR result
- **Generalization:** This pattern (using XOR properties) extends to "find the number appearing once when others appear n times" with different techniques

## Key Technique: XOR for Symmetric Property Exploitation
When you have pairs or symmetric relationships and need to eliminate them while preserving unique elements, consider XOR. This pattern applies to: single number problems, swap without temporary variable, detect duplicate in circular array, and bit manipulation puzzles.

## Edge Cases to Remember
- **Single element list (single number appears once, none twice):** Returns that element
- **All zeros with one different:** Works correctly (0 ⊕ 0 ⊕ x = x)
- **Negative numbers:** XOR operations work on two's complement representation; algorithm handles naturally
- **Large numbers:** No overflow issues; XOR result fits in same bit width
