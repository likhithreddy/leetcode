# Problem 200: Number of Islands

## Problem Overview
Given an m x n 2D grid of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

## Solution Approach: Depth-First Search (DFS)

**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

**Technique:** Depth-First Search (DFS), Graph Traversal

## Core Concept
The algorithm iterates through each cell in the grid. When it encounters a '1' (land), it increments the island counter and then uses DFS to mark all connected '1's as '0' to prevent counting them again. The DFS explores in all four directions (up, down, left, right) from each land cell, effectively identifying all cells belonging to the same island as a single connected component.

## Why This Works
The key insight is that each island is a connected component in a graph where cells are nodes and adjacent land cells are edges. By marking visited cells as water ('0'), we ensure that each island is counted exactly once. The DFS exhaustively explores all connected land cells from a starting point, capturing the entire island in one traversal.

## Important Insights
- **Connected Component Identification:** This is a classic connected components problem. Each island is one connected component, and we need to count how many such components exist.
- **In-Place Modification:** By modifying the grid in-place (marking visited land as water), we avoid needing a separate visited data structure, thus saving space.
- **Direction Exploration:** The DFS explores four directions (down, up, right, left) systematically. The order doesn't matter—all connected cells will eventually be visited.
- **Base Case:** The DFS returns immediately if the cell is out of bounds or contains water ('0'), which naturally terminates the recursion.

## Key Technique: Graph Traversal via DFS
DFS is a fundamental graph traversal technique where you explore as far as possible along each branch before backtracking. It's particularly useful for identifying connected components in graphs. This pattern applies to problems like counting provinces, detecting cycles, and finding paths. When you need to explore all cells connected to a starting point in a grid, DFS is often the go-to technique.

## Edge Cases to Remember
- **Empty grid:** If the grid is empty or has no land ('1'), the count remains 0.
- **All water:** A grid with only '0's should return 0.
- **Single cell island:** A grid with a single '1' should return 1.
- **Boundary cells:** Islands touching the grid boundaries are counted correctly because the DFS stops at boundaries (row < 0 or row >= rows, etc.).
