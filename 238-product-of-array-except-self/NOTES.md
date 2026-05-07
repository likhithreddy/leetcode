# Problem 238: Product of Array Except Self

## Problem Overview
Given an array, return a new array where each position contains the product of all elements except the element at that position. You must solve this in O(n) time and preferably without using division.

## Solution Approach: Prefix and Suffix Products

**Time Complexity:** O(n)  
**Space Complexity:** O(n) for output array

**Technique:** Pre-computed Product Boundaries

## Core Concept
Create an output array. First pass: compute prefix products (product of all elements before index i). Store in output array. Second pass: compute suffix products (product of all elements after index i) while multiplying with the prefix product already in the array. For each position, result = prefix product × suffix product.

## Why This Works
The product of all elements except position i equals (product of all before i) × (product of all after i). By pre-computing these products in two passes, you can compute the answer for each position in O(1) time after preprocessing. Avoiding division sidesteps edge cases (like zeros) and is mathematically cleaner.

## Important Insights
- **Two-pass approach:** First pass builds left context; second pass builds right context while combining
- **No division:** Avoids handling division by zero, negative numbers, and zero products
- **Space optimization:** Could use output array itself to store intermediate products
- **Zero handling:** This approach handles zeros naturally (product involving 0 is 0)
- **Boundary cases:** First element has no prefix (product = 1); last element has no suffix (product = 1)
- **Why not naive?** Naive approach would be O(n²) checking all other elements; prefix/suffix is O(n) with preprocessing

## Key Technique: Boundary Products for Position-Based Calculations
When each position's result depends on products/sums of surrounding elements, pre-compute boundary extremes (left prefix, right suffix). This pattern applies to: product except self, trapping rain water, largest rectangle, and other position-dependent calculations.

## Edge Cases to Remember
- **Array with single element:** Output is [1] (no other elements, "product of nothing" is 1)
- **Array with exactly two elements:** Output is [arr[1], arr[0]] (swap)
- **Single zero:** All positions become 0 except where the zero is (product is that element)
- **Multiple zeros:** All output is 0 (product of anything including 0 is 0)
- **All ones:** All output is 1
