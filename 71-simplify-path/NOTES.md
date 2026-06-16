# Problem 71: Simplify Path

## Problem Overview
Given an absolute Unix-style path string, return its simplified canonical form: a single leading slash, no trailing slash, no `.` (current directory), `..` collapsed by removing the previous directory, and no consecutive slashes.

## Solution Approach: Stack of Directory Names

**Time Complexity:** O(n) — one split pass plus one rebuild pass over the path  
**Space Complexity:** O(n) — the stack holds the surviving directory names

**Technique:** Stack (LIFO)

## Core Concept
Split the path on `/` to get raw tokens, then process each token against a stack: push real directory names, ignore `.` and empty tokens (from `//` or leading/trailing slashes), and pop on `..` to back out of the most recent directory. The stack ends holding exactly the directories of the canonical path in order, which are then joined with `/` separators.

## Why This Works
A canonical path is just the net sequence of directories you end up in after walking the input left to right. The stack mirrors a real directory traversal — entering a folder pushes, `..` exits the last folder (pops), and `.`/empty tokens are no-ops. Because `..` only ever cancels the immediately preceding directory, LIFO order is exactly the semantics required, and guarding the pop with `!stack.isEmpty()` correctly makes `..` at root a no-op.

## Important Insights
- **`split("/")` yields empty tokens:** Leading slashes and `//` produce `""` entries, so empty strings must be filtered alongside `.`.
- **Guarded pop prevents underflow:** `..` is only acted on when the stack is non-empty; at the root it is silently dropped, matching `/../ → /`.
- **`insert(0, ...)` rebuilds in order:** Popping gives directories in reverse, so prepending each with its `/` reconstructs the forward path; appending instead would reverse it.
- **Empty stack means root:** If nothing survives, the result is `"/"` rather than an empty string — handled by the final length check.

## Key Technique: Stack for Path/Nesting Resolution
Any problem where elements can cancel their most recent predecessor — directory `..`, undo operations, backspaces in a string (`#`), or matching brackets — maps naturally to a stack. The pattern: scan tokens, push state, and pop when you encounter a "go back" signal. Recognize it whenever the effect of an element depends only on the most recently seen unresolved element.

## Edge Cases to Remember
- **Trailing slash / consecutive slashes:** `"/home//foo/"` splits into empty tokens that are ignored, yielding `/home/foo`.
- **`..` at or above root:** `"/../"` finds an empty stack, the pop is skipped, and the result is `"/"`.
- **Only `.` or slashes:** `"/./"` produces no pushes, so the final length check returns `"/"`.
- **Multi-dot directory names:** `"..."` (three dots) is a valid directory name, not a special token, so it is pushed normally.
