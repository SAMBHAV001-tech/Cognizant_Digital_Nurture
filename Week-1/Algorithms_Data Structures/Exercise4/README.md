Exercise 4 - Employee Management System


Array Memory Representation

An array stores elements in contiguous memory locations. This means all elements are placed one after another in memory without any gaps. Each element can be accessed directly using its index because the memory address of any element is calculated as base address plus index times element size. This makes index-based access very fast.


Advantages of Arrays

Arrays provide O(1) time for accessing any element by index since the memory address is calculated directly. They are simple to use and understand. They have low memory overhead since there are no extra pointers or references stored alongside the data. Arrays are also cache-friendly because all elements are stored together in memory, which means the CPU can load multiple elements at once.


Operation Complexities

Add (at end)  - O(1) if space is available. O(n) if the array needs to be resized and elements copied.
Search by ID  - O(n) because we have to scan through each element one by one until we find a match.
Traverse      - O(n) since we visit every element once.
Delete        - O(n) because after removing an element we need to shift all subsequent elements left to fill the gap.


Limitations of Arrays

The size of an array must be decided at the time of creation and cannot be changed. If we allocate too much space, memory is wasted. If we allocate too little, we cannot add more elements. Insertion and deletion in the middle or at the beginning are expensive because elements must be shifted. Arrays do not support dynamic resizing by default in Java, which is why ArrayList was introduced as a flexible alternative.
