Exercise 8 – Projections

What is Database Projection in Spring Data JPA
When querying entities, loading the entire entity object graph with all properties and child associations is often redundant and hurts performance. Projections allow us to select only a subset of columns matching a customized payload structure.

Types of Projections
- Interface-based Projection: We define an interface containing getter signatures matching the property names of the entity. Spring Data JPA generates a proxy backing this interface dynamically.
- SpEL (Spring Expression Language) Projections: By using the @Value annotation on projection getters, we can concatenate properties dynamically (e.g. #{target.name + ' (' + target.department.name + ')'}).
- Class-based Projection (DTOs): We create a standard class with fields and a matching constructor. The repository method loads the data via a constructor expression JPQL select query (e.g. SELECT new Dto(e.id, e.name) FROM Employee e).
