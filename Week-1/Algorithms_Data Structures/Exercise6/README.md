Exercise 6 - Library Management System


Linear Search

Linear search goes through every element in the list from the beginning until it finds a match or reaches the end. It does not require the data to be in any particular order. For a library with a small number of books or unsorted records, linear search is perfectly fine. It is easy to implement and works on any collection.

Time complexity: O(n) in average and worst case. O(1) best case if the book is the first element.


Binary Search

Binary search works on sorted data only. It checks the middle element and compares it to the target. If the target is smaller, it discards the right half. If larger, it discards the left half. It keeps doing this until it finds the target or determines it is not present. This makes it much faster than linear search for large datasets.

Time complexity: O(log n) in average and worst case. O(1) best case if the target is at the middle on the first check. Requires the array to be sorted first.


Comparison of Both Algorithms

Linear Search
- Works on unsorted data
- Time: O(n)
- Simple to implement
- Suitable for small or rarely searched collections

Binary Search
- Requires sorted data
- Time: O(log n)
- Slightly more complex
- Suitable for large and frequently searched collections


When Each Should Be Used

Linear search should be used when the data is unsorted and sorting would be too expensive, or when the list is small and the overhead of sorting is not worth it. It is also useful for one-time searches where maintaining a sorted structure is unnecessary.

Binary search should be used when the data is already sorted or when the same collection is searched many times. In a library where books are catalogued alphabetically by title, binary search is the natural choice. For a library with thousands of books, the difference between O(n) and O(log n) is very significant and binary search will perform much faster.
