# Problem 232: Implement Queue using Stacks

## Problem Overview
Design a FIFO queue supporting `push`, `pop`, `peek`, and `empty`, using only standard stack operations (push, pop, peek/top, size, isEmpty) as the underlying primitives.

## Solution Approach: Two Stacks with Reversal on Read

**Time Complexity:** `push` O(1); `pop`/`peek` O(n) — every element is moved across and back on each read  
**Space Complexity:** O(n) — `stackOne` holds the elements; `stackTwo` is a temporary buffer during reads

**Technique:** Stack (using a second stack to reverse LIFO into FIFO order)

## Core Concept
A single stack returns elements in LIFO order, the opposite of a queue's FIFO. The trick is that pouring one stack into another reverses it, putting the oldest element on top. Here `push` simply adds to `stackOne`. For `pop`/`peek`, all elements are transferred to `stackTwo` (reversing them so the front of the queue is on top), the top is read/removed, and then everything is poured back into `stackOne` to preserve insertion order for future pushes.

## Why This Works
Reversing a LIFO sequence yields FIFO order: the first element pushed sinks to the bottom of `stackOne`, so after transfer it ends up on top of `stackTwo` — exactly the queue's front. Moving the remaining elements back restores `stackOne`'s original ordering, so the invariant "`stackOne` holds elements bottom-to-top in insertion order" is maintained across every operation. `empty()` is correct because all elements live in `stackOne` between operations.

## Important Insights
- **Reversal is the whole idea:** Transferring stack A into stack B flips the order, converting LIFO access into FIFO access.
- **This variant transfers back every read:** Unlike the amortized two-stack design, `pop`/`peek` here pour elements back into `stackOne`, so each read is O(n) rather than amortized O(1).
- **`push` stays O(1):** Insertion only touches `stackOne`; the reordering cost is deferred to reads.
- **`empty()` checks `stackOne` only:** Because elements always return to `stackOne` after a read, a single stack's emptiness reflects the whole queue.

## Key Technique: Reverse a Stack via a Second Stack
Two stacks emulate a queue because reversing LIFO twice (or once, then reading) recovers FIFO order. The more efficient variant keeps an "input" stack and an "output" stack and only transfers when the output stack is empty, giving amortized O(1) per operation — each element moves across exactly once. Recognize this whenever you must build one ADT's ordering from another's opposite ordering.

## Edge Cases to Remember
- **Pop/peek on empty queue:** Per the problem's constraints these are only called on a non-empty queue; otherwise `stackTwo.pop()` would fail.
- **Single element:** Transfer, read, and transfer-back all operate on one item and behave correctly.
- **Interleaved push/pop:** Because elements are restored to `stackOne` after each read, a push following a pop still lands in correct insertion order.
- **Peek does not consume:** `peek` reads the front but pushes the element back, leaving the queue unchanged (only the temporary transfer differs from `pop`).
