Hands-on 4 – Difference between JPA, Hibernate and Spring Data JPA

What is JPA (Java Persistence API)
JPA is a specification (a set of guidelines and interfaces) for Object-Relational Mapping (ORM) in Java. It defines how to manage relational data in Java applications. JPA itself is not a tool or a library; it is just a set of rules and interfaces (such as EntityManager, EntityManagerFactory, and annotations like @Entity, @Table, @Id) that other frameworks must implement.

What is Hibernate
Hibernate is a fully-featured Object-Relational Mapping (ORM) framework for Java. It is an implementation of the JPA specification. While JPA is the specification (the interface), Hibernate is the provider (the actual code that implements the interface and does the database operations). Hibernate also has its own custom features that are not part of the standard JPA specification.

What is Spring Data JPA
Spring Data JPA is a framework built on top of the JPA specification. It is not an ORM provider like Hibernate; instead, it uses a JPA provider (like Hibernate) under the hood. Spring Data JPA makes working with database repositories extremely simple by automatically implementing repository interfaces at runtime.

Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
| :--- | :--- | :--- | :--- |
| Type | Specification / API Standard | ORM Framework / Implementation | Repository abstraction layer |
| How to use | Defines annotations and interfaces | Implements JPA and provides Session / SessionFactory | Implements JpaRepository interface at runtime |
| Boilerplate Code | Medium | High (requires writing Session, Transaction, queries manually) | Extremely Low (methods automatically generated) |

Why Spring Data JPA Reduces Boilerplate Code
In traditional Hibernate or JPA, to perform simple CRUD operations, we had to write:
- Configuration code to load SessionFactory or EntityManagerFactory.
- Code to open Session or EntityManager.
- Code to begin a transaction, try-catch blocks to rollback, and commit code.
- Custom HQL/JPQL queries to fetch objects.

Spring Data JPA completely eliminates this boilerplate. By simply extending JpaRepository<Entity, ID>, Spring automatically provides implementations for all CRUD methods (like save(), findAll(), findById(), deleteById()) at runtime. We do not need to write any implementation code, open/close sessions, or manage database transactions manually.
