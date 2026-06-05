# Problem 133: Clone Graph

## Problem Overview
Given a reference to a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a value and a list of its neighbors. The graph is represented using an adjacency list where each node has a value (val) and a list of neighbors.

## Solution Approach: DFS with HashMap Memoization

**Time Complexity:** O(N + E) where N is the number of nodes and E is the number of edges  
**Space Complexity:** O(N) for the HashMap and recursive call stack

**Technique:** Depth-First Search (DFS), HashMap, Graph Traversal, Memoization

## Core Concept
The solution uses a recursive DFS approach with a HashMap to store already created cloned nodes. When visiting a node for the first time, we create a cloned copy and add it to the HashMap using the node's value as the key. For each neighbor, we recursively clone it if it hasn't been cloned yet, then add the cloned neighbor to the current cloned node's neighbors list. The HashMap acts as a memoization structure to prevent infinite loops in cycles and avoid cloning the same node multiple times.

## Why This Works
This approach correctly handles graph cycles because the HashMap stores references to already-created cloned nodes. When we encounter a node that's already in the HashMap, we simply reuse the existing cloned version instead of creating a duplicate or entering infinite recursion. The DFS traversal ensures we visit all reachable nodes from the starting node, and the recursive nature naturally handles the graph's structure regardless of complexity.

## Important Insights
- **HashMap prevents cycles:** By storing cloned nodes as we create them, we can reference already-cloned nodes when encountering them again, preventing infinite loops in cyclic graphs.
- **Deep copy structure:** The solution creates entirely new Node objects with new ArrayList instances for neighbors, ensuring a true deep copy where modifications to the clone don't affect the original.
- **Check before creation:** Using `hm.containsKey(neighbor.val)` prevents redundant cloning and immediately reuses existing cloned nodes for already-visited neighbors.
- **Null handling:** The base case `if (node == null) return null` handles disconnected components and ensures the function works with null input.

## Key Technique: Graph Cloning with DFS
This problem demonstrates the essential pattern for deep copying graph structures. The key insight is combining DFS traversal with a HashMap to track visited/cloned nodes. This pattern is fundamental for any problem requiring graph copying, transformation, or analysis while preserving the original structure. It also teaches how to handle cycles in graphs—a critical consideration in graph algorithms.

## Edge Cases to Remember
- **Null input:** If the input node is null, return null immediately. The solution handles this with the initial check.
- **Single node with no neighbors:** A node with an empty neighbor list should clone correctly with an empty neighbor list as well.
- **Cyclic references:** If node A points to B and B points back to A, the HashMap ensures we don't create infinite recursion by reusing the cloned node.
- **Self-loops:** If a node points to itself, the HashMap memoization prevents creating duplicate self-references in the cloned graph.
