# Problem 150: Evaluate Reverse Polish Notation

## Problem Overview
Evaluate an expression written in Reverse Polish Notation (RPN), where operators come after their operands. For example, "2 3 +" means 2 + 3 = 5.

## Solution Approach: Stack-Based Evaluation

**Time Complexity:** O(n) where n is number of tokens  
**Space Complexity:** O(n)

**Technique:** Stack with Deferred Operations

## Core Concept
Iterate through each token. If it's a number, push it onto the stack. If it's an operator (+, -, *, /), pop the top two operands, apply the operator, and push the result back. At the end, the stack contains exactly one element: the result.

## Why This Works
RPN is designed to be evaluated with a stack. Numbers are operands pushed onto the stack. When an operator is encountered, its operands are guaranteed to be the two most recent elements pushed (top two of stack). The stack naturally maintains the correct operand pairing for each operator without needing parentheses or precedence rules.

## Important Insights
- **Stack order matters for non-commutative operations:** For "/" and "-", pop order is critical (second pop is first operand)
- **Guaranteed valid expression:** Problem states expression is valid, so stack always has exactly 2 elements when operator encountered
- **Integer division:** Use integer division (truncate toward zero) for "/" operator
- **Single result:** At end, stack has exactly one element if expression is valid
- **Why not recursive descent parser?** RPN is designed for stack evaluation; stack approach is more natural and efficient than parsing
- **Reverse operand access:** When you pop twice, you get operands in reverse order of appearance in RPN

## Key Technique: Stack for Deferred Computation
When operands must be accumulated before operations can be applied (RPN style), use a stack. This pattern applies to: expression evaluation, calculator problems, and any scenario where results depend on previous computations in a LIFO manner.

## Edge Cases to Remember
- **Single number:** Returns that number (no operators)
- **Multiple operations:** Each operator depends on previous results
- **Negative numbers:** Handled correctly during arithmetic
- **Division by zero:** Problem likely guarantees this won't happen; if not, add check
- **Integer division:** Ensure truncation toward zero is used (not floor division)
