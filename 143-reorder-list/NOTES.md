# Problem 143: Reorder List

## Problem Overview
Given a singly linked list, reorder it such that the list follows the pattern: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...

## Solution Approach: Find Middle, Reverse, and Merge

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Fast and Slow Pointers, Linked List Reversal, Two-pointer Merging

## Core Concept
This solution works by breaking the problem into three steps: (1) use fast and slow pointers to find the middle of the list, (2) reverse the second half of the list, and (3) merge the first half and reversed second half by alternating nodes. The key insight is that we can rearrange the list in-place by manipulating node pointers without extra space.

## Why This Works
By splitting the list into two halves and reversing the second half, we can interleave elements from both ends of the original list. When we iterate through both halves simultaneously and alternate between them, we naturally create the desired reordered pattern. This works because reversing the second half flips the order of the back elements, allowing us to match them with front elements from the first half.

## Important Insights
- **Fast and Slow Pointers:** Using fast (moves 2 steps) and slow (moves 1 step) pointers allows us to find the middle in O(n) time with a single pass. When fast reaches the end, slow is at the middle.
- **Reversing the Second Half:** After finding the middle with slow pointer, we can reverse everything from `slow.next` to the end. This gives us the back half in reversed order.
- **Breaking the Link:** After reversing, we must set `slow.next = null` to break the link between the two halves. This prevents infinite loops during merging.
- **Alternating Merge:** Merge the two halves by alternately picking nodes from each list. Store the next pointers before overwriting them to avoid losing references.

## Key Technique: Fast and Slow Pointers with In-place Modification
Fast and slow pointers is a common pattern for finding the middle of a linked list. Combined with linked list reversal and careful pointer manipulation, we can reorder the list in-place without extra data structures. This technique generalizes to other linked list problems where you need to find middle points, detect cycles, or rearrange nodes.

## Edge Cases to Remember
- **Single Node or Empty List:** If the list has 0 or 1 node, no reordering is needed. Check if `head == null || head.next == null` at the start.
- **Two Node List:** With only two nodes, the fast pointer's next jump lands on null, so slow ends up at the first node. The logic still works correctly.
- **Pointer Loss:** When merging, always save `next1` and `next2` before modifying the next pointers, otherwise you'll lose references and create broken chains.
- **Infinite Loops:** Forgetting to set `slow.next = null` after reversing causes the second half to still point back to the first half, creating a cycle during merge.
