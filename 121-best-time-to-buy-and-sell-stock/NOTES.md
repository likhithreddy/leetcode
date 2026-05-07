# Problem 121: Best Time to Buy and Sell Stock

## Problem Overview
Given an array of stock prices where each element is the price on a given day, find the maximum profit you can achieve by buying on one day and selling on a later day. If no profit is possible, return 0.

## Solution Approach: Single Pass with Minimum Tracking

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Technique:** Single Scan with Running Minimum

## Core Concept
Maintain a variable tracking the minimum price seen so far. For each price, calculate the profit if you sold at that price (price - minPrice). Update the maximum profit if current profit is better. Update the minimum price if current price is lower. This single pass captures all possible buy-sell pairs implicitly.

## Why This Works
The maximum profit is achieved by buying at the lowest price before the selling point and selling at the highest price after the buying point. By tracking the minimum price encountered so far, you always have the best possible previous buying opportunity for each potential selling price. This transforms a problem that seems to require comparing all pairs (O(n²)) into a linear scan.

## Important Insights
- **Temporal constraint:** Must buy before selling; forward iteration naturally enforces this
- **Running minimum:** By updating minimum as you go, you automatically have the best buy price for each potential sell price
- **Profit calculation:** max(0, profit) handles case where no profit is possible; can never force a sell at loss if profit is negative
- **Why single pass?** If you need to compare with all previous values, iterate left-to-right tracking the best previous value
- **Efficiency insight:** This is a classic space-for-time trade: use O(1) space to remember one value (minimum) instead of checking all previous values

## Key Technique: Running Extremum Tracking
When you need to know the best value (min/max) seen so far at each position, maintain a running variable. This pattern works for: maximum profit, trap rain water, best time to buy/sell variants, and problems where current decision depends on extrema of past values.

## Edge Cases to Remember
- **Strictly decreasing prices:** Maximum profit is 0 (never buy)
- **Strictly increasing prices:** Buy at first, sell at last; maximum profit is last - first
- **Single price:** Return 0 (can't make transaction)
- **Two prices:** Return max(0, price[1] - price[0])
- **Multiple optimal solutions:** Algorithm finds one valid solution (correctness of profit, not necessarily indices)
