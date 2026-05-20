# Problem 155: Min Stack

## Problem Overview
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

## Solution Approach: Dual Stack

**Time Complexity:** O(1) for all operations  
**Space Complexity:** O(n)

**Technique:** Stack

## Core Concept
We maintain two stacks in parallel: one for all values and one that tracks only the minimum values seen so far. When pushing, we add the value to the main stack and conditionally add it to the minStack if it's less than or equal to the current minimum. This allows us to retrieve the minimum in O(1) time by simply peeking at the minStack.

## Why This Works
By keeping a separate stack of minimum values, we eliminate the need to search through the entire stack to find the minimum. Each pop operation is matched with a corresponding minStack pop (when applicable), maintaining the invariant that the top of minStack always contains the minimum value in the main stack.

## Important Insights
- **Dual Stack Pattern:** Using a parallel stack to track metadata (like minimums) is a powerful technique for problems requiring constant-time queries on stack data.
- **Equal Elements:** We push to minStack when `val <= minStack.peek()` (not just `<`). This ensures we pop correctly when the minimum element appears multiple times.
- **Comparison Logic:** When popping, we check if the popped element equals the current minimum before popping from minStack. This handles duplicates correctly.
- **Space-Time Tradeoff:** We trade extra O(n) space to achieve O(1) time complexity for getMin(), which is the optimal solution.

## Key Technique: Parallel Stack Pattern
The dual stack pattern is useful whenever you need to track auxiliary information (like minimums, maximums, or other metadata) alongside your main data structure. This pattern can be applied to problems like tracking the maximum in a stack, balancing parentheses with different types, or maintaining frequency counts. When you need constant-time access to aggregate information, consider maintaining a parallel data structure.

## Edge Cases to Remember
- **Single Element:** When pushing the first element, both stacks should be updated.
- **Duplicate Minimums:** Using `<=` instead of `<` ensures we handle cases where the minimum value appears multiple times.
- **Pop Operations:** Only pop from minStack if the popped element equals the current minimum, preventing synchronization issues.
- **Empty Stack Checks:** The problem guarantees valid operations (pop/top/getMin only called on non-empty stack), but in real scenarios, check for empty conditions.
