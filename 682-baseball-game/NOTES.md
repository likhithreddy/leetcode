# Problem 682: Baseball Game

## Problem Overview
Simulate a baseball game where a record of operations is given: a number represents a score, "+" means the last two scores are added, "D" means the last score is doubled, and "C" means the last record is cancelled. Return the sum of all scores.

## Solution Approaches Comparison

### Approach 1: Array-Based Simulation (Brute Force)
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Key Idea:** Pre-allocate an array of length equal to the operations array. Iterate through each operation, storing calculated scores at index positions. For "C" operations, invalidate the previous entry by setting it to 0 and decrementing the index counter. After processing all operations, sum all non-zero values in the array to get the total score.

**Why it's brute force:** This approach wastes space by allocating an array as large as the operations list, but many operations like "+" and "D" don't create new scores—they modify existing ones. This leads to sparse usage of the allocated array, with wasted slots that never hold useful data. Additionally, manually tracking an index and handling cancellations by zeroing values is more verbose and less elegant than using a stack's natural pop operation.

### Approach 2: Stack-Based Simulation (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(n) but only stores actual scores

**Key Idea:** Use a stack to store scores. For each operation: if it's a number, push it; if "+", pop the last score, peek at the second-to-last, sum them, and push the result; if "D", push double the top value; if "C", pop the top (cancel). Finally, sum all remaining values in the stack for the total score.

**Why it's optimal:** Stack naturally models the problem's semantics—"C" becomes a simple pop operation, "+" requires accessing only the top two elements without artificial indexing, and "D" only needs to peek. The space used is minimal—exactly the number of valid scores, no wasted slots. The code is cleaner, more intuitive, and leverages the data structure's properties for elegant solutions.

## Key Differences at a Glance
| Aspect | Array | Stack |
|--------|-------|-------|
| Allocation | Pre-allocates array of size n | Grows dynamically, stores only valid scores |
| Cancellation ("C") | Sets previous value to 0, decrements index | Pop from stack (natural operation) |
| Space Usage | Wasteful—array may have many zero slots | Efficient—only actual scores stored |
| Access Pattern | Index-based with manual tracking | LIFO with push/pop |
| Code Clarity | More verbose, index management | Concise, leverages stack semantics |
| Scalability | Fixed size limits flexibility | Adapts to number of valid scores |

## When to Use Which
- **Array:** When you need to preserve the full history of scores (including cancelled ones) for reference or debugging; rarely preferred for this problem
- **Stack:** When you only care about the current valid scores and want clean, efficient code; preferred for this problem and similar sequence-with-undo problems

## Important Pattern/Insight
**"Stack for Undo Operations"** — When a problem involves operations that can cancel/undo previous actions, a stack is the natural choice. The stack's LIFO property makes cancellation O(1) and conceptually clear. This pattern extends to any problem with undo/cancel mechanics: editor history, function call stacks, expression evaluation, etc. Whenever you need to "revert to the previous state," think stack first.

## Edge Cases to Remember
- **No operations:** Empty input returns 0 (both approaches handle correctly)
- **Only scores, no operations:** Stack simply pushes all values; array stores them all; both return their sum
- **Multiple consecutive cancellations:** Stack pops multiple times; array needs careful index management (array approach more error-prone)
- **Alternating operations:** Stack and array both handle correctly, but stack code remains cleaner
- **Single operation:** Array wastes n-1 slots; stack uses exactly 1 slot
