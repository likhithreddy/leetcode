# Problem 206: Reverse Linked List

## Problem Overview
Reverse a singly linked list, changing the direction of all pointers so that the last node becomes the head and the head becomes the tail.

## Solution Approach: Iterative Reversal with Three Pointers

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Pointer Manipulation During Iteration

## Core Concept
Maintain three pointers: prev (initially null), curr (initially head), and next (temporary storage). While traversing the list: (1) save the next node before modifying pointers, (2) reverse the link by pointing curr.next to prev, (3) move prev and curr forward one step. This reverses each link as you progress through the list.

## Why This Works
Each node needs to point backward instead of forward. By maintaining three pointers, you can safely reverse the current link (curr.next = prev) without losing the reference to the rest of the list (saved in next). Moving prev and curr forward ensures you process every node exactly once. The final result is that every node points to its previous node in the original list.

## Important Insights
- **The `next` pointer is critical:** Save the next node before reversing the current link, otherwise you lose the reference
- **Order of operations:** Save next → reverse link → advance pointers
- **Final null pointer:** The original head's next pointer ends up null (correct for the new tail)
- **New head:** The last node in the original list becomes the new head (returned at the end)
- **Why not recursive?** Recursive approach is elegant but uses O(n) stack space; iterative is more space-efficient
- **Immutability:** Original head pointer becomes the tail; update must return the new head

## Key Technique: Pointer Reversal for List Traversal Problems
When modifying pointer directions during traversal, always save the next reference before changing pointers. This pattern applies to: reversing lists, reordering lists, and any problem requiring pointer redirection during iteration.

## Edge Cases to Remember
- **Single node:** Returns the same node (already reversed)
- **Empty list (null head):** Returns null
- **Two nodes:** First becomes last, second becomes first
- **Properly null-terminated:** Tail's next becomes null; don't lose this
- **Already reversed (linked list pointing backward):** Double reversal returns to original
