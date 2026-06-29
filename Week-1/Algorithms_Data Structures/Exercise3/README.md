Exercise 3 - Sorting Customer Orders


Bubble Sort

Bubble sort works by repeatedly going through the list and comparing adjacent elements. If they are in the wrong order, it swaps them. This process is repeated until the entire list is sorted. Each full pass through the array moves the largest unsorted element to its correct position at the end, like a bubble rising to the top. It is simple to understand and implement but very slow for large datasets.

Time complexity: O(n^2) in both average and worst case. Best case is O(n) only if the array is already sorted and an optimized version with an early exit flag is used.


Insertion Sort

Insertion sort builds the sorted list one item at a time. It takes each element and inserts it into its correct position among the already sorted elements on its left. It is efficient for small or nearly sorted datasets.

Time complexity: O(n^2) average and worst case. O(n) best case when the array is already sorted.


Merge Sort

Merge sort divides the array into two halves, recursively sorts each half, and then merges them back together in sorted order. It is a stable sort and always performs in O(n log n) time regardless of input, making it predictable and reliable.

Time complexity: O(n log n) in all cases. Requires extra space O(n) for the temporary arrays used during merging.


Quick Sort

Quick sort picks a pivot element and rearranges the array so all elements smaller than the pivot go to its left and all larger elements go to its right. It then recursively does the same for the left and right sides. It is usually faster in practice than merge sort because of better cache performance and lower constant factors.

Time complexity: O(n log n) average case. O(n^2) worst case when the pivot is always the smallest or largest element (e.g. already sorted array with last element as pivot). This can be avoided with random pivot selection.


Time Complexity Comparison

Bubble Sort    - Best: O(n), Average: O(n^2), Worst: O(n^2)
Insertion Sort - Best: O(n), Average: O(n^2), Worst: O(n^2)
Merge Sort     - Best: O(n log n), Average: O(n log n), Worst: O(n log n)
Quick Sort     - Best: O(n log n), Average: O(n log n), Worst: O(n^2)


Why Quick Sort is Generally Preferred

Quick sort is preferred in most real-world situations because it sorts in-place (no extra memory needed like merge sort) and its average case performance of O(n log n) is very efficient. Even though its worst case is O(n^2), this can be avoided in practice by choosing a good pivot (like picking the median or a random element). In actual tests with large data, quick sort tends to run faster than merge sort due to better CPU cache usage. Most standard library sorting functions (like Arrays.sort for primitives in Java) are based on quick sort variants.
