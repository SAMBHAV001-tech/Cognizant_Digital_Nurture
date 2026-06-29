Exercise 1 - Inventory Management System


Why Data Structures and Algorithms Matter for Inventory

In a real inventory system, thousands of products need to be stored and accessed quickly. If we just use a simple list and loop through it every time we want to find or update a product, it becomes very slow as the number of products grows. Good data structures help us store and retrieve data efficiently, and algorithms make sure we do operations in the least amount of time possible. In an inventory context, fast lookups for stock checking, quick updates when restocking, and efficient deletions when removing discontinued items all depend on choosing the right structure.


Suitable Data Structures

ArrayList - Works fine for small inventories. Easy to iterate. But searching by ID takes O(n) time since we have to go through each element one by one.

HashMap - Best choice here. It stores products with their productId as the key. Since HashMap uses hashing internally, we can find, update, or delete any product in O(1) average time. This is much better than ArrayList for large inventories where ID-based lookups are common.


Time Complexity of Operations

Operation       ArrayList           HashMap
Add             O(1) amortized      O(1) average
Update          O(n)                O(1) average
Delete          O(n)                O(1) average

With HashMap, all three main operations run in O(1) average time because we directly access the product using its ID as a key.


Possible Optimizations

If we also need to search by product name frequently, we could maintain a second HashMap with name as the key.

For very large inventories, a database with indexed columns would be even better.

If sorted output is needed often, a TreeMap can be used instead of HashMap. It keeps keys sorted but gives O(log n) for operations instead of O(1).

Caching recently accessed products can reduce lookup time in real systems.
