# Problem 122: Best Time to Buy and Sell Stock II

## Problem Overview
Given an array of integers representing stock prices for each day, find the maximum profit by buying and selling the stock multiple times. You must sell before buying again.

## Solution Approach: Greedy Peak-to-Valley

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Greedy Algorithm

## Core Concept
Instead of manually finding every peak-valley pair, observe that the sum of all small consecutive gains equals the overall profit from buying at valleys and selling at peaks. Simply iterate through the array and whenever the next day's price is higher than today's, add that difference to the total profit. This greedy approach captures all profitable transactions in a single pass.

## Why This Works
The mathematical insight is that profit from buying at price A and selling at price C equals (B - A) + (C - B), where B is any intermediate price. Therefore, summing all positive price differences gives the maximum profit. This greedy strategy works because there's no penalty for making multiple transactions—we can capitalize on every upward price movement without any cost.

## Important Insights
- **Decomposition of profits:** Any multi-step profit can be decomposed into consecutive single-step profits
- **No transaction limits:** Unlike problem 121 (single transaction), we can make unlimited transactions
- **Cooldown doesn't apply:** We can buy and sell on consecutive days with no restrictions
- **Non-negative gains only:** Negative differences (losses) are simply ignored; we only capture positive movements
- **Greedy is optimal:** Because every price increase is an independent opportunity with no cost to capture it

## Key Technique: Greedy Profit Capture
The pattern: when multiple transactions are allowed without penalty, capture every profitable opportunity. This transforms an optimization problem (find best sequence of transactions) into a simple accumulation problem (sum all positive changes). This pattern applies to any problem where gains are independent and accumulate without interference.

## Edge Cases to Remember
- **Single element:** No transactions possible, return 0
- **Monotonically increasing prices:** Maximum profit is difference between first and last
- **Monotonically decreasing prices:** No profit possible, return 0
- **All same prices:** No profit opportunity, return 0
- **Large price differences:** Works correctly with any magnitude of differences
