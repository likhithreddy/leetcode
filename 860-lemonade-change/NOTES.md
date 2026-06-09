# Problem 860: Lemonade Change

## Problem Overview
At a lemonade stand, each customer buys a lemonade for $5. Customers pay with $5, $10, or $20 bills. You must give the correct change and determine if it's possible to serve all customers without running out of bills.

## Solution Approach: Greedy Count Tracking

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Greedy Algorithm with Counter

## Core Concept
Track the count of $5 and $10 bills available. For each customer, use a greedy strategy to make change: when giving change for a $20 bill, prefer using one $10 and one $5 (if available) over three $5s. This preserves $5 bills since they're the most flexible for future transactions.

## Why This Works
The greedy approach is optimal because $5 bills are the bottleneck—they're needed for all types of change. By prioritizing the use of $10s when available (for $20 bills), we preserve the scarcer $5 bills for situations where they're the only option. This single pass through all customers with constant space proves sufficient to determine if all transactions can be completed.

## Important Insights
- **Greedy Preference Order:** When making change for $20, prefer (1×$10 + 1×$5) over (3×$5) to conserve $5 bills for future flexibility
- **$5 Bills Are Critical:** $5 bills are needed for every transaction that requires change, making them the most valuable inventory
- **Early Termination:** Return false immediately when unable to make change, avoiding unnecessary computation
- **One-Pass Solution:** Single iteration through transactions is sufficient; no need to revisit or reorder customers

## Key Technique: Greedy Change-Making
The pattern of prioritizing one type of currency over another based on scarcity applies broadly to currency exchange and resource allocation problems. When multiple solutions exist, choosing the option that preserves scarcer resources often leads to optimal outcomes. This principle extends to inventory management, scheduling problems, and situations where you must make locally optimal choices with limited resources.

## Edge Cases to Remember
- **All $5 Bills:** Customer pays exact amount; no change needed, just increment counter
- **First Customer Pays with $10 or $20:** Will fail immediately since no $5 bills available for change
- **Alternating Large Bills:** If pattern alternates between $10 and $20, the algorithm must carefully reserve $5s accordingly
- **Trailing $20s with Few $5s:** Running out of $5s late in the sequence should be caught and return false
