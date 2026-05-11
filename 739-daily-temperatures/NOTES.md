# Problem 739: Daily Temperatures

## Problem Overview
Given an array of daily temperatures, return an array where for each day, the value indicates how many days you have to wait until a warmer temperature is observed. If there's no future day with a warmer temperature, the value should be 0.

## Solution Approaches Comparison

### Approach 1: Brute Force (Nested Loop)
**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

**Key Idea:** For each temperature in the array, iterate through all subsequent temperatures until you find one that's warmer. Record the difference in indices. If no warmer day is found, the result is 0. This simple approach works but rechecks many temperatures multiple times.

**Why it's brute force:** The nested loop structure processes each temperature multiple times. For each element, you scan through potentially many future elements, resulting in quadratic time complexity. Many redundant comparisons occur, especially when temperatures are mostly in ascending or descending order.

### Approach 2: Monotonic Stack (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Key Idea:** Use a stack to store indices of temperatures in decreasing order. As you iterate through the array, when you find a temperature warmer than the top of the stack, you've found the next warmer day for that element. Pop elements from the stack and record the difference (current index minus the popped index). Continue until the stack is empty or the current temperature is not warmer, then push the current index onto the stack.

**Why it's optimal:** Each element is pushed onto and popped from the stack exactly once, resulting in linear time complexity. The monotonic stack elegantly avoids redundant comparisons by maintaining a decreasing sequence of temperatures. When a warmer temperature is found, all colder temperatures "know" their answer immediately without rescanning.

## Key Differences at a Glance
| Aspect | Brute Force | Monotonic Stack |
|--------|------------|-----------------|
| **Time Complexity** | O(n²) | O(n) |
| **Space Complexity** | O(1) | O(n) |
| **Redundant Comparisons** | Many | None |
| **Scalability** | Poor for large inputs | Excellent for large inputs |

## When to Use Which
- **Brute Force:** Only for small arrays or educational purposes to understand the problem. Not suitable for production code with large datasets.
- **Monotonic Stack:** Always preferred for this problem. Efficient, scalable, and demonstrates the monotonic stack pattern which appears in many problems.

## Important Pattern/Insight
**"Monotonic Stack"** — This pattern is crucial for problems involving finding the next greater/smaller element. A monotonic stack maintains elements in a specific order (increasing or decreasing) and allows you to efficiently find answers for all elements in a single pass. When you encounter an element that breaks the monotonic property, you've found your answer for the popped elements. This pattern generalizes to problems like Next Greater Element, Trapping Rain Water, and Stock Span Problem. Recognize when problems ask for "next", "nearest", or "closest" comparisons and consider monotonic stack.

## Edge Cases to Remember
- **Strictly decreasing array:** All results are 0 since no warmer day exists for any element
- **Strictly increasing array:** Each element's answer is 1 (the very next day is warmer)
- **All same temperatures:** All results are 0 since no day is warmer
- **Single element:** Return array with single 0 (no future days exist)
