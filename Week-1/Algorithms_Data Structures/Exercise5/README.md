Exercise 5 - Task Management System


Singly Linked List

A singly linked list is a collection of nodes where each node holds some data and a reference (pointer) to the next node in the list. The last node points to null. Traversal can only happen in one direction, from head to tail. In this exercise, each Task node stores the task details and a next reference to the following task.


Doubly Linked List

A doubly linked list is similar but each node has two pointers, one to the next node and one to the previous node. This allows traversal in both directions. It uses more memory per node because of the extra pointer but makes operations like deletion easier since we can go backwards without needing to track the previous node separately.

Singly vs Doubly Linked List comparison:

Singly Linked List
- One pointer per node (next)
- Less memory per node
- Traversal in one direction only
- Deletion requires tracking previous node manually

Doubly Linked List
- Two pointers per node (next and prev)
- More memory per node
- Traversal in both directions
- Easier deletion since prev pointer is already stored


Operation Complexities

Add (at end)  - O(n) since we traverse to the last node to append. O(1) if we maintain a tail reference.
Search        - O(n) because we scan from head until we find the matching ID.
Traverse      - O(n) since every node is visited once.
Delete        - O(n) because we need to find the node before the target to update the next pointer.


Advantages Over Arrays

Linked lists do not require a fixed size at creation. Nodes are allocated dynamically as new tasks are added, so memory is only used when needed. Insertion at the beginning is O(1) while for an array it would be O(n) due to shifting. There is no wasted allocated space since each node is created on demand. However, linked lists use extra memory for the next pointer and do not support direct index-based access like arrays.
