# Problem 2: Add Two Numbers

## Problem Overview
Given two non-empty linked lists representing two non-negative integers in reverse order (with digits stored in reverse), add the two numbers and return the sum as a linked list in reverse order. For example, 342 + 465 = 807 is represented as [2,4,3] + [5,6,4] = [7,0,8].

## Solution Approach: Single Pass Linked List Traversal with Carry

**Time Complexity:** O(max(m, n)) where m and n are the lengths of the two linked lists  
**Space Complexity:** O(max(m, n)) for the result linked list

**Technique:** Linked List Traversal, Carry Propagation

## Core Concept
Traverse both linked lists simultaneously from their heads, adding corresponding digits together along with any carry from the previous addition. Create a new node for each resulting digit (sum % 10) and propagate the carry (sum / 10) to the next iteration. Continue until both lists are exhausted and no carry remains. The digits are processed in reverse order naturally because the lists store numbers in reverse.

## Why This Works
Since the numbers are stored in reverse order, we can add them digit by digit from the beginning of the lists, just like traditional addition works. The carry naturally flows from one digit position to the next, and a single left-to-right pass handles the entire addition. This approach correctly handles lists of different lengths and the final carry that might extend the result list by one node.

## Important Insights
- **Reverse Order Storage:** The reverse representation is the key insight enabling efficient single-pass addition without needing to reverse the lists or use extra space for reversal.
- **Carry Handling:** Managing carry across iterations is essential; it persists even after both input lists are exhausted if the final sum has a carry (e.g., 99 + 1 = 100).
- **Different List Lengths:** The while condition (a != null || b != null || carry == 1) elegantly handles lists of different lengths by treating null values as 0 and continuing until all input is consumed.
- **Dynamic Result Construction:** Building the result list by maintaining a tail pointer and linking new nodes allows us to construct the answer in a single pass without needing to know the final length in advance.

## Key Technique: Carry Propagation with List Traversal
This pattern applies broadly to problems involving arithmetic operations on numbers represented as linked lists or arrays, such as multiplication of linked list numbers, subtraction, or comparison. The key principle is processing digits from least to most significant while maintaining carry state. This generalizes to any base-k number representation.

## Edge Cases to Remember
- **Different List Lengths:** When one list is longer, continue processing remaining digits with carry, treating missing nodes as 0.
- **Carry Overflow:** After both lists are exhausted, if carry == 1, create an additional node with value 1 (e.g., 99 + 1 = 100).
- **All Zeros:** Lists containing only zeros produce a single result node with value 0.
- **Single Digit Lists:** Two single-digit numbers may produce a two-digit result (e.g., 5 + 5 = 10), handled by the carry overflow case.
