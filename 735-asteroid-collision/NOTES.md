# Problem 735: Asteroid Collision

## Problem Overview
Given an array of asteroids where each value's sign is its direction (positive = right, negative = left) and its magnitude is its size, simulate all collisions and return the state of the asteroids that survive.

## Solution Approach: Stack of Surviving Asteroids

**Time Complexity:** O(n) — each asteroid is pushed and popped at most once  
**Space Complexity:** O(n) — the stack holds surviving asteroids (all of them in the no-collision case)

**Technique:** Stack (LIFO)

## Core Concept
A collision can only happen when a left-moving asteroid (`< 0`) meets a right-moving one (`> 0`) already on the stack. Right-movers and a left-mover following another left-mover never collide, so they are pushed directly. For an incoming left-mover, repeatedly pop the smaller right-movers it destroys; if it meets an equal-size right-mover both are destroyed; it only survives (pushed) if the stack is empty or the top is another left-mover.

## Why This Works
The stack top always represents the nearest asteroid that could collide with the incoming one. Only a positive top followed by a negative incoming asteroid produces a collision, since both are moving toward each other. The `while` loop resolves a chain of collisions in one pass — the surviving left-mover keeps eating right-movers until it dies, ties, or is stopped — which exactly models the physics of sequential pairwise collisions.

## Important Insights
- **Collision condition is direction-specific:** Only `top > 0` and `incoming < 0` collide; same-direction or diverging pairs (`+` then `+`, `-` then `-`, `-` then `+`) never meet.
- **`asteroid + stack.peek()` decides the winner:** Negative sum means the left-mover is bigger (pop the right-mover and continue); zero means equal sizes (both destroyed); positive means the right-mover wins (left-mover dies, nothing pushed).
- **Three-way outcome after the loop:** Exit the `while`, then either the top equals it in size (pop, both gone) or the left-mover survives against an empty stack / another left-mover (push).
- **Each asteroid touched O(1) amortized:** A popped asteroid never returns, keeping the total work linear despite the nested loop.

## Key Technique: Stack for Adjacent Pairwise Elimination
When elements interact only with their nearest unresolved neighbor and can eliminate each other (asteroids, removing adjacent duplicates, string crushing/cancellation), a stack lets you resolve a cascade in one pass. The pattern: push by default, and on a "conflicting" element, pop while the conflict resolves in its favor. Reach for it whenever the survival of an element depends on a running chain of comparisons with what came just before.

## Edge Cases to Remember
- **All same direction:** Every asteroid is pushed with no collisions (e.g., all positive or all negative).
- **Equal-size head-on collision:** `5, -5` sums to 0, so both are popped and neither survives.
- **Left-mover at the start / empty stack:** A negative asteroid with an empty stack is pushed directly since nothing can hit it.
- **Chain reaction:** One large left-mover (e.g., `-10`) can destroy several stacked right-movers in succession within the `while` loop.
