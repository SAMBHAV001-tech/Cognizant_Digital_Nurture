Hands-on 5 – One-to-Many Relationship

What is a One-to-Many Relationship in JPA
A One-to-Many relationship indicates that a single record of an entity is associated with multiple records of another entity. For example, a Department has many Employee records.

JPA Configuration
- @OneToMany: Mapped on the parent entity. We specify mappedBy = "department" to state that the department property in the child Employee entity owns the relationship.
- FetchType.LAZY: By default, @OneToMany uses LAZY fetching. This means employees are loaded from the database ONLY when department.getEmployeeList() is accessed.
- LazyInitializationException: If a LAZY collection is accessed outside a transaction context (when the Hibernate Session is closed), Hibernate throws a LazyInitializationException.
- FetchType.EAGER: We can change the fetch type to FetchType.EAGER to instruct Hibernate to load the collection immediately in a single database query.
