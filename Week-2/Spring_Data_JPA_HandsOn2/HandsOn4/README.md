Hands-on 4 – Many-to-One Relationship

What is a Many-to-One Relationship in JPA
A Many-to-One relationship indicates that multiple records of an entity are linked to a single record of another entity. For example, multiple Employee records belong to a single Department.

JPA Configuration
- @ManyToOne: Used to define the relationship mapping.
- @JoinColumn: Used to define the foreign key column mapping. In this project, @JoinColumn(name = "em_dp_id") indicates that the em_dp_id column in the employee table references the primary key of the department table.
- Lazy/Eager fetching: By default, @ManyToOne relationship utilizes FetchType.EAGER, meaning when you fetch an Employee, Hibernate will automatically perform a join query to load its associated Department.
