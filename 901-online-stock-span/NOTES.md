# Problem 901: Online Stock Span

## Problem Overview
Design a `StockSpanner` whose `next(price)` returns the stock's "span": the number of consecutive days, ending today and counting backward, on which the price was less than or equal to today's price. Prices arrive one at a time (online/streaming).

## Solution Approach: Monotonic Stack of (price, span) Pairs

**Time Complexity:** `next` amortized O(1) — each price is pushed once and popped at most once  
**Space Complexity:** O(n) — worst case (strictly decreasing prices) the stack holds every day

**Technique:** Monotonic Stack (decreasing), with collapsed span counts

## Core Concept
Maintain a stack of `[price, span]` pairs that is decreasing in price from bottom to top. For each new price, start with `span = 1` (today itself), then pop every stacked day whose price is `<= price`, adding its precomputed span to the running total. Each popped entry already aggregates the days it dominated, so absorbing its span folds in a whole run of smaller prices in one step. Push the new `[price, span]` and return `span`.

## Why This Works
Days with a price `<= today` can never be the answer for any future day before today is — today's larger-or-equal price "shadows" them — so they can be safely discarded once counted. Storing each entry's span lets a single pop account for all the days it had previously swallowed, so the backward run is summed without re-scanning. The stack stays monotonically decreasing, which guarantees the popping stops exactly at the first earlier day with a strictly greater price (the span boundary).

## Important Insights
- **Store the span, not just the price:** Each pair carries its own span so one pop contributes an entire collapsed run, not a single day — this is what makes it amortized O(1).
- **`<=` comparison handles equal prices:** Equal prior prices are included in the span, so they must be popped (not left on the stack).
- **Monotonic decreasing invariant:** After pushing, prices strictly decrease downward; the next greater price always remains as the stop point.
- **Amortized analysis:** A single `next` can pop many entries, but every element is pushed and popped at most once overall, so total work across `n` calls is O(n).

## Key Technique: Monotonic Stack with Aggregated Counts
This is the "previous greater element" pattern (mirror of Daily Temperatures / Next Greater Element), specialized for streaming by collapsing consumed runs into a stored count instead of indices. Use a monotonic stack whenever you need, for each element, the span/distance to the nearest earlier or later element that breaks a monotonic condition. Carrying an aggregate (span, count, sum) on each entry generalizes it to "how many consecutive elements satisfy the condition."

## Edge Cases to Remember
- **First call:** Stack is empty, the loop is skipped, span is 1, and the pair is pushed.
- **Strictly increasing prices:** Each `next` pops everything below it, producing spans 1, 2, 3, … and leaving one combined entry.
- **Strictly decreasing prices:** Nothing is ever popped; every span is 1 and the stack grows to size n.
- **Equal consecutive prices:** Each equal-or-smaller prior day is absorbed via `<=`, so spans accumulate correctly across plateaus.
