# Problem 994: Rotting Oranges

## Problem Overview
Given a grid of fresh oranges, rotten oranges, and empty cells, determine the minimum number of minutes needed until every fresh orange becomes rotten. Rotten oranges spread rot to adjacent fresh oranges in four directions each minute.

## Solution Approach: Multi-Source BFS

**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

**Technique:** Breadth-First Search (Queue-Based), Multi-Source BFS

## Core Concept
Treat every initially rotten orange as a starting point and place all of them into a queue before the simulation begins. Process the queue level by level, where each level represents one minute, and rot any adjacent fresh oranges that are reachable from the current frontier. As new oranges become rotten, add them to the queue so they can spread rot in the next minute.

## Why This Works
This is a shortest-time spread problem, so the first time a fresh orange becomes rotten is guaranteed to be the earliest possible minute. Multi-source BFS naturally models simultaneous expansion from all rotten oranges at once, which matches the problem statement better than running separate searches from each orange. By processing the queue one layer at a time, each layer cleanly corresponds to one minute of elapsed time.

## Important Insights
- **All rotten oranges start together:** Seeding the queue with every rotten orange ensures the spread happens simultaneously from every source.
- **Level order equals time:** Each BFS layer represents one minute, so counting layers gives the answer directly.
- **Mark oranges when enqueued:** Changing a fresh orange to rotten as soon as it is added to the queue prevents duplicate processing.
- **Track remaining fresh oranges:** This provides an easy early exit and makes it clear when the answer should be -1.

## Key Technique: Multi-Source BFS
Multi-source BFS is useful when multiple starting points expand outward at the same rate and you care about the earliest arrival time. It appears in problems like rotting spread, nearest source, and infection-style propagation. The pattern is to seed the queue with all sources first, then expand outward in synchronized layers.

## Edge Cases to Remember
- **No fresh oranges:** Return 0 immediately because nothing needs to rot.
- **Fresh oranges isolated by empty cells:** Some fresh oranges can never be reached, so the answer is -1.
- **No initially rotten oranges:** Fresh oranges cannot start rotting, so any fresh orange remaining makes the answer -1.
- **Single row or column:** The BFS still works because all four-direction checks naturally collapse to valid neighbors only.