Exercise 3 – Creating Repositories

Derived Query Methods in Spring Data JPA
derived query methods allow us to define database queries simply by declaring method signatures in repository interfaces. Spring Data JPA parses the method name matching specific conventions (like findBy, readBy, queryBy, countBy) and automatically builds the JPQL query at runtime.

Query Conventions
- findByDepartmentId(Long departmentId): Automatically maps to a join query on the department relationship's id.
- findByEmail(String email): Automatically maps to a selection query on the email property.
- findByNameContaining(String name): Translates to an SQL LIKE query matching %name% on the name property.
