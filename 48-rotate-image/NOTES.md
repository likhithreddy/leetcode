# Problem 48: Rotate Image

## Problem Overview
Given an `n x n` 2D matrix representing an image, rotate the image by 90 degrees clockwise in place. The rotation must modify the input matrix directly without allocating another 2D matrix.

## Solution Approach: Transpose + Reverse Rows

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

**Technique:** In-Place Matrix Manipulation (Transpose followed by Row Reversal)

## Core Concept
A 90° clockwise rotation can be decomposed into two simpler in-place operations: first transpose the matrix (swap `matrix[row][col]` with `matrix[col][row]` for all `col > row`), then reverse each row. Transposing flips the matrix across its main diagonal, mapping element `(r, c)` to `(c, r)`; reversing each row then sends `(c, r)` to `(c, n - 1 - r)`, which is exactly where the original `(r, c)` belongs after a clockwise rotation. Both passes touch only existing cells with constant extra storage, satisfying the in-place requirement.

## Why This Works
The clockwise-90 rotation has a closed-form coordinate mapping: `(r, c) -> (c, n - 1 - r)`. This composite map factors cleanly as `(r, c) -> (c, r)` (transpose) followed by `(c, r) -> (c, n - 1 - r)` (reverse-within-row), so two well-known O(n²) primitives compose into the desired rotation. Restricting the transpose loop to `col > row` ensures each off-diagonal pair is swapped exactly once — swapping twice would undo the operation — and row reversal swaps only the first half against the second, also exactly once per pair.

## Important Insights
- **Two-step decomposition beats direct 4-cycle rotation:** Rotating four corners at once `(r,c) -> (c,n-1-r) -> (n-1-r,n-1-c) -> (n-1-c,r) -> (r,c)` works but requires careful index bookkeeping over `n/2` rings; transpose + reverse is dramatically simpler with identical asymptotic cost
- **Transpose bound `col > row`, not `col >= row`:** Diagonal cells stay fixed (`matrix[r][r]` swaps with itself), and starting at `col = row + 1` prevents the swap from running twice and re-undoing itself
- **Row reversal bound `col < n / 2`:** Each row has only `n/2` pairs to swap; an integer divide naturally skips the middle element when `n` is odd (it's already in place)
- **Rotation variants reuse the same primitives:** All four orientations (90° CW, 90° CCW, 180°) decompose into transpose + reverse in different orders — see the "Rotation Variants" section below

## Rotation Variants: Transpose + Reverse Recipes
All matrix rotations factor as compositions of two in-place primitives — **transpose** (swap across the main diagonal) and **reverse** (rows or columns). The order and choice determine the angle:

| Rotation | Recipe | Coordinate Map |
|----------|--------|----------------|
| **90° Clockwise** | Transpose, then reverse each **row** | `(r, c) -> (c, n - 1 - r)` |
| **90° Counter-Clockwise** | Transpose, then reverse each **column** (equivalently: reverse each row first, then transpose) | `(r, c) -> (n - 1 - c, r)` |
| **180°** | Reverse each row, then reverse the order of rows (equivalently: reverse rows then reverse each row — both orders work) | `(r, c) -> (n - 1 - r, n - 1 - c)` |
| **270° Clockwise** | Same as 90° Counter-Clockwise | `(r, c) -> (n - 1 - c, r)` |

**Why these compositions work:** Transpose alone maps `(r, c) -> (c, r)`. Following it by a row-reverse adds `(c, r) -> (c, n - 1 - r)` → that's 90° CW. Following it by a column-reverse adds `(c, r) -> (n - 1 - c, r)` → that's 90° CCW. For 180°, no transpose is needed — just flip both axes by reversing along each. Memorize transpose as the "diagonal flip" primitive and the rest follows from which axis you flip afterward.

**Code sketches (each is O(n²) time, O(1) space):**
- *90° CCW row-reverse-then-transpose alternative:* reverse each row first (`matrix[r][c] ↔ matrix[r][n-1-c]` for `c < n/2`), then transpose (`matrix[r][c] ↔ matrix[c][r]` for `c > r`)
- *180° two-row-reverse alternative:* reverse the row order with two-pointer swaps (`matrix[r] ↔ matrix[n-1-r]` for `r < n/2`), then reverse each row in place

## Key Technique: Decompose Geometric Transforms into Primitives
When a coordinate transformation looks intimidating, factor it into a composition of simpler well-known primitives (transpose, reverse, flip) and apply them sequentially in place. This is the standard pattern for any matrix rotation, reflection, or shear question and generalizes to image-processing pipelines where complex affine transforms are implemented as a chain of basic operations. The trick is recognizing the algebraic factorization of the coordinate map.

## Edge Cases to Remember
- **1×1 matrix (`n = 1`):** Both inner loops have empty ranges (`col > 0` and `col < 0` never trigger), so the matrix is returned unchanged — correct, since a 1×1 rotation is identity
- **2×2 matrix:** Transpose swaps `(0,1)` with `(1,0)`; row reversal swaps the two columns in each row — produces the correct rotation in 1 + 2 = 3 swaps total
- **Odd `n`:** Middle row stays put during row-reversal at `col = n/2`; middle column also untouched during transpose at the diagonal — both handled implicitly by the loop bounds
- **All elements identical:** Algorithm still runs all O(n²) swaps but the matrix is visibly unchanged — no early-exit optimization, but also no correctness concern
