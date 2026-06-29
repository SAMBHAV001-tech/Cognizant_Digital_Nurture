Exercise 7 - Financial Forecasting


Recursion

Recursion is when a method calls itself to solve a smaller version of the same problem. Every recursive method has a base case that stops the recursion and a recursive case that breaks the problem down. In this exercise, the future value of an investment is calculated by multiplying the current amount by the growth factor and then passing the result to the same method with one fewer year remaining. When the number of years reaches zero, the current amount is returned as the result.

Example: futureValue(10000, 0.08, 3) calls futureValue(10800, 0.08, 2) which calls futureValue(11664, 0.08, 1) which calls futureValue(12597.12, 0.08, 0) and returns 12597.12.


Recursive Time Complexity

The simple recursive version of this function calls itself exactly once per year, so the time complexity is O(n) where n is the number of years. Each call does a constant amount of work (one multiplication) and the call stack grows to a depth of n. This is fine for small values of n like 10 or 20 years.

However, in problems where the same sub-problem is solved multiple times (like Fibonacci), recursion becomes exponential O(2^n) without optimization.


How to Optimize Recursion

Memoization is the most common optimization for recursion. It means storing the result of each sub-problem the first time it is solved, and reusing that stored result instead of computing it again. This avoids redundant calculations.

In this exercise a memo array is used to store already computed future values. If a result for a given number of years has already been calculated, it is returned directly from the array instead of making another recursive call.

Another optimization is to convert recursion to iteration. A simple loop can replace the recursive future value calculation entirely: value = principal * (1 + rate) raised to the power of years. This avoids the overhead of recursive method calls and stack frames altogether, making it O(1) using Math.pow or O(n) with a plain loop.

For very large inputs where stack overflow could occur due to deep recursion, converting to an iterative approach is the safest solution.
