# Problem 169: Majority Element

## Problem Overview
Find the element that appears more than ⌊n/2⌋ times in an unsorted array of n integers. The majority element is guaranteed to exist.

## Solution Approaches Comparison

### Approach 1: Hash Map (Brute Force)
**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Key Idea:** Iterate through the array and use a HashMap to count the frequency of each element. As soon as any element's count exceeds n/2, return it. This approach trades space efficiency for simplicity and clarity.

**Why it's brute force:** While it has optimal time complexity, it uses extra O(n) space to store element counts. This is not the most space-efficient solution since we don't need to store all frequencies; we only need to find one element that appears more than n/2 times.

### Approach 2: Boyer-Moore Voting Algorithm (Optimal)
**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Key Idea:** Maintain a candidate and a count. As you iterate through the array, if the count is 0, set a new candidate. If the current number matches the candidate, increment the count; otherwise, decrement it. The candidate remaining after the loop is the majority element. This works because the majority element appears more than n/2 times, so it will "survive" the cancellation process.

**Why it's optimal:** This approach achieves O(1) space complexity while maintaining O(n) time complexity. It leverages the mathematical property that the majority element (appearing > n/2 times) will always win in a voting scheme where each appearance votes for itself and each non-majority element votes against it.

### Approach 3: Sorting (Alternative)
**Time Complexity:** O(n log n)  
**Space Complexity:** O(1) or O(n) depending on sorting algorithm

**Key Idea:** Sort the array and return the element at index n/2. Since the majority element appears more than n/2 times, it must occupy the middle position in a sorted array.

**Why it works:** If an element appears more than n/2 times in an array of size n, it occupies more than half the positions. When sorted, these positions will inevitably include the middle position at index n/2.

## Key Differences at a Glance
| Aspect | Hash Map | Boyer-Moore | Sorting |
|--------|----------|-------------|---------|
| **Time Complexity** | O(n) | O(n) | O(n log n) |
| **Space Complexity** | O(n) | O(1) | O(1) or O(n) |
| **Approach Type** | Counting | Voting/Cancellation | Array Manipulation |
| **When to Use** | Simple, readable solution | When space is critical | When simplicity is preferred |

## When to Use Which
- **Hash Map:** When you need a straightforward solution and moderate space usage is acceptable. Good for interviews to show understanding of hash maps.
- **Boyer-Moore:** When you need optimal space complexity and want to impress with knowledge of clever algorithms. Critical in space-constrained environments.
- **Sorting:** When you want the simplest conceptual solution. Works well if the array needs to be sorted anyway for other operations.

## Important Pattern/Insight
**"Majority Element and Voting Algorithms"** — The Boyer-Moore Voting Algorithm is a brilliant example of how mathematical properties can lead to elegant solutions. The key insight is that a majority element (appearing > n/2 times) will always "outlast" all other elements in a voting scheme. This pattern applies to finding the majority element in streaming data and can be extended to finding elements appearing more than n/3 or n/k times by maintaining multiple candidates and counters.

## Edge Cases to Remember
- **Single Element Array:** All three approaches correctly return the only element.
- **All Same Elements:** The majority element is the array itself; all approaches handle this trivially.
- **Exactly n/2 + 1 Occurrences:** The minimum case where an element is still a majority; Boyer-Moore handles this correctly since the algorithm doesn't require a strict majority, just > n/2.
- **Negative Numbers:** Hash Map and Sorting handle them naturally. Boyer-Moore is indifferent to negative numbers since it only compares equality and counts.
