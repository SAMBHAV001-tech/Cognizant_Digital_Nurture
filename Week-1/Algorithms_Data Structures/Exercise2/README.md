Exercise 2 - E-commerce Platform Search


Big-O Notation

Big-O notation is a way to describe how the time or space requirements of an algorithm grow as the input size grows. It gives us a rough idea of the worst-case performance so we can compare algorithms fairly. For example, O(1) means constant time no matter how big the input is, O(n) means time grows linearly with input size, and O(log n) means time grows much more slowly since we keep halving the problem.


Best, Average and Worst Case

Every algorithm can be analyzed in three scenarios.

Best case is when the algorithm finishes as quickly as possible. For linear search, best case is O(1) when the item is the very first element. For binary search, best case is also O(1) when the item is at the middle index on the first check.

Average case is the expected performance across all possible inputs. For linear search, the item is found somewhere in the middle on average, giving O(n/2) which simplifies to O(n). For binary search, the average case is O(log n).

Worst case is when the algorithm takes the longest possible time. For linear search, worst case is O(n) when the item is at the end or not present at all. For binary search, worst case is O(log n) because even in the worst case we keep dividing the array in half.


Comparison of Linear Search vs Binary Search

Linear search goes through each element one by one from the start until it finds the target. It works on any array, sorted or unsorted. It is simple to implement but slow for large datasets.

Binary search works by repeatedly dividing the search space in half. It checks the middle element and decides whether to search the left half or the right half. It is much faster than linear search but only works if the array is already sorted.

Linear Search
- Works on unsorted data
- Time complexity: O(n)
- Simple to write
- Fine for small lists

Binary Search
- Requires sorted data
- Time complexity: O(log n)
- Slightly more complex
- Much faster for large lists


Which is More Suitable and Why

For an e-commerce platform with thousands or millions of products, binary search is far more suitable because O(log n) is significantly faster than O(n). For example, searching through 1 million products takes up to 1 million steps with linear search, but at most around 20 steps with binary search. The trade-off is that the data must be sorted first, but since product names or IDs can be kept sorted in a database, this is easy to manage. If the data changes frequently and sorting is too costly, linear search on a small filtered subset might be acceptable as a fallback.
