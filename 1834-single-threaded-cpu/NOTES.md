# Problem 1834: Single-Threaded CPU

## Problem Overview
Given tasks with an enqueue time and processing time, return the order in which a single-threaded CPU executes them. When multiple tasks are available, the CPU picks the task with the smallest processing time, breaking ties by smaller original index.

## Solution Approach: Sort + Min-Heap

**Time Complexity:** O(n log n)
**Space Complexity:** O(n)

**Technique:** Sorting + Priority Queue

## Core Concept
First sort all tasks by enqueue time so we can process them in chronological order. As time advances, push every task whose enqueue time is now available into a min-heap ordered by processing time and then by index. If the heap is empty, jump time forward to the next task's enqueue time; otherwise, pop the best available task, append its index to the answer, and advance time by its processing duration.

## Why This Works
The CPU only ever needs to choose among tasks that have already arrived, so a heap perfectly models the eligible set. Sorting by enqueue time guarantees each task is considered once, and the heap ensures the next scheduled task always matches the problem's priority rules. Jumping time forward when no task is available preserves correctness while avoiding wasted idle simulation.

## Important Insights
- **Sort by arrival time first:** This lets us add tasks exactly when they become eligible.
- **Min-heap by `(processingTime, index)`:** This encodes the tie-breaking rules directly.
- **Time jumps are allowed:** If nothing is ready, moving to the next enqueue time is equivalent to idling.
- **Each task enters and leaves the heap once:** That gives the `O(n log n)` bound.

## Key Technique: Event-Driven Simulation
This problem is a classic event-driven simulation: do not step through every time unit, only react when something changes. That pattern is useful whenever inputs arrive over time and selection depends on a priority rule among currently available items.

## Edge Cases to Remember
- **No task available at current time:** Advance time to the next enqueue time instead of looping on idle ticks.
- **Multiple tasks arrive together:** Push all of them before selecting the next job.
- **Equal processing times:** Use the original index as the second heap key.
- **Large gaps between tasks:** Time jumps keep the solution efficient.
