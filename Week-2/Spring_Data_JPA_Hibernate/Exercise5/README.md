Exercise 5 – Query Methods

Query Customizations inside Spring Data JPA
Apart from derived queries, Spring Data JPA allows defining custom query logic using three primary annotations:
- @Query (HQL/JPQL): Defines standard object-oriented JPQL queries matching entity mappings.
- @Query (Native SQL): Specifying nativeQuery = true lets us run raw SQL directly.
- @NamedQuery & @NamedQueries: Configured directly on the entity class. These queries are predefined, precompiled, and named. Repository methods matching the named pattern (EntityName.methodName) will bind to them automatically.
