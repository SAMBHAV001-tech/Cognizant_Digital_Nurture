Hands-on 6 – Criteria Query

What is Criteria Query in JPA
Criteria Query is a type-safe API defined by the JPA specification for constructing database queries programmatically. This is useful for building dynamic queries (such as e-commerce product search pages) where search filter options (like price range, category, brand) are optional and built at runtime.

JPA Core Components
- CriteriaBuilder: Used to construct criteria queries, dynamic predicates, sorting rules, and projections. Obtained from the EntityManager.
- CriteriaQuery: Defines the query structure (select clause, from clause, where clause, group by).
- Root: Identifies the query root entity (equivalent to the FROM clause in SQL/HQL). Used to reference entity fields.
- TypedQuery: Wrapper that executes the query and returns typed result lists.
- Predicate: Represents individual filter conditions (e.g. name LIKE value, salary >= value).
