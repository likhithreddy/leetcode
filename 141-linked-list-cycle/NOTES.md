# Problem 141: Linked List Cycle

## Problem Overview
Given the head of a linked list, determine if the linked list has a cycle in it. A cycle exists if a node can be reached again by following the next pointers.

## Solution Approach: Floyd's Cycle Detection (Tortoise and Hare)

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Two Pointers (Slow and Fast)

## Core Concept
The algorithm uses two pointers moving at different speeds: a slow pointer that advances one node at a time and a fast pointer that advances two nodes at a time. If there's a cycle, these pointers will eventually meet. If there's no cycle, the fast pointer will reach the end of the list. This works because in a cycle, the fast pointer will eventually "lap" the slow pointer, proving a cycle exists.

## Why This Works
When there's a cycle, both pointers will eventually enter it. Since the fast pointer moves twice as fast as the slow pointer, it will gradually close the gap and eventually catch up to the slow pointer. The gap decreases by 1 node with each iteration, guaranteeing they will meet. If there's no cycle, the fast pointer reaches null and we can return false immediately.

## Important Insights
- **No extra space needed:** Unlike using a HashSet to track visited nodes, this approach uses only two pointers regardless of the list size.
- **Detection is guaranteed:** In a cycle, the relative speed difference ensures the pointers will meet within the cycle before they could possibly exit it.
- **Null checks matter:** The condition checks for `fast != null && fast.next != null` to prevent null pointer exceptions when advancing the fast pointer by two nodes.
- **Phase 1 only:** This solution detects if a cycle exists; to find the cycle's start node would require a second phase with repositioning one pointer to the head.

## Key Technique: Two Pointer/Slow-Fast Pattern
This pattern is useful for any problem involving cycles or specific positions in linked lists. It's also applicable to finding the middle of a list, removing the nth node from the end, or detecting palindromes in linked lists. Whenever you need to detect a cycle or position yourself at a specific point in a singly linked list, consider the slow-fast pointer approach because it provides O(1) space complexity instead of O(n).

## Edge Cases to Remember
- **Single node with self-loop:** A node pointing to itself is a cycle. The algorithm correctly detects this on the first iteration.
- **Empty list or single node:** If head is null or there's only one node without a cycle, the condition `fast.next != null` prevents errors and returns false.
- **Cycle at the end:** The cycle doesn't have to involve the first node. The algorithm detects cycles anywhere in the list.
- **Large cycle:** Even if the cycle is very large, the algorithm will find the meeting point within O(n) time because the gap between pointers closes by 1 each iteration.
