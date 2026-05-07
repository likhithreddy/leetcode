# Problem 20: Valid Parentheses

## Problem Overview
Given a string containing only parentheses, brackets, and braces, determine if the string is valid. A valid string requires: every opening bracket has a corresponding closing bracket in the correct order, and closing brackets match their corresponding opening brackets.

## Solution Approach: Stack-Based Validation

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

**Technique:** Stack with Bracket Matching

## Core Concept
Iterate through each character in the string. When you encounter an opening bracket ('(', '[', '{'), push it onto a stack. When you encounter a closing bracket (')', ']', '}'), check if the stack is empty (invalid) or if the top of the stack is the matching opening bracket. If it matches, pop the stack; if not, return false. At the end, the stack must be empty for validity.

## Why This Works
Parentheses matching is inherently a Last-In-First-Out (LIFO) problem. When you see a closing bracket, it must match the most recently unclosed opening bracket (which is at the top of the stack). The stack naturally handles nesting: when you push '(' then '[', the '[' sits on top and must be closed before '(' can be closed. If any mismatch occurs (e.g., '(' followed by ']'), the stack reveals the error immediately.

## Important Insights
- **Order is critical:** Stack enforces that closing brackets must match in reverse order of opening brackets (LIFO)
- **Empty stack on closing bracket:** Indicates unmatched closing bracket (no opening bracket to match)
- **Non-empty stack at end:** Indicates unclosed opening brackets
- **Efficiency:** Single pass, O(n) time, no sorting or complex preprocessing needed
- **Why not regex?** While possible, manual stack approach is more educational and shows understanding of the underlying logic
- **Pattern recognition:** In interleaving/nesting problems, stack is often the natural solution

## Key Technique: Stack for Nesting Validation
Whenever you have a problem about matching nested structures where order matters and most-recent-unclosed must match first, reach for a stack. This pattern applies to: HTML/XML tag matching, expression validation, undo/redo stacks, and many compiler parsing problems.

## Edge Cases to Remember
- **Empty string:** Valid (no brackets to match)
- **Single opening bracket:** Invalid (unclosed)
- **Single closing bracket:** Invalid (no corresponding opening)
- **Mismatched types:** '(' followed by ']' is invalid
- **Correct matching but wrong nesting:** '([)]' is invalid (interleaving not nesting)
