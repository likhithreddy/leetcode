# Problem 202: Happy Number

## Problem Overview
A number is "happy" if repeatedly replacing it with the sum of the squares of its digits eventually reaches `1`. If the process instead loops indefinitely without reaching `1`, the number is unhappy. Return `true` if `n` is happy, `false` otherwise.

## Solution Approach: Hash Set Cycle Detection

**Time Complexity:** O(log n) per transformation × number of iterations until termination — in practice O(log n) overall because the sequence quickly drops into a bounded region (values ≤ 243 for any 3-digit input) and cycles are short  
**Space Complexity:** O(log n) for the visited set in the worst case

**Technique:** Hash Set for Cycle Detection in an Implicit Functional Graph

## Core Concept
Each number defines a deterministic "next" value via the sum-of-squares-of-digits function, so the iteration traces a path in a functional graph where every node has exactly one outgoing edge. A happy number's path terminates at the fixed point `1`; an unhappy number's path enters a cycle that doesn't include `1`. By storing every value seen in a hash set and checking `set.add(n)` on each step, we detect re-visits in O(1): if we re-encounter any value before hitting `1`, we're in a non-1 cycle and the number is unhappy.

## Why This Works
The digit-square sum is bounded — for any number with d digits, the result is at most `81 * d`, so after a couple of iterations every input collapses into the range `[1, 243]` and stays there. In a finite state space with a deterministic transition function, the sequence must either reach `1` (the absorbing state) or revisit some earlier value (entering a cycle); there's no third option. So either `1` is reached, or a duplicate appears — both cases are detectable in finite steps, guaranteeing termination.

## Important Insights
- **Bounded state space guarantees termination:** Any starting `n` is shrunk to at most 3 digits within a few iterations, and 243 possible states means the loop *must* halt — either by reaching `1` or repeating
- **Functional graph perspective:** This is cycle detection on the orbit of a function `f(n) = sum_of_digit_squares(n)`; the hash set is the brute-force version of Floyd's tortoise-and-hare
- **`set.add(n)` doubles as check and insert:** `HashSet.add` returns `false` if the element was already present, so a single call performs both the "have I seen this?" lookup and the "remember it" insertion
- **Floyd's algorithm alternative (O(1) space):** Run two pointers, slow stepping once and fast stepping twice per iteration; if they meet at any value other than `1`, the number is unhappy — same correctness, no extra memory

## Key Technique: Cycle Detection in a Functional Iteration
Whenever a problem repeatedly applies a deterministic function to a value (digit transforms, Collatz-style sequences, linked-list `next` pointers), the orbit either reaches a target or cycles, and you need to distinguish those outcomes. The hash-set approach is the easiest to write and debug; Floyd's two-pointer variant is the space-optimal upgrade. This pattern generalizes to Linked List Cycle (problem 141), Find the Duplicate Number (problem 287), and any problem that secretly asks "does this iterated process terminate?"

## Edge Cases to Remember
- **`n = 1`:** Loop condition `n != 1` fails immediately; returns `true` without inserting anything into the set
- **`n = 0` (out of typical constraints, but worth noting):** Sum-of-squares of `0` is `0`, creating an immediate fixed-point cycle at `0` → would loop forever without the set check; the set catches it on the second visit and returns `false`
- **Known unhappy cycle (e.g., starting at `4`):** The sequence `4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4` revisits `4`, triggering the duplicate-detection branch
- **Large `n` (up to `2^31 - 1`):** Even a 10-digit number drops below 1000 within two steps because `81 * 10 = 810`; correctness and performance are unaffected by the initial magnitude
