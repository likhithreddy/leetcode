# Problem 21: Merge Two Sorted Lists

## Problem Overview
Merge two sorted singly linked lists into a single sorted linked list. The merged list should be made by splicing together the nodes of the two lists.

## Solution Approaches Comparison

### Approach 1: Two-Pointer Iterative (Optimal)
**Time Complexity:** O(n + m)  
**Space Complexity:** O(1)

**Key Idea:** Iterate through both lists simultaneously using two pointers, comparing values at each step and appending the smaller node to the result. Start by determining which list's head is smaller, then iterate through both lists while both have remaining nodes. Once one list is exhausted, append the remaining nodes from the other list to complete the merge.

**Why it's optimal:** This approach uses constant extra space (only a few pointers) and processes each node exactly once. It directly builds the merged list by rearranging node pointers without creating new nodes or using additional data structures, making it the most efficient solution.

### Approach 2: Recursive
**Time Complexity:** O(n + m)  
**Space Complexity:** O(n + m)

**Key Idea:** Recursively compare the heads of both lists and choose the smaller one as the next node in the merged list. Recursively call the function with the remaining nodes (either list1.next or list2.next along with the unchanged other list). Base cases handle when either list becomes null by returning the remaining list.

**Why it's suboptimal:** While the time complexity is the same as the iterative approach, the recursive solution uses O(n + m) space on the call stack for the recursive calls. This additional space overhead makes it less efficient than the iterative two-pointer approach for large lists.

## Key Differences at a Glance
| Aspect | Iterative | Recursive |
|--------|-----------|-----------|
| **Space Complexity** | O(1) | O(n + m) |
| **Call Stack** | No recursive calls | Uses call stack |
| **Code Readability** | More explicit control flow | More elegant and concise |
| **Memory Usage** | Minimal | Higher due to recursion |

## When to Use Which
- **Iterative:** When memory is a concern or working with very large lists. This is the preferred solution for production code.
- **Recursive:** When code elegance and readability are prioritized over memory efficiency, or when demonstrating recursive problem-solving techniques.

## Important Pattern/Insight
**"Two-Pointer Linked List Merging"** — When merging two sorted sequences, especially linked lists, the two-pointer technique is fundamental. By maintaining pointers to the current position in each list and iteratively selecting the smaller element, you preserve the sorted order while building the result. This pattern generalizes to merging sorted arrays, combining multiple sorted streams, and appears in merge sort implementations. Master this pattern as it's foundational for more complex problems like merging k sorted lists.

## Edge Cases to Remember
- **Both lists null:** Return null (handled by checking if list1 == null first)
- **One list null:** Return the non-null list directly without modification
- **Single node lists:** Correctly merge two single-node lists by comparing values
- **Lists of different lengths:** Properly attach the remaining nodes from the longer list after exhausting the shorter one
