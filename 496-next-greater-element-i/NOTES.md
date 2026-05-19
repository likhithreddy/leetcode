# Problem 496: Next Greater Element I

## Problem Overview
Given two arrays nums1 and nums2, find for each element in nums1 the next greater element in nums2. The next greater element of x in nums2 is the first element to the right of x that is greater than x. If no such element exists, return -1.

## Solution Approach: Monotonic Stack with Hash Map

**Time Complexity:** O(n + m) where n = length of nums2, m = length of nums1  
**Space Complexity:** O(n)

**Technique:** Monotonic Stack, Hash Map

## Core Concept
Process nums2 from right to left, maintaining a stack of elements in decreasing order. For each element, pop all smaller elements from the stack (since they will never be the next greater element for this number). The remaining top of the stack is the next greater element, which we store in a HashMap. Then push the current element onto the stack. Finally, use the HashMap to build the result for nums1.

## Why This Works
By processing nums2 from right to left and maintaining a decreasing stack, we ensure that when we pop an element, we've found a greater element to its right. The stack contains candidates for "next greater" elements in decreasing order. When we encounter a larger element, smaller elements are no longer candidates for any future elements (they're already popped), so we get O(n) time complexity without redundant comparisons.

## Important Insights
- **Decreasing stack order:** Maintaining elements in decreasing order allows us to identify the next greater element efficiently. Any element that breaks this property becomes the answer for all smaller popped elements.
- **Right-to-left traversal:** Processing nums2 backwards ensures we always have future elements on the stack when looking for the next greater element.
- **HashMap for O(1) lookup:** After precomputing next greater elements for all of nums2, we can answer queries for nums1 elements in constant time per lookup.
- **Each element processed once:** Every element is pushed and popped from the stack exactly once, guaranteeing linear time complexity regardless of array sizes.

## Key Technique: Monotonic Stack Pattern
The monotonic stack pattern is fundamental for "next greater/smaller element" problems. It works by maintaining a data structure that respects a monotonic property (increasing or decreasing). When an element violates this property, it reveals the answer for the elements that are popped. This pattern efficiently solves problems that would otherwise require nested loops. Applicable to: Next Greater Element, Daily Temperatures, Trapping Rain Water, Largest Rectangle in Histogram, and Stock Span Problem.

## Edge Cases to Remember
- **Empty nums1 or nums2:** Return empty result or handle gracefully; the algorithm still works.
- **No greater element exists:** Elements get paired with -1 in the HashMap, correctly returned in results.
- **All elements in nums2 are increasing:** Stack becomes empty quickly; later elements find their answers among already-processed elements.
- **All elements in nums2 are decreasing:** Stack grows large but processes correctly; last element returns -1 as it has no greater element.
