# Problem 338: Counting Bits

## Problem Overview
Given an integer n, compute the number of 1 bits in the binary representation of each number from 0 to n, returning an array where index i contains the count for number i.

## Solution Approach: Brian Kernighan's Algorithm Per Number

**Time Complexity:** O(n·log n) - for each number up to n, count its bits  
**Space Complexity:** O(1) excluding output array

**Technique:** Bit Manipulation (n & (n-1) Trick)

## Core Concept
For each number from 0 to n, count its 1 bits using Brian Kernighan's algorithm: repeatedly apply n & (n-1) to remove the rightmost 1 bit, counting iterations until n becomes 0. Store the count at index i in the result array.

## Why This Works
Brian Kernighan's algorithm efficiently counts 1 bits by removing the rightmost 1 in each iteration. The operation n & (n-1) removes exactly one 1 bit per operation, so the iteration count equals the number of 1 bits. This is O(k) where k is the number of bits, much better than checking all 32 bit positions.

## Important Insights
- **Efficient bit counting:** Counting only actual 1 bits (not all bit positions) makes this faster than fixed 32 iterations
- **Array-based approach:** Computing all values 0 to n together is more efficient than computing each independently
- **Memory vs. computation:** Storing results enables quick lookup; trading O(n) space for better constant factors
- **Dynamic Programming insight:** You could optimize further by using DP (each number's count relates to previous numbers), but straightforward bit counting is already efficient
- **Why not bit-by-bit?** Checking all 32 bits per number would be O(32n) = O(n); Kernighan's is O(n·k) where k is average bit count
- **Bit operation foundation:** Understanding n & (n-1) is prerequisite knowledge for bit manipulation problems

## Key Technique: Iterative Bit Counting with n & (n-1)
When counting 1 bits repeatedly, Kernighan's algorithm is superior to checking all bit positions. The n & (n-1) operation is fundamental to efficient bit manipulation.

## Edge Cases to Remember
- **n = 0:** Returns [0] (zero has zero 1 bits)
- **n = 1:** Returns [0, 1] (1 has one 1 bit)
- **Powers of two:** Only one 1 bit (efficient to count)
- **n = 2^k - 1 (all bits set):** Result has k 1 bits for number 2^k - 1
- **Odd vs. even:** Odd numbers always have rightmost bit 1
