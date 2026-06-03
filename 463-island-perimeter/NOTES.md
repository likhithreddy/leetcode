# Problem 463: Island Perimeter

## Problem Overview
Given a grid with land (1) and water (0), calculate the perimeter of the island. The island is formed by connecting adjacent lands horizontally or vertically (not diagonally).

## Solution Approach: Counting Edges

**Time Complexity:** O(m × n) where m and n are the grid dimensions  
**Space Complexity:** O(1)

**Technique:** Counting/Enumeration

## Core Concept
For each land cell in the grid, we count it as having 4 edges initially. Then, we subtract 2 edges for every adjacent land cell (one from each cell). This efficiently calculates the perimeter without needing to check boundaries or traverse the island structure.

## Why This Works
Each cell with land contributes 4 edges to the perimeter. When two land cells are adjacent, they share an edge, so we subtract 2 (one from each cell's count). By iterating through the grid once and checking only left and top neighbors, we avoid double-counting shared edges while correctly accounting for all perimeter edges.

## Important Insights
- **Single pass solution:** Only one iteration through the grid is needed, making it very efficient
- **Shared edge subtraction:** For each adjacent pair, subtract 2 (one from each cell's contribution)
- **Only check two directions:** Only checking left and top neighbors prevents double-counting, as we process cells left-to-right, top-to-bottom
- **No boundary checks needed:** We don't need to check right or bottom neighbors because cells already account for their contributed edges

## Key Technique: Edge Counting
This pattern applies to similar grid problems where you need to count properties based on cell relationships. Instead of traversing the island, we enumerate all cells and use mathematical relationships (like edge sharing) to derive the answer. This approach is useful when you need aggregate properties like perimeter, total boundary length, or internal connections.

## Edge Cases to Remember
- **Single cell island:** A 1×1 grid with one land cell should return perimeter of 4
- **Disconnected islands:** Multiple disconnected islands are counted separately; the algorithm sums all perimeter edges
- **Island touching grid edges:** Cells on the grid boundary contribute their outer edges to the perimeter naturally
- **No islands:** An all-water grid returns 0, as no cells have value 1
