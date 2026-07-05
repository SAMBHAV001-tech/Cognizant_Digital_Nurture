Exercise 2 – Creating JPA Entities

Entity Mappings inside JPA
Entities are lightweight persistent domain objects representing database schemas inside relational tables. We configure entities using annotations:
- @Entity: Marks a Java class as a JPA entity.
- @Table: Maps the entity class to a specific database table.
- @Id: Declares the primary key field.
- @GeneratedValue: Defines the primary key generation strategy (such as GenerationType.IDENTITY).
- @ManyToOne & @OneToMany: Mappings indicating database associations (e.g. One Department can have many Employee records).
