# Problem 853: Car Fleet

## Problem Overview
At the destination, you are driving a car through a highway with other cars at different starting positions and speeds. Determine how many car fleets arrive at the destination (a fleet forms when a faster car behind catches up to a slower car ahead).

## Solution Approach: Stack-Based Greedy with Sorting

**Time Complexity:** O(n log n)  
**Space Complexity:** O(n)

**Technique:** Stack, Sorting, Greedy Algorithm

## Core Concept
The key insight is that cars form fleets based on time to reach the destination, not by their starting position or speed individually. By sorting cars in descending order by position and calculating the time each car takes to reach the target, we can use a stack to track distinct fleets. A car only forms a new fleet if its time to reach the destination is greater than the car ahead of it; otherwise, it catches up and joins that fleet.

## Why This Works
When cars are sorted from right to left (closest to destination first), we can process them in order. If the current car takes more time to reach the destination than the car ahead, it will never catch up and forms a new fleet. If it takes less time or equal time, it will catch up and merge into the existing fleet. Using a stack efficiently tracks only the distinct fleets, eliminating cars that get absorbed.

## Important Insights
- **Sorting by position (descending):** Processing from the rightmost car ensures we check catching-up conditions in the correct order
- **Time-to-destination metric:** The critical metric is time, not speed or position alone. Cars with the same time form fleets
- **Stack stores times:** The stack stores times of fleet leaders. Each element represents a car that starts a new fleet
- **Greedy selection:** Once we identify a fleet leader (a car with more time), all slower cars behind it will form this fleet

## Key Technique: Stack-Based Greedy Filtering
This pattern is useful for problems where you need to identify groups of elements that satisfy a monotonic property. When processing in a specific order (here, right-to-left by position), you can use a stack to keep only the "significant" elements—those that represent group starts or peaks. This technique appears in problems like Daily Temperatures, Largest Rectangle in Histogram, and Trapping Rain Water.

## Edge Cases to Remember
- **Single car:** One car always reaches destination without forming a fleet with others
- **All cars with same speed:** Each car starts at a different position, so they maintain their relative order; each forms its own fleet
- **All cars at the same position:** They all start together and the fastest one reaches first; only the fastest forms the fleet
- **Car already at target:** A car starting at the target position has zero time to destination; should not form a fleet if its time is less than or equal to previous cars
