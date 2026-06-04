# Problem 997: Find the Town Judge

## Problem Overview
In a town of n people, find the town judge who is trusted by everyone else but does not trust anyone. The judge is the only person who meets these criteria, given an array of trust relationships as [a, b] meaning person a trusts person b.

## Solution Approaches Comparison

### Approach 1: 2D Matrix Counting (Brute Force)
**Time Complexity:** O(n² + m) where m is the length of trust array  
**Space Complexity:** O(n²)

**Key Idea:** Build a 2D trust matrix where matrix[a][b] = 1 means person a trusts person b. Then iterate through each person and check if they are trusted by n-1 people and trust no one. For each column, count the number of 1s (incoming trust); if it equals n-1, verify that the person has no outgoing trust (all 0s in their row).

**Why it's brute force:** This approach wastes space by storing the complete relationship matrix even though you only need to count incoming and outgoing trust. It also performs redundant nested loops to verify each candidate, making it inefficient for large n and sparse trust relationships.

### Approach 2: In-Degree and Out-Degree Counting (Optimal)
**Time Complexity:** O(m + n) where m is the length of trust array  
**Space Complexity:** O(n)

**Key Idea:** Use two arrays: inDegree tracks how many people trust each person, and outDegree tracks how many people each person trusts. Iterate through the trust array once to populate these counts. Then find the person with inDegree[i] == n-1 and outDegree[i] == 0.

**Why it's optimal:** By using only two 1D arrays instead of a 2D matrix, space is reduced from O(n²) to O(n). The algorithm makes only two passes through the data (one for counting, one for finding the judge), avoiding the nested loops of the brute force approach.

## Key Differences at a Glance
| Aspect | Brute Force | Optimal |
|--------|------------|---------|
| Data Structure | 2D Matrix (n × n) | Two 1D Arrays (n each) |
| Space Complexity | O(n²) | O(n) |
| Time Complexity | O(n² + m) | O(m + n) |
| Finding Judge | Double loop checking rows and columns | Single loop checking conditions |
| Scalability | Poor for large n | Excellent for any n |

## When to Use Which
- **Brute Force:** Small problem sizes (n ≤ 100) where simplicity is preferred over efficiency; situations where you want an explicit matrix representation of relationships
- **Optimal:** Production code or competitive programming where n can be large; memory-constrained environments; when performance is critical

## Important Pattern/Insight
**"In-Degree and Out-Degree Analysis"** — Many graph and relationship problems can be solved by analyzing node properties (how many connections point to/from each node) rather than explicitly storing all relationships. This pattern appears in problems involving trust networks, course prerequisites, social networks, and directed graph analysis. When you need to find nodes with specific connection properties (like a judge or source/sink node), counting degrees is more efficient than building the full graph structure. This reduces both space and time complexity significantly.

## Edge Cases to Remember
- **Single person (n=1):** The only person is the judge if there are no trust relationships; both approaches correctly return 1
- **No valid judge:** If no one satisfies the judge criteria, return -1; both approaches handle this in their final return statement
- **Complete trust:** Everyone trusts one person and no one else; this person has inDegree of n-1 and outDegree of 0, correctly identified by both approaches
- **Self-loops or invalid input:** The optimal approach naturally handles this; any self-trust would increment both in and out degree, disqualifying that person from being judge
