Hands-on 1 – Query Methods on Country Table

What are Spring Data JPA Query Creation Methods
Spring Data JPA has a powerful query builder mechanism that allows developers to define database queries simply by naming methods in the repository interface. The framework parses the method name and automatically generates the corresponding SQL query.

Query Creation Rules
- Naming convention: Method names starting with findBy, readBy, queryBy, or getBy indicate the start of a query.
- Subject: Properties of the entity are appended to the query. For example, findByName maps to the name field of the Country class.
- Operators: Keywords like Containing, StartingWith, GreaterThan, LessThan can be used to add comparison operators (LIKE, >, <, etc.) to the query.
- Sorting: Keywords like OrderBy followed by a property and direction (Asc or Desc) define sorting. For example, findByNameContainingOrderByNameAsc sorts matching countries in ascending order.
