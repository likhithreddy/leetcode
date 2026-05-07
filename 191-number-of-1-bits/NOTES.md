# Problem 191: Number of 1 Bits

## Problem Overview
Count the number of 1 bits (set bits) in the binary representation of a positive integer.

## Solution Approach: Brian Kernighan's Algorithm

**Time Complexity:** O(k) where k is the number of 1 bits (not O(32) but actual count)  
**Space Complexity:** O(1)

**Technique:** Bit Manipulation with n & (n-1) Trick

## Core Concept
Use the clever operation: n & (n-1). This operation removes the rightmost 1 bit from n. Why? Because n-1 flips all bits after the rightmost 1 (and that 1 becomes 0), so n & (n-1) zeros out the rightmost 1 bit while keeping everything else. Count how many times you can apply this operation before n becomes 0; each application removes one 1 bit.

## Why This Works
The trick n & (n-1) exploits how binary subtraction works. When you subtract 1 from n, all bits after the rightmost 1 flip (because of the borrow), and that rightmost 1 becomes 0. The AND of these two numbers (original and decremented) keeps only the bits that haven't been affected, effectively removing the rightmost 1. Repeat until n is 0.

## Important Insights
- **Optimization insight:** Instead of checking all 32 bits, you only iterate k times where k is the number of 1 bits
- **Brian Kernighan's Algorithm name:** Named after Brian Kernighan; considered one of the most elegant bit manipulation tricks
- **Bit-by-bit alternative:** You could check each bit with (n >> i) & 1 for each position, but that's always 32 iterations
- **Why this is better:** For numbers with few 1 bits, this is much faster (O(k) vs. O(32))
- **Subtraction mechanics:** Understanding why n-1 flips bits after the rightmost 1 is the key to understanding this algorithm

## Key Technique: Smart Bit Removal with n & (n-1)
When you need to count or process bits efficiently, n & (n-1) is a powerful trick. It directly removes the rightmost 1 bit without examining other bits. This pattern applies to: bit counting, checking power of 2 (if n & (n-1) == 0, n is power of 2), and bit manipulation optimizations.

## Edge Cases to Remember
- **Zero:** 0 has zero 1 bits (no iterations occur)
- **One:** 1 has one 1 bit (one iteration)
- **All ones (32 bits):** Results in count of 32
- **Powers of two:** Only one 1 bit (one iteration)
- **Odd vs. even:** Odd numbers have rightmost bit 1; even numbers don't
