# Problem 695: Max Area of Island

## Problem Overview
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's connected horizontally or vertically (but not diagonally). Find the maximum area of an island in the given 2D array.

## Solution Approach: Depth-First Search (DFS)

**Time Complexity:** O(m × n) where m is the number of rows and n is the number of columns  
**Space Complexity:** O(m × n) in the worst case due to the recursion stack (for a grid completely filled with 1's)

**Technique:** Depth-First Search (DFS), Graph Traversal

## Core Concept
The algorithm iterates through each cell in the grid. When it encounters a '1' (land), it uses DFS to explore all connected land cells and count them as the area. During the DFS exploration, visited cells are marked as '0' (water) to prevent recounting. The algorithm maintains a running maximum to track the largest island area found. Each DFS call returns the count of cells in that island, and we compare all island areas to find the maximum.

## Why This Works
The key insight is that each island is a connected component, and the area of an island is simply the count of all cells in that component. By using DFS to explore every connected cell starting from each unvisited land cell and summing up the cell count, we calculate the area of each island. Since we mark visited cells as water, each island is counted exactly once. Tracking the maximum area during exploration gives us the answer.

## Important Insights
- **Connected Component Counting:** This problem extends the "Number of Islands" concept by also counting the size of each island. Instead of just incrementing a counter, we sum the cell counts.
- **Cell Marking:** By modifying grid cells in-place (marking land as water after visiting), we avoid needing a separate visited data structure, keeping space complexity manageable.
- **Recursive Return Value:** The DFS function returns the area contribution, making it elegant to accumulate the total area of an island through recursive addition.
- **Directional Exploration:** The DFS explores in four directions systematically. The order of exploration doesn't affect the final count—we'll visit all connected cells regardless.

## Key Technique: DFS for Connected Component Area Calculation
This technique extends basic graph traversal to not just identify components but also calculate their properties (in this case, size/area). This pattern is useful for problems involving finding properties of connected components, such as their sum, maximum value, or other aggregated metrics. Whenever you need to calculate something about connected components in a grid, consider using DFS with an accumulator return value.

## Edge Cases to Remember
- **Empty grid:** A grid with no land (all 0's) should return 0.
- **Single cell island:** A grid with a single '1' should return 1.
- **Entire grid is one island:** If all cells are '1', the area is m × n.
- **Boundary cells:** Islands touching the grid boundaries are counted correctly because the DFS stops at boundaries (row < 0 or row >= rows, etc.).
- **Disconnected islands:** Multiple separate islands are each counted individually, and the function returns the maximum area.
