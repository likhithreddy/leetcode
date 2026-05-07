# Problem 190: Reverse Bits

## Problem Overview
Reverse the bits of a 32-bit unsigned integer. For example, input 00000010100101000001111010011100 becomes 00111001011110000101000101000000.

## Solution Approach: Bit Extraction and Reconstruction

**Time Complexity:** O(1) - always exactly 32 iterations  
**Space Complexity:** O(1)

**Technique:** Bit Manipulation with Left Shift and Right Shift

## Core Concept
Iterate exactly 32 times. Extract the least significant bit (rightmost) of the input using modulo 2 or bitwise AND with 1. Shift this bit left into the result variable. Right-shift the input to process the next bit. Repeat until all 32 bits are processed. The result variable is built from LSB to MSB, effectively reversing the bit order.

## Why This Works
Bits must be extracted one at a time. By always taking the least significant bit (rightmost) and building the result from left (shifting left each time), you effectively reverse the bit order. 32 iterations ensure all bits are processed exactly once, and the bit positions are naturally reversed through the shifting operations.

## Important Insights
- **Fixed iterations:** Always 32 iterations for 32-bit integers; no early termination possible
- **Bit extraction:** n & 1 gets the rightmost bit; n >> 1 shifts right to process next bit
- **Result building:** result << 1 makes space for new bit; result |= bit adds new bit
- **Unsigned arithmetic:** Problem deals with unsigned integers; sign extension doesn't apply
- **Bit order vs. byte order:** This reverses bit order (00...1 becomes 1...00), not byte order
- **Alternative approach:** Could also use array of bits or string representation, but bit operations are most efficient

## Key Technique: Bit Manipulation for Bit-Level Processing
When processing individual bits, combine extraction (AND, modulo), shifting (<<, >>), and reconstruction (OR, addition) operations. This pattern applies to: reversing bits, counting bits, swapping bits, and any bit-level manipulation.

## Edge Cases to Remember
- **Zero:** All bits are 0; result is 0
- **All ones (32 bits set):** Result is also all ones
- **Single bit set:** Moves from one end to the other
- **Alternating bits:** Pattern reverses accordingly
- **Powers of two:** Only one bit set; cleanly moves to reversed position
