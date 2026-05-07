# NOTES Template Guide

This folder contains markdown templates for creating comprehensive NOTES.md files for LeetCode problems. Use these templates as your reference structure when adding notes for new problems.

## Templates Available

### 1. TEMPLATE_SINGLE_SOLUTION.md
Use this template for problems that have only **one solution** or when you want to document a single primary approach.

**When to use:**
- Problem has one standard/optimal approach
- Problem is straightforward with no multiple approaches
- You want to document a single technique thoroughly

**Sections included:**
- Problem Overview
- Solution Approach
- Core Concept
- Why This Works
- Important Insights (bullet points)
- Key Technique (with generalization to other problems)
- Edge Cases to Remember

---

### 2. TEMPLATE_MULTIPLE_SOLUTIONS.md
Use this template for problems that have **two or more distinct solutions**, where you want to compare brute force vs. optimal approaches.

**When to use:**
- Problem has multiple solution approaches
- You want to highlight the difference between brute force and optimal
- You want to show why one is better than the other
- You want to document trade-offs between approaches

**Sections included:**
- Problem Overview
- Solution Approaches Comparison (for each approach: Time/Space Complexity, Key Idea, Why brute force/optimal)
- Key Differences at a Glance (comparison table)
- When to Use Which (use cases for each approach)
- Important Pattern/Insight (generalizable pattern)
- Edge Cases to Remember

---

## How to Use These Templates

1. **Copy the appropriate template** based on whether you have one or multiple solutions
2. **Replace placeholders** marked with `[...]` with actual content
3. **Follow the tone and style** demonstrated in existing NOTES.md files in the workspace
4. **Be concise but detailed**: Include intricate details without being overly elaborative
5. **Focus on "why" not "what"**: Explain reasoning, not implementation details
6. **Generalize patterns**: Show how the technique applies to other similar problems

---

## Key Principles for Writing Notes

### Content Guidelines
- **Problem Overview**: 1-2 sentences, clear and specific
- **Key Idea**: 2-3 sentences with intricate technical details
- **Why it works**: Explain the reasoning/correctness proof
- **Important Insights**: 3-4 bullet points covering critical details
- **Pattern/Insight**: How this generalizes to other problems; when to apply it
- **Edge Cases**: 3-4 realistic edge cases with brief handling notes

### Tone
- **Conversational yet professional**: As if explaining to someone reviewing later
- **Technical but accessible**: Assume knowledge of basics, explain advanced concepts
- **Pattern-centric**: Emphasize techniques and patterns, not code
- **Revision-friendly**: Quick scannable, clear headers, organized flow

### What NOT to Do
- ❌ Don't reproduce code
- ❌ Don't write lengthy prose; be concise
- ❌ Don't focus on "what" without explaining "why"
- ❌ Don't miss edge cases
- ❌ Don't forget to explain time/space complexity

---

## Example Structure Summary

For a **single solution**, expect roughly:
- 2-3 sentences for Problem Overview
- 2-3 sentences for Core Concept
- 2-3 sentences for Why This Works
- 4 bullet points for Important Insights
- 2-3 sentences for Key Technique
- 3-4 bullet points for Edge Cases

For **multiple solutions**, expect roughly:
- 2-3 sentences for Problem Overview
- For each approach: 2-3 Key Idea sentences + 2-3 Why explanation sentences
- Comparison table with 4 rows
- 2-3 sentences for When to Use Which
- 3-4 sentences for Pattern/Insight
- 3-4 bullet points for Edge Cases

---

## Quick Reference: Common Patterns

When you encounter these patterns, here's what to include:

| Pattern | Where to Emphasize | Key Insight |
|---------|-------------------|------------|
| **Hash Map** | O(1) lookup advantage | Trading space for instant access |
| **Two Pointers** | Movement strategy | Why moving one pointer vs. the other makes progress |
| **Sliding Window** | Window validity condition | How window maintains the required property |
| **Stack** | LIFO nature | Why stack naturally matches problem structure |
| **DFS/Recursion** | Recursive structure | How problem decomposes into subproblems |
| **Bit Manipulation** | Bit properties used | What bitwise operation solves the problem |
| **Dynamic Programming** | State definition | How subproblems combine into the solution |
| **Sorting + Technique** | Why sorting helps | What property does sorting enable |

---

## File Organization

Place NOTES.md in each problem's folder:

```
leetcode/
├── 1-two-sum/
│   ├── TwoSum.java
│   └── NOTES.md
├── 3-longest-substring-without-repeating-characters/
│   ├── LongestSubstring...Map.java
│   ├── LongestSubstring...Set.java
│   └── NOTES.md
└── _templates/
    ├── TEMPLATE_SINGLE_SOLUTION.md
    ├── TEMPLATE_MULTIPLE_SOLUTIONS.md
    └── README.md (this file)
```

---

## Tips for Future Note-Taking

1. **Write notes immediately after solving** while the problem is fresh
2. **Compare approaches before writing** to understand trade-offs
3. **Test edge cases mentally** while documenting them
4. **Link patterns to other problems** you've solved (e.g., "Similar to Problem X")
5. **Review notes regularly** during revision to reinforce patterns
6. **Update notes** if you discover new insights or approaches

Good luck with your LeetCode journey!
