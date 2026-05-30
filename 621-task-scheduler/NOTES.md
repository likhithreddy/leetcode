# Problem 621: Task Scheduler

## Problem Overview
Given an array of CPU `tasks` (each a letter `A`-`Z`) and a cooldown `n`, return the least number of time units the CPU needs to finish all tasks where the same task must be separated by at least `n` idle (or other-task) intervals. Each unit either runs one task or idles.

## Solution Approaches Comparison

### Approach 1: Max-Heap + Cooldown Queue Simulation (Brute Force)
**Time Complexity:** O(T · log k) where T is total tasks and k is the number of distinct tasks (≤ 26)  
**Space Complexity:** O(k)

**Key Idea:** Count each task's frequency, push all `(task, count)` pairs into a max-heap keyed by remaining count, and simulate time tick by tick. At each tick, pop the most-frequent ready task, decrement its count, and if still positive park it in a cooldown queue with a release-time stamp of `time + n`. Whenever the queue's front becomes ready (its stamp equals current time), move it back into the heap. The loop ends when both structures empty and the elapsed time is returned.

**Why it's brute force:** It literally simulates every time unit, including idle slots, and pays a heap log-factor per tick. For huge `n` with few tasks, the simulation marches through every idle interval one at a time even though the answer is fully determined by the most frequent task's count. The extra data structures (heap + queue + frequency map) add constant overhead and obscure the underlying combinatorial structure.

### Approach 2: Frequency Math Formula (Optimal)
**Time Complexity:** O(T) — single pass to count, constant-size 26-bucket scan  
**Space Complexity:** O(1) — fixed `int[26]` regardless of input size

**Key Idea:** Let `maxFreq` be the highest task frequency and `maxCount` the number of tasks tied at that frequency. The schedule must contain `maxFreq - 1` full "frames" of length `n + 1` (each frame holds one of the most-frequent tasks plus `n` cooldown slots), followed by a final group of `maxCount` tasks that all share the peak frequency. The answer is `(maxFreq - 1) * (n + 1) + maxCount`, but if the task array is already so dense that no idling is needed (many distinct tasks, small `n`), the formula could underestimate — so we take `max(tasks.length, formula)` to cover that case.

**Why it's optimal:** A single pass counts frequencies and a constant-size loop finds the max; no simulation, no logarithmic heap operations, no cooldown bookkeeping. The formula leverages the structural fact that the most-frequent task dictates the lower bound on schedule length, and any "leftover" tasks always fit into the gaps without extending it. The `max(tasks.length, ...)` guard handles the dense regime in O(1) instead of an extra pass.

## Key Differences at a Glance
| Aspect | Heap Simulation | Frequency Formula |
|--------|----------------|-------------------|
| **Approach** | Tick-by-tick simulation with priority queue and cooldown FIFO | Closed-form math from frequency counts |
| **Time Complexity** | O(T · log k) — log factor per time tick | O(T) — single linear pass |
| **Space Complexity** | O(k) — heap + queue + map | O(1) — fixed 26-bucket array |
| **Dependency on `n`** | Simulation cost grows with idle stretches | Independent of how big `n` is at runtime |

## When to Use Which
- **Heap Simulation:** When you need the actual *schedule* (which task runs at each tick), or when the cooldown rule is per-task-different and a single formula no longer applies — the simulator stays correct under richer constraints.
- **Frequency Formula:** When you only need the total time (the typical interview/production answer), or whenever `n` could be very large — the formula sidesteps the per-tick cost entirely.

## Important Pattern/Insight
**"Bound by the Most Frequent Element"** — When a scheduling problem forbids repeating the same item within a window, the schedule length is governed by the most frequent item: it forces `(maxFreq - 1)` complete frames of size `window + 1`, with ties at the top adding one slot each to the final partial frame. Recognizing this collapses what looks like a simulation problem into arithmetic. The same pattern shows up in Rearrange String K Distance Apart, Reorganize String, and any "fill gaps around the heaviest token" problem; always check whether the densest element alone determines the lower bound and whether `max(length, formula)` is needed for the dense regime.

## Edge Cases to Remember
- **`n = 0` (no cooldown):** Formula gives `(maxFreq - 1) * 1 + maxCount`, which equals `tasks.length` exactly; the `max` guard ensures correctness. Simulation never parks tasks in the queue and runs straight through.
- **All tasks identical (e.g., `["A","A","A"]`, `n = 2`):** `maxFreq = 3`, `maxCount = 1`, formula gives `(3-1)*(2+1) + 1 = 7` (A _ _ A _ _ A). Simulation idles correctly between As.
- **Many distinct tasks, small `n` (dense regime):** Formula's `(maxFreq - 1) * (n + 1) + maxCount` can be smaller than `tasks.length`; the `max(tasks.length, ...)` returns the true total. Simulation handles this implicitly by never idling.
- **Multiple tasks tied at max frequency:** `maxCount > 1`, so the final partial frame contains all the tied tasks back-to-back — formula adds exactly `maxCount` to the answer, while simulation pops them in arbitrary heap order but ends at the same total.
