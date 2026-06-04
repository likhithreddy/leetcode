# Problem 66: Plus One

## Problem Overview
Given a non-empty array of digits representing a large integer, add one to the number and return the resulting array of digits. The digits are stored in reverse order (least significant digit first, but actually most significant is at index 0).

## Solution Approach: Right-to-Left Carry Propagation

**Time Complexity:** O(n) where n is the length of the digits array  
**Space Complexity:** O(1) if no new array is needed, O(n) in the worst case when all digits are 9

**Technique:** Array Traversal with Carry Handling

## Core Concept
The solution traverses the array from right to left, adding 1 to the last digit and propagating the carry leftward whenever a digit becomes 10. If the first digit carries over (meaning all digits were 9), a new array with an extra digit is created with 1 at the front and all other positions set to 0.

## Why This Works
Adding 1 to the last digit and handling the carry is fundamentally how arithmetic addition works. When a digit becomes 10 after adding the carry, we set it to 0 and propagate the carry to the next digit. This process naturally handles all cases: normal increments, single carries, and the special case of 999...9 becoming 1000...0.

## Important Insights
- **Right-to-left traversal:** Processing from the least significant digit (rightmost) is essential for proper carry propagation
- **Early termination:** If a digit is not 9, we can increment it and return immediately without checking remaining digits
- **Overflow case:** When all digits are 9 (like [9,9,9]), the result requires an additional digit at the front
- **In-place modification:** The solution modifies the input array directly when possible, saving space in most cases

## Key Technique: Carry Propagation
This pattern applies to any arithmetic operation involving digit arrays or strings representing numbers. Whether adding, subtracting, or multiplying large numbers, the key is processing digits sequentially and managing carries correctly. This approach is fundamental to implementing big integer arithmetic in systems where numbers exceed native integer sizes.

## Edge Cases to Remember
- **All nines:** [9,9,9] should return [1,0,0,0]; the solution creates a new array of size n+1
- **Single digit:** [9] becomes [1,0]; [5] becomes [6]; both handled correctly by the algorithm
- **Trailing zeros:** [1,2,3] becomes [1,2,4]; no special handling needed since 3+1=4 with no carry
- **Leading zeros in input:** The problem guarantees no leading zeros except for [0], which becomes [1]
