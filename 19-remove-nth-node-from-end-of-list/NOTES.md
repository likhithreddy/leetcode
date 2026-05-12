# Problem 19: Remove Nth Node From End of List

## Problem Overview
Given the head of a linked list, remove the nth node from the end of the list and return the head of the modified list.

## Solution Approach: Sentinel Node with Two Pointers

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers (Anchor and Result) with Dummy Node

## Core Concept
A dummy/sentinel node is placed before the head to elegantly handle the edge case where the head itself needs to be removed. Two pointers (anchor and result) maintain a gap of n+1 nodes. The anchor pointer is moved n+1 steps ahead, then both pointers advance together until the anchor reaches the end. At this point, the result pointer is just before the node to remove, allowing us to skip it by updating the next reference.

## Why This Works
By creating a sentinel node pointing to the head, we ensure there's always a node before any potential removal target. The gap of n+1 nodes between the two pointers guarantees that when the anchor reaches the end, the result pointer is positioned at the node just before the target. This works regardless of whether we're removing the head or a middle node, eliminating the need for special case handling.

## Important Insights
- **Sentinel node handles head removal:** Without the dummy node, removing the head would require special logic. With it, the logic is uniform for all positions.
- **Two pointer gap technique:** The gap of exactly n+1 nodes is crucial. It positions the result pointer one step before the target node for easy removal.
- **Single pass solution:** Despite only traversing the list once after the setup, we effectively determine which node is nth from the end. The algorithm is efficient and clean.
- **Null safety:** The anchor pointer is guaranteed to reach null, terminating the while loop cleanly. The result pointer will always be positioned before the target node.

## Key Technique: Dummy Node and Two Pointer Gap
This pattern is invaluable for linked list operations, especially when the head might be affected. It applies to problems like removing specific nodes, finding the middle of a list, or rearranging linked lists. Using a dummy node removes edge case complexity and makes the logic more uniform and easier to understand. The two-pointer gap technique is useful whenever you need to position one pointer at a specific distance relative to another.

## Edge Cases to Remember
- **Remove the head:** If n equals the list length, the head is removed. The sentinel node ensures this works correctly without special handling.
- **Single node list:** If the list has only one node and n=1, it should be removed, returning null. The sentinel node and standard logic handle this.
- **Large n values:** n is guaranteed to be valid (1 ≤ n ≤ length), so overflow or out-of-bounds isn't a concern.
- **Small gaps:** Even with small lists (2-3 nodes), the algorithm correctly positions the result pointer and removes the intended node.
