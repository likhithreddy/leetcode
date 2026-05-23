# Problem 138: Copy List with Random Pointer

## Problem Overview
Create a deep copy of a linked list where each node has two pointers: a next pointer to the next node and a random pointer that can point to any node (or null) in the list. The copied list should be independent with new node objects and the same structure and pointer relationships as the original.

## Solution Approach: Hash Map Two-Pass

**Time Complexity:** O(n) where n is the number of nodes  
**Space Complexity:** O(n) for the hash map storing node mappings

**Technique:** Hash Map, Linked List Traversal

## Core Concept
The solution uses a two-pass approach with a hash map: in the first pass, iterate through the original list and create new nodes for each original node, storing the mapping from original to cloned nodes in the hash map. In the second pass, iterate again and use the hash map to set the next and random pointers of each cloned node by looking up the corresponding cloned nodes from the original references.

## Why This Works
The hash map preserves the mapping relationship between original and cloned nodes, allowing us to correctly reconstruct pointer relationships even though the cloned nodes are new objects. The two-pass approach ensures all nodes are created before we attempt to set pointers, avoiding issues with forward references. This guarantees that when we set a pointer (whether next or random), the target node already exists in our hash map.

## Important Insights
- **Node Mapping Persistence:** The hash map serves as a translation layer, converting references from the original list to the cloned list, ensuring all pointer relationships are preserved correctly.
- **Two-Pass Strategy:** Separating node creation from pointer assignment is essential because we need all nodes to exist before we can properly set random pointers that might point forward in the list.
- **Deep Copy Requirement:** Creating new Node objects instead of reusing original nodes ensures independence between the original and cloned lists, so modifications to one don't affect the other.
- **Null Handling:** The hash map naturally returns null for null pointers (e.g., when random points to null or next is null at the end), making edge cases simple to handle.

## Key Technique: Hash Map-Based Traversal and Reconstruction
This pattern is useful for problems involving deep copying of complex data structures with cross-references (graphs, linked lists with multiple pointer types). By maintaining a mapping from original to cloned objects, you can reconstruct arbitrary reference patterns while traversing the structure. This generalizes well to problems like cloning n-ary trees or creating copies of graphs with custom edge types.

## Edge Cases to Remember
- **Null Head:** If the input list is empty (head is null), return null immediately without attempting any traversal.
- **Single Node:** A list with only one node should copy correctly regardless of whether its random pointer points to itself or null.
- **Self-Referencing Random:** When a node's random pointer points to itself, the cloned node's random pointer should point to its own cloned version.
- **Circular Random Pointers:** Random pointers can form cycles, but since all nodes are created in the first pass before any pointer assignment, cycles are handled correctly.
